package com.user.util;

import java.io.IOException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.*;

/**
 * 功能 这是操作数据库的工具类
 * 该复制的要复制，到懂得省事，这是之前他写好的，
 * 我没有学过，视频中简单介绍了一点
 *
 * @author caojianbang
 * @date 30.4.22 3:48 PM
 */
public class SqlHelper {

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
    //存储过程
    private static CallableStatement cs = null;

    public static CallableStatement getCs() {
        return cs;
    }

    //读取配置文件的
    private static Properties pp = null;
    private static InputStream is = null;

    //加载驱动，只需要一次，用静态代码块
//    注意静态代码块只能访问静态变量
    static {
        try {
            //从dbinfo.properties
            /**
             * tomcat主目录默认主目录
             */
            pp = new Properties();
            //fis = new FileInputStream("dbinfo.properties");
            is = SqlHelper.class.getClassLoader().getResourceAsStream("dbinfo.properties");
            //装载文件
            //装载完了才开始读文件，使用getProperty方法去读取配置文件里面的一些信息
            pp.load(is);
            url = pp.getProperty("url");
            driver = pp.getProperty("driver");
            username = pp.getProperty("user");
            passwd = pp.getProperty("pass");
            //只需要加载一次，所以放在静态代码块里面
            //多加载也没有意义，浪费时间，浪费效率
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            is = null;//垃圾回收站上收拾
        }
    }

    //得到连接
    public static Connection getConnection() {
        try {
            ct = DriverManager.getConnection(url, username, passwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ct;
    }

    //    分页
    //    空方法，有返回值的，return null一下
    public static ResultSet executeQuery2() {
        return null;
    }

    //*************callPro1存储过程函数1*************
    public static CallableStatement callPro1(String sql, String[] parameters) {
        try {
            ct = getConnection();
            cs = ct.prepareCall(sql);
            if (parameters != null) {
                for (int i = 0; i < parameters.length; i++) {
                    cs.setObject(i + 1, parameters[i]);
                }
            }
            cs.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            close(rs, cs, ct);
        }
        return cs;
    }

    //*******************callpro2存储过程2************************
    public static CallableStatement callPro2(String sql, String[] inparameters,
                                             Integer[] outparameters) {
        try {
            ct = getConnection();
            cs = ct.prepareCall(sql);
            if (inparameters != null) {
                for (int i = 0; i < inparameters.length; i++) {
                    cs.setObject(i + 1, inparameters[i]);
                }
            }
            //cs.registerOutparameter(2,oracle.jdbc.OracleTypes.CURSOR);
            if (outparameters != null) {
                for (int i = 0; i < outparameters.length; i++) {
                    cs.registerOutParameter(inparameters.length + 1 + i, outparameters[i]);
                }
            }
            cs.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {

        }
        return cs;
    }

    //统一的select
//    resultSet ->ArrayList

    public static ResultSet executeQuery(String sql, String[] parameters) {
        try {
            ct = getConnection();
            ps = ct.prepareStatement(sql);
            if (parameters != null) {
                for (int i = 0; i < parameters.length; i++) {
                    ps.setString(i + 1, parameters[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {

        }
        return rs;
    }
//得到一些信息的方法

    public static Connection getCt() {
        return ct;
    }

    public static PreparedStatement getPs() {
        return ps;
    }

    public static ResultSet getRs() {
        return rs;
    }

//如果有多个update、delete、insert，需要考虑事务
//与多个dml就需要考虑事务

    public static void executeUpdate2(String[] sql, String[][] parameters) {
        try {
            ct = getConnection();
            ct.setAutoCommit(false);

            for (int i = 0; i < sql.length; i++) {

                if (null != parameters[i]) {
                    ps = ct.prepareStatement(sql[i]);
                    for (int j = 0; j < parameters[i].length; j++) {
                        ps.setString(j + 1, parameters[i][j]);
                    }
                    ps.executeUpdate();
                }
            }
            ct.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                ct.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            throw new RuntimeException(e.getMessage());
        } finally {
            close(rs, ps, ct);
        }
    }

    //不考虑事务的情况
    //相当于只有一个update或者delete或者insert
    //先写一个update、delete、insert
    //sql格式：update 表名 set 字段名 =？where 字段=？
    //parameter神应该是（”abc“,23）
    public static void executeUpdate(String sql, String[] parameters) {
        try {
            ct = getConnection();
            ps = ct.prepareStatement(sql);
            if (parameters != null) {
                for (int i = 0; i < parameters.length; i++) {
                    //只要给的参数正确，数据库都会朝对应的类型转换
                    ps.setString(i + 1, parameters[i]);
                }
            }
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();//开发阶段
            //抛出异常
            //可以处理，也可以不处理
            //通过运行时异常来判断是否成功
            throw new RuntimeException(e.getMessage());
        } finally {
            close(rs, ps, ct);
        }
    }

    //关闭资源的方法
    public static void close(ResultSet rs, Statement ps, Connection ct) {
        //关闭资源(先开后关)
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps = null;
        }
        if (null != ct) {
            try {
                ct.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ct = null;
        }
    }

    /**
     * 对查询语句进行升级
     * c语言的话，使用内存之前是需要申请内存的，关闭内存，必须程序员自己来做，没哟垃圾回收机制
     * 当时就有了这个原则
     * 满足：哪里用资源，哪里关闭资源，不然别人使用资源，可能会忘关资源
     */
    public static ArrayList executeQuery3(String sql, String[] parms) {
        /**
         * 在这里使用局部变量是有好处的
         * 避免static带来的一些缺陷
         * 使用全局变量的话，如果一个service中操作多个数据库
         * 可能会产生一些错误，错乱
         *
         * 因为，调用时候，是一个sqlhelper对象，使用同一个局部变量，多个方法，都使用一个资源，做不同的任务，就可能产生错乱
         */

        PreparedStatement ps = null;
        Connection cn = null;
        ResultSet rs = null;
        ArrayList al = null;


        try {
            cn = getConnection();
            ps = cn.prepareStatement(sql);
            if (parms != null) {
                for (int i = 0; i < parms.length; i++) {
                    //只要给的参数正确，数据库都会朝对应的类型转换
                    ps.setString(i + 1, parms[i]);
                }
            }
            rs = ps.executeQuery();
            al = new ArrayList();
            /**
             *   获得列信息
             *   可以查询到几列
             */

            ResultSetMetaData data=rs.getMetaData();
            int column=data.getColumnCount();
            while (rs.next()){
                Object ob[]=new Object[column];
                for (int i=1;i<=column;i++){
                    ob[i-1]=rs.getObject(i);
                }
                al.add(ob);
            }
            return al;
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("executeQuery3出错"+e.getMessage());
        } finally {
            try {
                close(rs,ps,cn);
            } catch (Exception e) {
                throw  new RuntimeException("executeQuery3出错"+e.getMessage());
            }
        }
    }
}

