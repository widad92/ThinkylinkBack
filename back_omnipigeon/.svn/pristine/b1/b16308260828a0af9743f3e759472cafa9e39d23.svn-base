/**
 * AvisController.java
 */
package com.omni.rest.controller;

import com.omni.core.exceptions.OmniException;
import com.omni.core.model.TokenUserPwa;
import com.omni.core.service.TokenUserPwaService;
import com.omni.core.service.UserService;
import com.omni.core.utils.OmniCoreUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This class is {@link CommandeController} used to create Rest Commande
 * ressource.
 *
 * @author
 *
 */
@Controller
@RequestMapping("/userTokenPwa")
public class UserTokenPwaController extends AbstractController {

    private static final Logger LOGGER = OmniCoreUtils.getLogger(UserTokenPwaController.class);

    @Autowired
    private TokenUserPwaService tokenUserPwaService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
    
    public boolean saveTokenPwa(@RequestParam(value = "tokenPwa") String token, HttpServletRequest request, HttpServletResponse response) throws OmniException {
        LOGGER.debug("UserTokenPwaController - saveTokenPwa");
        TokenUserPwa tokenUserPwa = new TokenUserPwa();
        tokenUserPwa.setToken(token);
        tokenUserPwa.setUser(userService.getCurrentUser());
        return tokenUserPwaService.save(tokenUserPwa) != null;
    }
    
    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
    
    public boolean deleteTokenPwa(@RequestParam(value = "tokenPwa") String token, HttpServletRequest request, HttpServletResponse response) throws OmniException {
        TokenUserPwa tokenUserPwa = new TokenUserPwa();
        tokenUserPwa.setToken(token);
        return tokenUserPwaService.delete(tokenUserPwa);
    }

}
