package com.user.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 首页如果使用html的话，能力比较弱，稍微涉及一点动态功能，都没法解决
 * 所以使用servlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 返回一个html页面
         * 用下面的方法写html不容易出错
         */
        response.setContentType("text/html;charset=gbk");
        //response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<img src='img/bg.jpg' width=100px /><hr/>");
        out.println("   ");
//		action是有规范的 /web应用名/servlet的URL
//		即URI
        //同一层的可以不带/web应用名
        //但是最好带上
        out.println("<form action='/servletpro/LoginClServlet' method='post'>");
        out.println("用户ID：<input type='text' name='id'/><br/>");
        out.println("密　码：<input type='password' name='password'/><br/>");
        out.println("<input type='submit' value='登录'/><br/>");
        out.println("</form>");
        /**
         * 先获取到，再进行判断
         */
        String err = (String) request.getAttribute("err");
        if (err != null) {
// 穿的的就是string类型
// 如果依旧是object ,那么界面上的提示信息会一直存在
// 只记得正确的方式，错误的情况有千千万万种
            out.println(err);

        }
        out.println("<hr/><img src='img/year.jpeg' width=100px />");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
