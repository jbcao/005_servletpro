package com.myshopping.controller;

import com.myshopping.domain.User;
import com.myshopping.service.BookService;
import com.myshopping.service.MyCart;
import com.myshopping.service.UsersService;

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
 * @date 27.5.22 10:34 PM
 */
@WebServlet("/GoHallUi")
public class GoHallUi extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //判断该用户是否登录，可读性差一点
        if(request.getSession().getAttribute("loginUser")!=null){
            BookService bookService = new BookService();
            ArrayList al = bookService.getAllBook();
            request.setAttribute("books",al);
            request.getRequestDispatcher("/WEB-INF/shopping/hall.jsp").forward(request,response);
        }
        String id = request.getParameter("id");
        String p=request.getParameter("pass");
        User loginuser =new User(Integer.parseInt(id),p);
        UsersService usersService = new UsersService();
        if(usersService.checkUser(loginuser)){
            /**
             * 因为很多西方都用到用户信息
             * 所以放入session
             */
            request.getSession().setAttribute("loginUser",loginuser);
            /**
             * 给下一个jsp准备要显示的数据
             * mvc就是这么规定的，可以放心大胆使用
             * 模式开发，在一定程度上约束了程序员的自由
             * 在这里就创建购物车，不然，等到用的时候，才创建，还要判断
             */
            //到处都可以使用，所以放session
            MyCart myCart=new MyCart();
            request.getSession().setAttribute("myCart",myCart);
            //数据不能放session,放request域，不然内存支撑不住
            //原因是request生命周期最短
            BookService bookService = new BookService();
            ArrayList al = bookService.getAllBook();
            request.setAttribute("books",al);
            request.getRequestDispatcher("/WEB-INF/shopping/hall.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/WEB-INF/shopping/shoppinglogin.jsp").forward(request,response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
