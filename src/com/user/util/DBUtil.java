package com.user.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil
{
    //定义变量
    private static Connection ct = null;
    //大多数情况下用preparedstatement替代statement
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    //连接数据库的参数
    private static String url = "";
    private static String username = "";
    private static String driver = "";
    private static String passwd = "";



    private static Properties  pp = null;
    //    private static FileInputStream fis = null;
    private static InputStream fis = null;
    //加载驱动，只需要一次，用静态代码块
    static
    {
        try
        {
            //从dbinfo.properties
            pp = new Properties();
//            fis = new FileInputStream("dbinfo.properties");

            fis = DBUtil.class.getClassLoader().getResourceAsStream("dbinfo.properties");
            pp.load(fis);
            url = pp.getProperty("url");
            username = pp.getProperty("user");
            driver = pp.getProperty("driver");
            passwd = pp.getProperty("pass");

            //1.加载驱动
            Class.forName(driver);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            { fis.close();}
            catch(IOException e) {e.printStackTrace();}
            fis = null;//垃圾回收站上收拾
        }

    }
    //得到连接
    public static Connection getConnection()
    {
        try
        //建立连接
        {ct = DriverManager.getConnection(url,username,passwd);}
        catch(Exception e) {e.printStackTrace();}
        return ct;
    }

    //关闭资源
    public static void close(ResultSet rs,Statement ps,Connection ct)
    {
        //关闭资源(先开后关)
        if(rs!=null)
        {
            try
            {
                rs.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            rs=null;
        }
        if(ps!=null)
        {
            try
            {
                ps.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            ps=null;
        }
        if(null!=ct)
        {
            try
            {
                ct.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            ct=null;
        }
    }

}


