/*
 *  omniSecurityHandler.java
 */
package com.omni.rest.config.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * This class is {@link omniSecurityHandler} omni config class.
 */
public class OmniSecurityHandler implements AccessDeniedHandler {

    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException exc) throws IOException, ServletException {
        JSONObject jObject = new JSONObject();
        jObject.put("status", "403");
        jObject.put("error", "Verify abilities");
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse
                .setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setContentType("application/json");
        httpServletResponse.getWriter().write(jObject.toString());
    }
}
