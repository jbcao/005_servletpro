package com.practise.a_3interface;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyHttpServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,
                     HttpServletResponse resp)
              throws ServletException,
                     IOException{
		resp.getWriter().println("i am httpServet doGet()");
		
	}

	protected void doPost(HttpServletRequest req,
                      HttpServletResponse resp)
               throws ServletException,
                      IOException{
		resp.getWriter().println("i am httpServet doPost() post name="+req.getParameter("username"));
	}
}
