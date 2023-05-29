package com.user.view;

import com.user.domain.User;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         *一个网站一般都有百十来个页面，如果每个地方都写一个这样的内容，会很麻烦
         * 有两个解决该方案
         * 1：封装成函数，每个需要使用的时候，进行调用
         * 2：过滤器，虽然很重要，但是讲起来只需要10分钟时间
         * 过滤器：每访问一个地方都要对你进行一个筛选
         * 就好像进大门，保安，觉得你是一个坏人，通缉犯，就不让进，觉得你是一个好人，就可以进来
         * 过滤器和监听器一起讲
         * 用过滤器。也还是走session，没有session，也还是行不通
         */
        User user = (User) request.getSession().getAttribute("login");
        if(user==null){
            /**
             * 不要觉得神奇，之前就有一个地方进行接收了
             */
            request.setAttribute("err","轻输入用户名和密码登录");
            request.getRequestDispatcher("/CheckCodeLoginServlet").forward(request,response);
            /**
             *  重要：必须哟啊加return，终止函数执行，不然会将整个走完再去挑转
             *  如果下面还有一个跳转的话，就会报一个500错误
             */
            return;
        }
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<img src='img/lea.gif' width=100px /><hr/><h1>欢迎登录</h1><a href='/servletpro/CheckCodeLoginServlet'>返回登录界面<a/>");
        writer.println("<h3>选择需要进行的操作<h3/>");
        writer.println("<a href='/servletpro/ManageUsers'>管理用户<a/><br/>");
        /**
         * 添加过不过控制器
         * 本来也可以不过，因为不需要传递信息
         * 但最好过一下，防止将来会有扩展
         */
        writer.println("<a href='/servletpro/UserClServlet?type=gotoAddUser'>添加用户<a/><br/>");
        writer.println("<a href=''>查找用户<a/><br/>");
        writer.println("<a href=''>退出系统<a/><br/>");
        writer.println("<hr/><img src='img/stu.jpg' width=100px />");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
