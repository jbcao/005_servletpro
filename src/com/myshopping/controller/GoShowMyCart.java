package com.myshopping.controller;

import com.myshopping.service.MyCart;

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
 * @date 31.5.22 10:37 PM
 */
@WebServlet("/GoShowMyCart")
public class GoShowMyCart extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //取出购物车，并取出书放到里面
        MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
        //将呀显示的数据放入request
        request.setAttribute("bookList", myCart.showMyCart());
        request.setAttribute("totalPrice", myCart.getTotalPrice());
        request.getRequestDispatcher("/WEB-INF/shopping/showMyCart.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
