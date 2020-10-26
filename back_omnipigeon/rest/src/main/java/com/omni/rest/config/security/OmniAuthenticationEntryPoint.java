/*
 *  omniAuthenticationEntryPoint.java
 */
package com.omni.rest.config.security;

import java.io.IOException;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * This class is {@link omniAuthenticationEntryPoint} omni config class.
 */
public class OmniAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException e) throws IOException {
        JSONObject jObject = new JSONObject();
        jObject.put("status", "401");
        jObject.put("error", "Verify login and password");
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse
                .setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(jObject.toString());
    }
}
