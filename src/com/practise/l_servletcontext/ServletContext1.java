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
 * @date 15.5.22 2:16 AM
 */
@WebServlet("/ServletContext1")
public class ServletContext1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        /**
         * this是从父类出来的
         * 两种方式都可以
         * 存放的值是对象类型
         * 可以完成聊天室功能
         * 可以完成在线人数统计
         * 不用操作数据库，文件，性能就提升上去了
         */
        ServletContext servletContext = this.getServletContext();
        ServletContext servletContext1 = this.getServletConfig().getServletContext();
        servletContext.setAttribute("uname","caojianbang");
        PrintWriter out = response.getWriter();
        out.println("写入一个属性到servletContext");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
