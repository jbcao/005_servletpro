package com.practise.j_session.checkcode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 功能：创建验证码
 *
 * @author caojianbang
 * @date 12.5.22 12:36 AM
 */
@WebServlet("/CreateCode")
public class CreateCode extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setDateHeader("Expires", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pregma", "no-cache");
        BufferedImage image = new BufferedImage(60, 30, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.gray);
        g.fillRect(0, 0, 60, 30);
        g.setColor(Color.blue);
        g.setFont(new Font(null, Font.BOLD, 13));
        String num=makeNum();
        request.getSession().setAttribute("checkcode",num);
        g.drawString(num,15,20);
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    public String makeNum() {
        Random r = new Random();
        String num = r.nextInt(9999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4 - num.length(); i++) {
            sb.append(0);
        }
        num=sb.toString()+num;
        return num;
    }
}
