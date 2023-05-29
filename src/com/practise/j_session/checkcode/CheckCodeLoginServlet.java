package com.practise.j_session.checkcode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 验证码登录页面
 */
@WebServlet("/CheckCodeLoginServlet")
public class CheckCodeLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public CheckCodeLoginServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=gbk");
        PrintWriter out = response.getWriter();
        out.println("<img src='img/lea.gif' width=100px /><hr/>");
        out.println("<h1>用户登录</h1>");
        out.println("<form action='/servletpro/CheckCodeLoginController' method='post'>");
        out.println("用户ID：<input type='text' name='id'/><br/>");
        out.println("密　码：<input type='password' name='password'/><br/>");
        /**
         *        验证码
         *        <img>浏览器会单独发一个请求
         *        图片就是写回来的，都是文件，文件及时流，就是字符串
         *        看的电影也是这么回来的
         */
        out.println("密　码：<input type='text' name='checkcode'/><img src='/servletpro/CreateCode' /><br/>");
        out.println("<input type='submit' value='登录'/><br/>");
        out.println("</form>");
        /**
         * 先获取到，再进行判断
         */
        String err = (String) request.getAttribute("err");
        if (err != null) {
            out.println(err);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
