package com.practise.a_singleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能
 *
 * @author caojianbang
 * @date 11.4.22 10:40 PM
 */
public class TicketWindow extends HttpServlet {
    int ticket = 2;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        synchronized (this){
            if (ticket > 0) {
                System.out.println("你买到票了");
                try {
                    Thread.sleep(10 * 1000);
                } catch (Exception e) {

                }
                ticket--;
            } else {
                System.out.println("没买到");
            }
        }
    }
}
