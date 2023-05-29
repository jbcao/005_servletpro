package com.practise.a_myserver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 功能:模仿web服务器
 *
 * @author caojianbang
 * @date 1.4.22 4:36 PM
 */
public class MyWebServer {
    public static void main(String[] args) throws Exception {
//①　既然是个webserver,肯定和网络有关系
//②　Url中不写端口的话，默认端口是80
//③　下面的参数中不写也是80
        ServerSocket ss = new ServerSocket(9999);
        Socket s = ss.accept();
        //提示一句话
        System.out.println("在 9999 上等待连接...");
        OutputStream os = s.getOutputStream();
        os.write("HTTP/1.1 200OK\r\n".getBytes());
        os.write("\r\n".getBytes());
        BufferedReader br = new BufferedReader(new FileReader("/Users/apple/Desktop/Files/myserver/web/WEB-INF/hello.html"));
        String buf = "";
//        一行一行读
        while ((buf = br.readLine()) != null) {
            os.write(buf.getBytes());
        }

        //关闭流
        br.close();
        os.close();
        s.close();

    }
}