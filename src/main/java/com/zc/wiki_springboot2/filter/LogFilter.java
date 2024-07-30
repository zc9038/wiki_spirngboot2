package com.zc.wiki_springboot2.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LogFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化操作
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 记录请求信息
        logger.info("Request - URL: {}, Method: {}, Remote Address: {}",
                httpRequest.getRequestURL(), httpRequest.getMethod(), httpRequest.getRemoteAddr());

        // 继续处理请求
        chain.doFilter(request, response);

        // 记录响应信息
        logger.info("Response - Status: {}", httpResponse.getStatus());
    }

    @Override
    public void destroy() {
        // 销毁操作
    }
}
