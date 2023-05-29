package com.practise.l_servletcontext.counter;

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
 * @date 15.5.22 11:45 PM
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String p = request.getParameter("password");
        if ("123".equals(p)) {
            /**
             *  合法
             *             向servletcontext中添加属性
             *             对同一个数据需要修改的情况
             *             先取出
             *             再改变
             *             再更新
             */

            String nums = (String) this.getServletContext().getAttribute("nums");
            this.getServletContext().setAttribute("nums", ((Integer.parseInt(nums) + 1) + ""));
            response.sendRedirect("/servletpro/Manager");
        } else {
            //非法,先不用管他
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
