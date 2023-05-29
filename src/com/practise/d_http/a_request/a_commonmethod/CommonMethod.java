package com.practise.d_http.a_request.a_commonmethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 功能:练习httpservletrequest的一些常用方法
 *
 *
 * @author caojianbang
 * @date 20.4.22 4:35 PM
 */
@WebServlet("/CommonMethod")
public class CommonMethod extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String s = request.getRequestURL().toString();
        System.out.println(s);
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        String queryString = request.getQueryString();
        System.out.println(queryString);
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
        if(remoteAddr.equals("192.168.20.136")){
            response.sendRedirect("/servletpro/Err");
        }
        String remoteHost = request.getRemoteHost();
        System.out.println(remoteHost);
        int remotePort = request.getRemotePort();
        System.out.println("客户机使用的端口号"+remotePort);
        int localPort = request.getLocalPort();
        System.out.println("服务器端口号"+localPort);
        String host = request.getHeader("Host");
        System.out.println(host);
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String s1 = headerNames.nextElement();
            System.out.println(request.getHeader(s1));

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
