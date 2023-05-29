package com.user.service;

import com.user.domain.User;
import com.user.util.SqlHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 功能
 *
 * @author caojianbang
 * @date 28.4.22 9:02 PM
 */
public class UserService {
    /**
     * 添加用户
     */
    public boolean addUser(User user) {
        boolean b = true;
        String sql = "insert into users(username,email,grade,passwd) values(?,?,?,?)";
        String parameter[] = {user.getName(), user.getEmail(), user.getGrade() + "", user.getPwd()};
        try {
            SqlHelper.executeUpdate(sql, parameter);
        } catch (Exception e) {
            e.printStackTrace();
            b = false;
        }
        return b;
    }

    /**
     * 修改用户
     * 不要传一个一个的参数
     */
    public boolean updateUser(User user) {
        boolean b = true;
        String sql = "update users set username=?,email=?,grade=?,passwd=? where id=?";
        String parameter[] = {user.getName(), user.getEmail(), user.getGrade() + "", user.getPwd(), user.getId() + ""};
/**
 * 一条sql语句，就没有考虑事务
 * 多条，就必须考虑事务
 * 通过异常来判断是否成功
 */
        try {
            SqlHelper.executeUpdate(sql, parameter);
        } catch (Exception e) {
            e.printStackTrace();
            b = false;
        } finally {

        }
        return b;
    }

    /**
     * 通过id获取用户信息
     */
    public User getUserById(String id) {
        User user = new User();
        String sql = "select * from users where id =?";
        String parameter[] = {id};
        ResultSet resultSet = SqlHelper.executeQuery(sql, parameter);
        try {
            if (resultSet.next()) {
                //二次封装，主要是方便调用放好调用
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setGrade(resultSet.getInt(4));
                user.setPwd(resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlHelper.close(resultSet, SqlHelper.getPs(), SqlHelper.getCt());
        }
        return user;

    }

    /**
     * 删除用户
     */
    public boolean delUser(String id) {
        //因为成功的可能性比失败的，要大，所以初始化是TRUE
        boolean b = true;
        String sql = "delete from users where id=?";
        String parameters[] = {id};
        try {
            SqlHelper.executeUpdate(sql, parameters);
        } catch (Exception e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 获取pagecount
     * 该关闭资源，一定要关闭，不然服务器撑不了多久
     * 不要小看这个小问题
     */
    public int getPageCount(int pageSize) {
        String sql = "select count(*) from users";
        int rowCount = 0;
        ResultSet resultSet = SqlHelper.executeQuery(sql, null);
        try {
            resultSet.next();
            rowCount = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlHelper.close(resultSet, SqlHelper.getPs(), SqlHelper.getCt());
        }
        return (rowCount - 1) / pageSize + 1;
    }

    /**
     * 如果直接返回resultset，显示的时候，还需要getint(1)getString（2），的方式去显示，并不能鲜明地表达出含义
     * 另外关闭resultset的时间会被拉长
     * 合理的做法，又是通用的做法
     * 将resultset->user对象->arraylist集合中
     * 好处：集合中的user对象本身就代表数据，还有get set方法
     * 数据存放到ArrayList，就和resultset没有关系，就可以及时释放数据资源
     */
    public ArrayList getUsersByPage(int pageNow, int pageSize) {
        /**
         * 泛型
         */
        ArrayList<User> al = new ArrayList<User>();
        String sql = "select * from users order by id limit " + pageSize * (pageNow - 1) + "," + pageSize;
        /**
         * meiyo8u参数，就传个null
         * 这里不能使用泛型，因为不知道具体类型
         */
        ArrayList al1= SqlHelper.executeQuery3(sql, null);
        /**
         * 二次封装
         * 由于对结果不知道，所以使用while进行封装
         *
         */
        /**
         *  Us u = new Us; 如果放在这里那么。最后arraylist里面只有一条数据，还是最后一条
         *  每个对象代表一条数据
         *  看着很麻烦，但是必须要做，
         *  学了hibernate，有鲁棒性，他帮你做了，是用反射的方式
         *  bigdecimal大的十进制
         *  oracle中数字字段 设为number 很大 ，转为int会报错 转成long也会报错
         *  采用： Integer.paaseint(o[0].tostring) 先转成字符串，再转成int，很神奇
         *
         */
        for(int i=0;i<al1.size();i++){
            Object o[]= (Object[]) al1.get(i);
            User u=new User();
            u.setId((Integer) o[0]);
            u.setName(o[1].toString());
            u.setEmail((String) o[2]);
            u.setGrade((Integer) o[3]);
            al.add(u);
        }
        return al;
    }

    /**
     * 验证用户是否合法
     * 作为面向对象程序员，传递对象比较合适
     * 另外，每条记录对应一个对象
     * 所谓调用；就是创建相应实例，然后使用相应方法，就称为调用
     * Oracle数据库很吃内存
     */
    public boolean checkUser(User user) {
        boolean b = false;
        String sql = "select * from users where id =? and passwd= ?";
        String parameter[] = {user.getId() + "", user.getPwd()};
        ArrayList al = SqlHelper.executeQuery3(sql, parameter);
        if (al.size() == 1) {
            b = true;
        }
        return b;
    }
}
