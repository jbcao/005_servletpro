package com.jsy.controller;

import com.jsy.domain.PageBean;
import com.jsy.service.PayInfoService;

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
 * @date 3.6.22 11:41 PM
 */
@WebServlet("/GoUserIndexUI")
public class GoUserIndexUI extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        PageBean pb = new PageBean();
        pb.setPageNow(1);
        pb.setPageSize(3);
        PayInfoService payInfoService=new PayInfoService();
        payInfoService.getPayInfo(pb);
        request.setAttribute("pb",pb);
        request.getRequestDispatcher("/WEB-INF/jsy/user/index.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
