package com.user.view;

import com.user.domain.User;
import com.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

/**
 * 功能
 *
 * @author caojianbang
 * @date 24.4.22 4:49 PM
 */
@WebServlet("/ManageUsers")
public class ManageUsers extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
/**
 *安 全退出也涉及许多东西，要讲session清空
 *
 */
        out.println("<img src='img/lea.gif' width=100px />欢迎登录&nbsp<a href='/servletpro/MainServlet'>返回主界面<a/>&nbsp<a href='/servletpro/CheckCodeLoginServlet'>安全退出<a/><hr/>");
        out.println("<h1>管理用户<h1/>");
        /**
         * 先死后活
         * Java局部变量，就是在函数里面定义的变量，必须初始化，不然会报错
         */
        //当前页默认为第1页
        int pageNow = 1;
        /**
         * 接收一下请求传递的pageNow
         * 需要将其转为int类型
         * 需要加一个判断，请求传递过来的可能为空
         * 不然可能会报错
         */
        String pageNow1 = request.getParameter("pageNow");
        if (pageNow1 != null) {
            pageNow = Integer.parseInt(pageNow1);
        }
        //每页3条记录
        int pageSize = 10;
        //页数，是计算出来的
        int pageCount = 0;
        try {
//学完jstl之后，这段代码会更简洁
            UserService userService = new UserService();
            pageCount = userService.getPageCount(pageSize);
            ArrayList<User> al = userService.getUsersByPage(pageNow, pageSize);
//            表格边框，加点颜色，
//            绿色表示环保的意思
//            cellspacing表示表格之间的距离
            out.println("<script type='text/javascript' language='javascript'> function gotoPageNow(){ var pageNow=document.getElementById('pageNow');window.open('/servletpro/ManageUsers?pageNow='+pageNow.value,'_self');" +
                    "}function confirmOper(){return window.confirm('确定删除');}" +
                    "</script>");
            out.println("<table border=1 bordercolor=silver cellspacing=0 >");
            out.println("<tr><th>id</th><th>用户名</th><th>email</th><th>级别</th><th>删除</th><th>修改</th></tr>");
            /**
             * 循环显示所有用户信息
             * for增强，arraylist的每个元素都是user对象
             * 先到达修改的界面，而不是直接修改
             */
            for (User u : al) {
                out.println("<tr><td>" + u.getId() + "</td><td>" + u.getName() + "</td><td>" + u.getEmail() + "</td><td>" + u.getGrade() + "</td><td><a onclick='confirmOper()' href='/servletpro/UserClServlet?type=del&id=" + u.getId() + "'>删除</a></td><td><a href='/servletpro/UserClServlet?type=gotoUpdateView&id=" + u.getId() + "'>修改</a></td></tr>");
            }

            out.println("</table><br/>");
            /**
             * 显示上一页
             */
            if (pageNow != 1) {
                out.println("<a href='/servletpro/ManageUsers?pageNow=" + (pageNow - 1) + "'><font size='2'>上一页<font/></a>");
            }
/**
 * 显示分页
 * 页数是从1开始的，不是从0了
 */
            for (int i = 1; i <= pageCount; i++) {
                /**
                 * 这里肯定是要带web应用名字的
                 * 带带上pageNow参数
                 * 超连接传递给自己这个servlet进行处理
                 */
                out.println("<a href='/servletpro/ManageUsers?pageNow=" + i + "'><font size='2'><" + i + "><font/></a>");
            }
/**
 * 显示下一页
 */
            if (pageNow != pageCount) {
                out.println("<a href='/servletpro/ManageUsers?pageNow=" + (pageNow + 1) + "'><font size='2'>下一页<font/></a>");
            }
            /**
             * 显示分页信息
             */
            out.println("&nbsp;&nbsp;&nbsp;&nbsp;当前页" + pageNow + "/" + pageCount + "<br/>");
            out.println("跳转到<input type='text' id='pageNow' name='pageNow'/><input type='button' value='跳' onclick='gotoPageNow()'/>");

        } catch (Exception e) {
            e.printStackTrace();
        }
        out.println("<hr/><img src='img/stu.jpg' width=100px />");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
