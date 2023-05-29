package com.practise.d_http.a_request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能:防止盗链
 *
 * 1:直接请求servler
 * 2:一个页面。里面有超链接，连接过来
 * 3：本网站页面链接过来
 * 4：其他网站：
 *
 * @author caojianbang
 * @date 14.4.22 1:26 PM
 */
@WebServlet("/Referer")
public class Referer extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String referer = request.getHeader("referer");
        System.out.println("referer是"+referer);
        if(referer==null||!referer.startsWith("http://localhost:8080/UserManager")){
            response.sendRedirect("/UserManager/Error");
            return;
        }
        response.getWriter().println("这是一个测试防盗链的页面");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
