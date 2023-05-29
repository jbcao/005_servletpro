package com.practise.e_httpservletresponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * 功能
 *
 * @author caojianbang
 * @date 15.4.22 6:23 AM
 */
@WebServlet("/ResponseServlet")
public class ResponseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pr=response.getWriter();
        pr.println("hello22");
        OutputStream os=response.getOutputStream();
        os.write("将字符串放到字符数组，演示getoutputstream回送字符".getBytes());

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
