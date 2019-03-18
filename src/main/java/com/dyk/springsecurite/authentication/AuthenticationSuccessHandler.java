package com.dyk.springsecurite.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Authentication Success Handler
 */
@Component("myAuthenticationSuccessHandler")
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler
{
    @Autowired
    /**
     * ObjectMapper pour transfomer authentication en format json
     */
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Authentication authentication) throws IOException, ServletException {
            // 1,retourner en format json
//            httpServletResponse.setContentType("application/json;charset=UTF-8");
//            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(authentication));
       //2,retourner en route original
        super.onAuthenticationSuccess(httpServletRequest,httpServletResponse,authentication);

    }
}
