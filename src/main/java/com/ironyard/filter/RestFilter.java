package com.ironyard.filter;

import com.ironyard.secure.TokenCheck;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by rohanayub on 2/21/17.
 */
@WebFilter (filterName = "RestFilter")
public class RestFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        boolean authorized = false;
        String authToken = req.getHeader("x-authorization-key");
        TokenCheck tc = new TokenCheck();
        if(authToken != null && tc.validate(authToken)){
            filterChain.doFilter(req, res);
        }else{
            res.getWriter().write("Unauthorized for this action.");
        }

    }

    @Override
    public void destroy() {

    }
}

