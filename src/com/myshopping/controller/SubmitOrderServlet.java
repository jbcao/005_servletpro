package com.myshopping.controller;

import com.myshopping.domain.User;
import com.myshopping.service.MyCart;
import com.myshopping.service.OrderService;
import com.myshopping.service.SendMail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 功能：处理下订单的请求
 *
 * @author caojianbang
 * @date 30.5.22 3:48 PM
 */
@WebServlet("/SubmitOrderServlet")
public class SubmitOrderServlet extends HttpServlet implements Runnable {
    User user = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //处理订单
        try {
            OrderService orderService = new OrderService();
            MyCart myCart = (MyCart) request.getSession().getAttribute("myCart");
            user = (User) request.getSession().getAttribute("loginUser");
            orderService.submitOrder(myCart, user);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            request.getRequestDispatcher("WEB-INF/shopping/err.jsp").forward(request, response);
        }
        //如果订单写入数据库，就发邮件
        //进入catch快后，后面的除了finally，都不执行
        SubmitOrderServlet submitOrderServlet = new SubmitOrderServlet();
        //通过线程发邮件，因为往往发邮件比较耗时，会影响响应速度
        Thread t = new Thread(submitOrderServlet);
        t.start();
        //260ms,效率的差距立马体现
        //SendMail.sendToOther("已购，即将发货", "订单通知", user.getEmail());
        //873ms
        request.getRequestDispatcher("WEB-INF/shopping/orderOk.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    public void run() {
        SendMail.sendToOther("已购，即将发货", "订单通知", user.getEmail());
    }
}
