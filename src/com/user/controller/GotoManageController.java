package com.user.controller;

import com.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 功能
 *
 * @author caojianbang
 * @date 25.5.22 12:08 AM
 */
@WebServlet("/GotoManageController")
public class GotoManageController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNow=1;
        String  pageNeed= request.getParameter("pageNow");
        if(pageNeed!=null){
         pageNow=Integer.parseInt(pageNeed);
        }

        //调用service来准备数据
        UserService userService = new UserService();
        ArrayList al = userService.getUsersByPage(pageNow, 3);
        int pageCount = userService.getPageCount(3);

        //因为数据要给下面的jsp使用
        //pagecontext session request application(servletcontext)
        request.setAttribute("al",al);
        request.setAttribute("pageCount",pageCount);

        //跳出
        request.getRequestDispatcher("/ManageUsers").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
