package com.practise.a_3interface;

import javax.servlet.*;
import javax.servlet.http.*;

public class FirstServlet implements Servlet {
    public void init(ServletConfig config)
            throws ServletException {
        System.out.println("init（）方法被调用。。。");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req,
                        ServletResponse res)
            throws ServletException,
            java.io.IOException {
        res.setCharacterEncoding("utf-8");
        res.getWriter().println("<font color=\"red\" >你好 曹建邦</font><br/>" + new java.util.Date());
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("destroy()方法被调用...");
    }
}
