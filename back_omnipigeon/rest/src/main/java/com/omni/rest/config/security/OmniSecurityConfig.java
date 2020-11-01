/*
 *  omniSecurityConfig.java
 */
package com.omni.rest.config.security;

import com.omni.rest.utils.OmniRestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;

/**
 * This class is {@link omniSecurityConfig} config class.
 */
@Configuration
@EnableWebSecurity
public class OmniSecurityConfig extends
        WebSecurityConfigurerAdapter {

    @Autowired
    private OmniAuthenticationProvider authProvider;

    @Bean
    public HeaderHttpSessionStrategy sessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] patternsPermit = new String[]{
            "/",
            "/resources/**/*",
            //------------ User --------------
            "/user/login",
            "/user/logout",
            "/user/getHashUserPassword",
            "/user/validateUserToken",
            "/user/validateForgot",
            "/user/sendNewCodeValidation",
            "/user/resetPassword",
            "/user/forgotPassword",
            "/user/verifyLoginExiste",
            "/user/subscribe/client",
            "/user/subscribe/client/social/*",
            "/user/subscribe/organisation",
            "/user/isOrganisation",
            "/user/isClient",
            //------------ Organisation ----------
            "/organisation/byAliasOrganisation",
            "/organisation/get-alias/*",
            "/organisation/all",
            "/organisation/organisationById",
            //------------ Client ----------
            "/client/all",
            "/client/clientById",
            /**
             * ******* Référentiels****************
             */
            "/referentiel/produit/all",
            "/referentiel/couleur/all",
            "/referentiel/caracteristique/all",
            /**
             * ******* Pigeon****************
             */
            "/pigeon/all",
            "/pigeon/pigeonById",
<<<<<<< .mine
             "/pigeon/save",
||||||| .r25
=======
            "/pigeon/save",
>>>>>>> .r31
            /**
             * ****** StationElevage****************
             */
            "/station/all",
            "/station/stationById",
<<<<<<< .mine
             "/station/save",
||||||| .r25
=======
            "/station/save",
>>>>>>> .r31
            /**
             * ******* Acteur****************
             */
            "/acteur/all",
            "/acteur/acteurById",
            "/acteur/save",
            /**
             * *******Enchere****************
             */
            "/enchere/all",
            "/enchere/enchereById",
<<<<<<< .mine
             "/enchere/save",
||||||| .r25
=======
            "/enchere/save",
>>>>>>> .r31
            /**
             * ******* Evenement****************
             */
            "/evenement/all",
<<<<<<< .mine
            "/evenement/evenementById",
            "/evenement/save"
                
             
||||||| .r25
            "/evenement/evenementById"
                
             
=======
            "/evenement/evenementById",
            "/evenement/save",
            "/evenement/deleteById"
>>>>>>> .r31

        };

        // Private services
        String[] patternsDeny = new String[]{
            //------------ User --------------
            "/user/verifyConnexion",
            "/user/currentUser",
            "/user/getCurrentUser",
            "/user/save",
            "/user/ping",
            "/user/modifyPassword",
            //------------ Client ----------
            "/client/save",
            "/client/currentClient",
            //------------ Organisation ----------
            "/organisation/currentOrganisation",
            "/organisation/save",};

        http.authorizeRequests().
                antMatchers(HttpMethod.OPTIONS, patternsDeny).permitAll().
                antMatchers(patternsPermit).permitAll().
                antMatchers(patternsDeny).hasAuthority(OmniRestConstants.USER_ROLE).anyRequest().authenticated().
                and().requestCache().requestCache(new NullRequestCache()).
                and().csrf().disable().
                httpBasic().authenticationEntryPoint(new OmniAuthenticationEntryPoint());
        http.headers()
                .frameOptions().sameOrigin();

        http.exceptionHandling()
                .accessDeniedHandler(new OmniSecurityHandler());

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

}
