package com.practise.a_3interface;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyGenericServlet extends GenericServlet{
	public  void service(ServletRequest req,
                             ServletResponse res)
                      throws ServletException,
                             IOException{
		res.getWriter().println("hello i am GenericServlet");
	}
}