package com.hanjie.opt.example.filter;



import kim.hanjie.common.opt.OptContext;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * @author han
 * @date 2021/3/12
 */
public class UserOptContextFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        OptContext.put("userId", "" + 100);
        OptContext.put("reqId", UUID.randomUUID().toString());
        OptContext.put("url", httpRequest.getRequestURI());
        chain.doFilter(request, response);
        OptContext.clean();
    }
}
