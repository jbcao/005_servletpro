package com.practise.d_http.a_request.a_commonmethod;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * 功能
 *
 * @author caojianbang
 * @date 20.4.22 5:17 PM
 */
@WebServlet("/ReturnDetail")
public class ReturnDetail extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String queryString = request.getQueryString();
        String decode = URLDecoder.decode(queryString, "utf-8");
        System.out.println(decode);
        String[] split = decode.split("&");
        for (String s : split
                ) {
            String[] split1 = s.split("=");
            writer.println(split1[0]+"="+split1[1]);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
