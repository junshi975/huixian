package com.huixian.center.filter;

import com.huixian.common.core.text.CharsetKit;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 字符集过滤器
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-27 14:57
 */
public class MyCharacterEncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding(CharsetKit.UTF_8);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        filterChain.doFilter(request, response);
    }

}
