package com.sura.filter;

import com.sura.config.MyHttpServletWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

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

        MyHttpServletWrapper requestWrapper = null;

        try {

            requestWrapper = new MyHttpServletWrapper(req);

        }catch (Exception e) {
            e.getStackTrace();
        }

        filterChain.doFilter(requestWrapper, res);

        log.info("Starting a transaction for req : {}", req.getRequestURI());
        log.info("Committing a transaction for req : {}", req.getRequestURI());
    }

    @Override
    public void destroy() {

    }

}


