package com.springsecurity.filter;

import jakarta.servlet.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.logging.Logger;

public class AuthoritiesAfterLogingintoFilter implements Filter
        {
            private final Logger logger =Logger.getLogger(AuthoritiesAfterLogingintoFilter.class.getName());


            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                    throws IOException, ServletException {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                if(null!=authentication)
                {
                    logger.info("Authentication is sucessfull");
                }
                else
                {
                    logger.info("Authentication Failed");
                }
                chain.doFilter(request,response);


            }
        }
