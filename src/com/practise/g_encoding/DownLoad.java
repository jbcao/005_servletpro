package com.practise.g_encoding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * 功能
 *
 * @author caojianbang
 * @date 18.4.22 10:10 PM
 */
@WebServlet("/DownLoad")
public class DownLoad extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String name = URLEncoder.encode("狗狗.jpeg","utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+name);
        String path = this.getServletContext().getRealPath("/img/dog.jpeg");
        FileInputStream fis = new FileInputStream(path);
        byte buff[] = new byte[1024];
        int len = 0;
        OutputStream os = response.getOutputStream();
        while ((len = fis.read(buff)) > 0) {
            os.write(buff, 0, len);
        }
        os.close();
        fis.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
