package com.myshopping.service;

import com.myshopping.domain.Book;
import com.myshopping.domain.User;
import com.user.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 * 功能 订单业务处理
 *
 * @author caojianbang
 * @date 30.5.22 4:36 PM
 */
public class OrderService {
    private Connection ct = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    /**
     * 知识点
     * 涉及2张表
     */
    public void submitOrder(MyCart myCart, User user) {
        //时间字段可以填默认值，也可以不填，让他自动生成
        String sql = "insert into orders(userId,totalPrice,orderDate) values(?,?,CURRENT_TIMESTAMP)";
        //sqlhelper不能满足功能需求的时候，可以自己写业务逻辑
        //添加订单业务逻辑复杂
        try {
            ct = DBUtil.getConnection();
            //为了保证订单号是稳定的，所以将事务隔离级别升级为可串行化
            //还要设置非自动提交
            //是在连接里进行设置的
            ct.setAutoCommit(false);
            ct.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            //需要设置返回id
            ps = ct.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            //这里架构的好处就体现出来了
            ps.setObject(1, user.getId());
            ps.setObject(2, myCart.getTotalPrice());
            ps.executeUpdate();
            //获得插入的id
            rs=ps.getGeneratedKeys();
            int orderId=0;
            if(rs.next()){
                //取出订单id
               orderId= Integer.parseInt(rs.getObject(1).toString()) ;
            }
            //生成订单明细表
            ArrayList al = myCart.showMyCart();
            for (int i = 0; i <al.size() ; i++) {
                Book book = (Book) al.get(i);
                sql="insert into ordersItem(ordersId,bookId,BookNum) values(?,?,?)";
                ps=ct.prepareStatement(sql);
                ps.setInt(1,orderId);
                ps.setInt(2,book.getId());
                ps.setInt(3,book.getShoppingNum());
                ps.executeUpdate();
            }
            //整体提交
            ct.commit();
        } catch (Exception e) {
            //异常回滚
            try {
                ct.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            //运行失败，抛出运行时异常
            //调用的地方可以根据是否发生异常，得知是否成功
           throw new RuntimeException(e.getMessage());
        } finally {
        }


    }
}
