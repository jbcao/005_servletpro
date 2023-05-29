package com.practise.l_servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 功能
 *
 * @author caojianbang
 * @date 15.5.22 2:44 AM
 */
@WebServlet("/ServletContext2")
public class ServletContext2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        /**
         * 取出servletContext属性
         * 先获取servletContext引用
         * 再取出属性
         * 引用始终是同一个
         */
        ServletContext servletContext = this.getServletContext();
        /**
         * 取出的属性是什么类型，就得转成什么类型
         */
        String val= (String) servletContext.getAttribute("uname");
        out.println("val 删除前"+val);
        servletContext.removeAttribute("uname");
        String val2= (String) servletContext.getAttribute("uname");
        out.println("val 删除后"+val2);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
