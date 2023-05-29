package com.practise.l_servletcontext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * 功能:读取配置文件
 *
 * @author caojianbang
 * @date 15.5.22 4:51 AM
 */


@WebServlet("/ServletContext5")
public class ServletContext5 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        InputStream resourceAsStream = this.getServletContext().getResourceAsStream("dbinfo1.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        out.println("user为：" + properties.getProperty("user"));
        String realPath = this.getServletContext().getRealPath("/img/dog.jpeg");
        out.println("路径："+realPath);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
