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
 * 功能 该控制器用于响应用户购买商品的请求
 *
 * @author caojianbang
 * @date 28.5.22 4:49 PM
 */
@WebServlet("/ShoppingClServlet")
public class ShoppingClServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String type = request.getParameter("type");
        if (type.equals("del")) {
            //用户从购物车中删除商品
            String id = request.getParameter("id");
            MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
            myCart.delBook(id);
            //将呀显示的数据放入request
            request.setAttribute("bookList", myCart.showMyCart());
            request.setAttribute("totalPrice", myCart.getTotalPrice() + "");
        } else if (type.equals("add")) {
            //添加商品到购物车中
            //写一点，测一点，这样不累
            String id = request.getParameter("id");
            System.out.println("购买的书号：" + " " + id);
            MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
            myCart.addBook2(id);
            //跳转到显示我的购物车
            response.sendRedirect("/servletpro/GoShowMyCart");

        }else if(type.equals("update")){
            MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
            //获得参数数组
            //获取一组参数，得到一个数组
            String[] id = request.getParameterValues("id");
            String[] booknum = request.getParameterValues("booknum");
            for (int i=0;i<id.length;i++){
                myCart.updateBook(id[i],booknum[i]);
            }
            //将呀显示的数据放入request
            request.setAttribute("bookList", myCart.showMyCart());
            request.setAttribute("totalPrice", myCart.getTotalPrice());
            //跳转到显示我的购物车
            request.getRequestDispatcher("/WEB-INF/shopping/showMyCart.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
