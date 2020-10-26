package com.omni.rest.controller;

import com.omni.core.exceptions.OmniException;
import com.omni.core.model.*;
import com.omni.core.service.*;
import com.omni.core.utils.OmniCoreConstants;
import com.omni.core.utils.OmniCoreUtils;
import com.omni.core.utils.VerifyRecaptcha;
import com.omni.rest.dto.ClientDto;
import com.omni.rest.dto.OrganisationDto;
import com.omni.rest.dto.UserDto;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("currentUser")
@RequestMapping("/user")
public class UserController extends AbstractController {

    private static final Logger LOGGER = OmniCoreUtils.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private OrganisationService organisationService;

    private UserDto convertToUserDto(User user) {
        return mapper.map(user, UserDto.class);
    }

    @ModelAttribute("currentUser")
    public User getCurrentUser() {
        final User user;
        user = userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user != null) {
            user.setIsOrganisation(organisationService.findOrganisationByUser(user) != null);
            user.setIsClient(clientService.findClientByUser(user) != null);
        }
        return user;
    }

    @RequestMapping("/layout")
    public String getHomePartialPage() {
        return "home";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
    @Transactional
    public boolean login(
            HttpServletRequest request,
            Authentication authentication
    ) throws OmniException {
        LOGGER.debug("UserController - login");
        return true;
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(HttpServletRequest request, HttpServletResponse response) throws OmniException {
        LOGGER.debug("UserController - logout");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        } else {
            request.getSession().invalidate();
        }
    }

    @RequestMapping(value = "/currentUser", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
    public UserDto currentUser(@ModelAttribute("currentUser") User currentUser, HttpServletResponse response) throws OmniException {
        LOGGER.debug("UserController - currentUser - " + currentUser.getEmail());
        return convertToUserDto(currentUser);
    }

    /**
     * retourne l'utilisateur courant.
     *
     * @param currentUser
     * @param response la reponse
     * @return
     * @throws OmniException
     */
    @RequestMapping(value = "/getCurrentUser", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
    public UserDto getCurrentUser(@ModelAttribute("currentUser") User currentUser, HttpServletResponse response) throws OmniException {
        LOGGER.debug("UserController - getCurrentUser - " + currentUser.getEmail());
        return convertToUserDto(userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
    }

    @RequestMapping(value = "/all", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
    public List<UserDto> getUsers(HttpServletRequest request, HttpServletResponse response) throws OmniException {
        LOGGER.debug("UserController - getUsers");
        List<User> users = userService.getAllUsers();
        return users.stream()
                .map(this::convertToUserDto)
                .collect(Collectors.toList());
    }

    //  Subscribe as Client
    @RequestMapping(value = "/subscribe/client", method = {RequestMethod.PUT})
    @ResponseBody
    public boolean subscribeClient(
            HttpServletRequest request,
            @RequestBody ClientDto clientDto
    ) {
        if (VerifyRecaptcha.verify(request.getParameter("captcha"))) {
            if (userService.verifyEmailExiste(clientDto.getUser().getEmail())) {
                return false;
            }
            Client client = mapper.map(clientDto, Client.class);

            client.getUser().setRefUser(OmniCoreUtils.genereReference(clientDto.getPrenom(), "CLIENT"));
            client.getUser().setProvider("OMNIPIGEON");
            client.getUser().setFlagUser(false);

            // Set password as hashed pass
            client.getUser().setPassword(userService.getHashUserPassword(clientDto.getUser().getPassword()));
            client.getUser().setToken(OmniCoreUtils.generateToken(128));
            client.getUser().setTokenNumber(OmniCoreUtils.generateNumber(6));
            client.getUser().setInitial(client.getPrenom().substring(0, 1).toUpperCase());
            if (clientService.save(client) != null) {
//                mailService.sendMailSubsribeClient(client);
                return true;
            }
        }
        return false;
    }

    //   Subscribe as Client via Facebook or Google
    @RequestMapping(value = "/subscribe/client/social/{provider}", method = {RequestMethod.PUT})
    @ResponseBody
    public boolean subscribeClientSocial(
            HttpServletRequest request,
            @PathVariable String provider,
            @RequestBody ClientDto clientDto
    ) {
        if (VerifyRecaptcha.verify(request.getParameter("captcha"))) {
            if (userService.verifyEmailExiste(clientDto.getUser().getEmail())) {
                return false;
            }
            Client client = mapper.map(clientDto, Client.class);
            client.getUser().setProvider(provider);
            client.getUser().setFlagUser(true);
            client.getUser().setRefUser(OmniCoreUtils.genereReference(clientDto.getPrenom(), "CLIENT"));
            client.getUser().setInitial(client.getPrenom().substring(0, 1).toUpperCase());
            if (clientService.save(client) != null) {
//                mailService.sendMailSubsribeClientSocial(client);
                return true;
            }
        }
        return false;
    }

    
    //Subscribe as Organisation
    @RequestMapping(value = "/subscribe/organisation", method = {RequestMethod.PUT})
    @ResponseBody
    public boolean subscribeOrganisation(
            HttpServletRequest request,
            @RequestBody OrganisationDto organisationDto
    ) {
        if (VerifyRecaptcha.verify(request.getParameter("captcha"))) {
            if (userService.verifyEmailExiste(organisationDto.getUser().getEmail())) {
                return false;
            }
            Organisation _organisation = mapper.map(organisationDto, Organisation.class);
            _organisation.getUser().setFlagUser(false);
            _organisation.getUser().setProvider("OMNIPIGEON");
            _organisation.getUser().setRefUser(OmniCoreUtils.genereReference(organisationDto.getDenomination(), "ORGANISATION"));
            _organisation.getUser().setTokenNumber(OmniCoreUtils.generateNumber(6));
            // Set password as hashed pass
            _organisation.getUser().setPassword(userService.getHashUserPassword(organisationDto.getUser().getPassword()));
            _organisation.getUser().setToken(OmniCoreUtils.generateToken(128));
            _organisation.getUser().setAvatar(OmniCoreConstants.DEFAULT_AVATAR_ORGANISATION);

            Integer organisationWithSameName = organisationService.countByDenomination(_organisation.getDenomination());
            String alias = OmniCoreUtils.parseStringToHTMLAlias(_organisation.getDenomination());
            _organisation.setAliasOrganisation(organisationWithSameName > 0 ? alias + "-" + (organisationWithSameName + 1) : alias);
            _organisation.setDenomination(_organisation.getDenomination());

            // Save and Send Mail
            if (organisationService.save(_organisation) != null) {
//                mailService.sendMailSubsribeOrganisation(_organisation);
                return true;
            }
        }
        return false;
    }
    //Update user info
    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    @ResponseBody
    public boolean updateUser(
            @RequestBody UserDto user,
            @ModelAttribute("currentUser") User currentUser
    ) {
        // Reject subscription with mail already in db
        if (!user.getEmail().equalsIgnoreCase(currentUser.getEmail())) {
            if (userService.verifyEmailExiste(user.getEmail())) {
                return false;
            }
        }
        //Get originals data
        user.setUserId(currentUser.getUserId());
        user.setPassword(currentUser.getPassword());
        user.setFlagUser(currentUser.getFlagUser());
        user.setRefUser(currentUser.getRefUser());
        return userService.save(mapper.map(user, User.class)) != null;

    }

    @Transactional
    @RequestMapping(value = "/isOrganisation", method = {RequestMethod.GET})
    @ResponseBody
    public boolean isOrganisation(@ModelAttribute("currentUser") User currentUser) throws OmniException {
        LOGGER.debug("UserController - isOrganisation");
        return currentUser != null && currentUser.isOrganisation();
    }

    @Transactional
    @RequestMapping(value = "/isClient", method = {RequestMethod.GET})
    @ResponseBody
    public boolean isClient(@ModelAttribute("currentUser") User currentUser) throws OmniException {
        LOGGER.debug("UserController - isClient");
        return currentUser != null && currentUser.isClient();
    }

    @RequestMapping(value = "/verifyLoginExiste", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
    public boolean verifyLoginExiste(
            @RequestParam(value = "login") String login,
            @RequestParam(value = "captcha") String captcha,
            HttpServletResponse response
    ) throws OmniException {
        if (VerifyRecaptcha.verify(captcha)) {
            return userService.verifyEmailExiste(login);
        }
        return false;
    }

    @RequestMapping(value = "/modifyPassword", method = {RequestMethod.GET})
    @ResponseBody
    public boolean modifyPassword(
            @RequestParam(value = "plainTextPassword") String plainTextPassword,
            @ModelAttribute("currentUser") User currentUser,
            HttpServletResponse response
    ) throws OmniException {
        String newPassword = userService.getHashUserPassword(plainTextPassword);
        currentUser.setPassword(newPassword);
        return userService.modifyPassword(currentUser);
    }

    @RequestMapping(value = "/resetPassword", method = {RequestMethod.GET})
    @ResponseBody
    public boolean resetPassword(
            @RequestParam(value = "plainTextPassword") String plainTextPassword,
            @RequestParam(value = "token") String token,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "captcha") String captcha,
            HttpServletResponse response
    ) throws OmniException {
        if (VerifyRecaptcha.verify(captcha)) {
            String newPassword = userService.getHashUserPassword(plainTextPassword);
            final User user;
            user = userService.getUserByTokenAndEmail(token, email);
            if (user != null) {
                user.setPassword(newPassword);
                user.setFlagUser(true);
                return userService.modifyPassword(user);
            }
        }
        return false;
    }

    @RequestMapping(value = "/forgotPassword", method = {RequestMethod.GET})
    @ResponseBody
    public void forgotPassword(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "captcha") String captcha,
            HttpServletResponse response
    ) {
        if (VerifyRecaptcha.verify(captcha)) {
            userService.forgotPassword(email);
        }
    }

    @RequestMapping(value = "/sendNewCodeValidation", method = {RequestMethod.GET})
    @ResponseBody
    public void sendNewCodeValidation(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "captcha") String captcha,
            HttpServletResponse response
    ) {
        if (VerifyRecaptcha.verify(captcha)) {
            userService.sendNewCodeValidation(email);
        }
    }

    @Transactional
    @RequestMapping(value = "/validateUserToken", method = {RequestMethod.GET})
    @ResponseBody
    public boolean validateUserToken(
            @RequestParam(value = "token") String token,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "captcha") String captcha,
            HttpServletResponse response
    ) throws OmniException {
        if (VerifyRecaptcha.verify(captcha)) {
            final User user;
            user = userService.getUserByTokenAndEmail(token, email);
            if (user != null) {
                userService.validateUser(user);
                return true;
            }
        }
        return false;
    }

    @Transactional
    @RequestMapping(value = "/validateForgot", method = {RequestMethod.GET})
    @ResponseBody
    public boolean validateForgot(
            @RequestParam(value = "token") String token,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "captcha") String captcha,
            HttpServletResponse response
    ) throws OmniException {
        if (VerifyRecaptcha.verify(captcha)) {
            final User user;
            user = userService.getUserByTokenAndEmail(token, email);
            if (user != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * ping un user.
     *
     * @param currentUser
     *
     * @return
     * @throws OmniException
     */
    @RequestMapping(value = "/ping", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    @ResponseBody
    public boolean pingUser(@ModelAttribute("currentUser") User currentUser) throws OmniException {
        LOGGER.debug("UserController - pingUser - " + currentUser.getEmail());
        return true;
    }

}
