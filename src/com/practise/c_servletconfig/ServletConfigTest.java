package com.practise.c_servletconfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 功能
 *
 * @author caojianbang
 * @date 12.4.22 12:10 AM
 */
public class ServletConfigTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String encoding = this.getServletConfig().getInitParameter("encoding");
        System.out.println(encoding);
        response.setCharacterEncoding(encoding);
        ServletContext servletContext = this.getServletContext();
        String p=servletContext.getInitParameter("encoding11");
        System.out.println(p);
        Enumeration<String> names=this.getServletConfig().getInitParameterNames();
        while(names.hasMoreElements()){
            String name=names.nextElement();
            System.out.println(name);
            System.out.println(this.getServletConfig().getInitParameter(name));
        }
    }
}
