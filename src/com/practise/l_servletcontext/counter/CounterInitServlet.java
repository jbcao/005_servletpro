package com.practise.l_servletcontext.counter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 功能
 *
 * @author caojianbang
 * @date 16.5.22 2:00 AM
 */

public class CounterInitServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
    }

    @Override
    public void destroy() {
        super.destroy();
        /**
         * 只有当初始化过后，关闭或者，重启服务器的时候，该方法才会执行
         * 必须有对象实例，需要加载到内存中
         * ★★★★★★★★★★★★★
         * 初始化的时候，将值读进来，
         * 销毁的时候，将值写进文件
         * 这样可以避免频繁操作数据库
         */
        System.out.println(" 第三个 destroy 调用");
        /**
         * 将servletContext值重新保存到文件
         * 服务器是不能随便重启的，里面可能有一些信息，会丢失掉
         * 服务器掉电的话，损失会很大的，当然可能性是很小的
         * 可以通过线程，一个小时刷一下数据，即使断电了，大不了就是一个小时的数据，还可以接收
         * 既减少对数据库访问的频率，又尽可能减少了损失
         */
        String realPath = this.getServletContext().getRealPath("record.txt");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(realPath);
            bufferedWriter = new BufferedWriter(fileWriter);
            String nums = (String) this.getServletContext().getAttribute("nums");
            bufferedWriter.write(nums);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println(" 第三个 init 调用");
        /**
         * 从record.txt文件中读取浏览量
         * 可以使用servletcontext,也可以纯粹使用io流
         */
        //首先得到该文件的真实路径
        //路劲一般不要有中文，也不会有空格，很容易出问题
        String realPath = this.getServletContext().getRealPath("record.txt");
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(realPath);
            bufferedReader = new BufferedReader(fileReader);
            String nums = bufferedReader.readLine();
            this.getServletContext().setAttribute("nums", nums);
            /**
             * 这个流可以不关，应该来自于同一个通道
             * 但是关一下也没关系
             */

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
