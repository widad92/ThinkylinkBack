/*
 *omniAuthenticationProvider.java
 */
package com.omni.rest.config.security;

import com.omni.core.exceptions.OmniException;
import com.omni.core.model.User;
import com.omni.core.service.UserService;
import com.omni.core.utils.OmniCoreUtils;
import com.omni.core.utils.VerifyRecaptcha;
import com.omni.rest.utils.OmniRestConstants;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * This class is {@link omniAuthenticationProvider} security rules class.
 */
public class OmniAuthenticationProvider implements AuthenticationProvider {

    private static final Logger LOGGER = OmniCoreUtils.getLogger(OmniAuthenticationProvider.class);

    @Autowired
    private UserService userService;

    @Autowired(required = true)
    private HttpServletRequest request;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        LOGGER.info("authenticate");
        try {
            String name = authentication.getName();
            String password = authentication.getCredentials().toString();
            boolean successfullLogin = false;
            User user = new User(name, password);
            UsernamePasswordAuthenticationToken auth = null;

            if (!VerifyRecaptcha.verify(request.getParameter("captcha"))) {
                throw new OmniException("Invalid captcha");
            }

            if (request.getParameter("provider").equals("TOKEN")) {
                User bddUser = userService.getUserByTokenAndEmail(password, name);
                if (bddUser == null || !bddUser.getFlagUser()) {
                    throw new OmniException("Invalid email/token combo");
                }
                bddUser.setToken(null);
                userService.save(bddUser);
                successfullLogin = true;
            } else {
                successfullLogin = userService.authenticateUser(user, request.getParameter("provider"));
            }

            if (successfullLogin) {
                User _user = userService.getUserByEmail(name);
                List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
                grantedAuthorities.add(new SimpleGrantedAuthority(OmniRestConstants.USER_ROLE));
                
                if (_user.getRefUser().startsWith("ADMIN")) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(OmniRestConstants.ADMIN_ROLE));
                }
                auth = new UsernamePasswordAuthenticationToken(name, password,
                        grantedAuthorities);
                LOGGER.info("Succesful Authentication with user = " + name);
            }
            return auth;
        } catch (OmniException ex) {
            LOGGER.error("authenticate - " + ex.toString());
            throw new BadCredentialsException("User or password incorrect");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
