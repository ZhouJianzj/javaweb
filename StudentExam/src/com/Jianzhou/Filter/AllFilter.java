package com.Jianzhou.Filter;



import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;


/**
 * @ClassName AllFilter
 * @Description TODO
 * @Author
 * @Date 2021/3/14
 **/
public class AllFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        //转型，得到里面的方法
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpServletRequest.getRequestURI();
        //请求地址中是否含有login的，有就放行
        if (requestURI.indexOf("Login") != -1 || requestURI.indexOf("login")!= -1 ||
                requestURI.indexOf("signIn")!= -1 || httpServletRequest.getSession(false) != null){
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
        } else{
           servletRequest.getRequestDispatcher("Login.html").forward(servletRequest,servletResponse);
        }


    }
}
