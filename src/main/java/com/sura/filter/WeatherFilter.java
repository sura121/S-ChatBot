package com.sura.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;

@Component
@Slf4j
public class WeatherFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        filterChain.doFilter(req, res);

        log.info("request Body : " + req.getContentType());

        log.info("Starting a transaction for req : {}", req.getRequestURI());
        log.info("Committing a transaction for req : {}", req.getRequestURI());
    }

    @Override
    public void destroy() {

    }

}


