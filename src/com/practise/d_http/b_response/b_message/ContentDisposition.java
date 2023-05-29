package com.practise.d_http.b_response.b_message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 功能
 *
 * @author caojianbang
 * @date 14.4.22 9:51 PM
 */
@WebServlet("/ContentDisposition")
public class ContentDisposition extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=狗狗.jpeg");
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
