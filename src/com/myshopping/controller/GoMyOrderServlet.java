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
 * 功能 订单页面
 *
 * @author caojianbang
 * @date 29.5.22 9:48 PM
 */
@WebServlet("/GoMyOrderServlet")
public class GoMyOrderServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //处理用户查看订单的请求
        MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
        //将呀显示的数据放入request
        request.setAttribute("orderInfo", myCart.showMyCart());
        request.setAttribute("totalPrice", myCart.getTotalPrice());
        //跳转到显示我的购物车
        request.getRequestDispatcher("/WEB-INF/shopping/showMyOrder.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
