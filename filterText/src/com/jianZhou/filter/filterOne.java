package com.jianZhou.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName filterOne
 * @Description TODO
 * @Author
 * @Date 2021/3/12
 **/
public class filterOne implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //需要到.xml文件中配置一下
        System.out.println("实现过滤了");

//        filterChain.doFilter(servletRequest,servletResponse);
    }
}
