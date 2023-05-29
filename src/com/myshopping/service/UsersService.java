package com.myshopping.service;

import com.myshopping.domain.User;
import com.user.util.SqlHelper;

import java.util.ArrayList;

/**
 * 功能 用于处理业务逻辑的类
 * 处理和user表相关的业务逻辑
 *
 * @author caojianbang
 * @date 27.5.22 10:57 PM
 */
public class UsersService {
    /**
     * 验证用户是否合法的方法
     * 这里不做成布尔类型，返回的话，可能需要用到用户本身的数据，所以最好返回
     * 也可以使用传递进来的引用，节省一次内存开销
     */
    public boolean checkUser(User user) {
        String sql ="select * from users where id=? and passwd=?";
        String para[]={user.getId()+"",user.getPwd()+""};
        ArrayList al =SqlHelper.executeQuery3(sql,para);
        if(al.size()==0){
            return false;
        }else {
            Object[] objects= (Object[]) al.get(0);
            user.setName(  objects[1].toString());
            user.setEmail((String) objects[2]);
            //对象没法转成int,需要转成String
            user.setGrade(Integer.parseInt(objects[3].toString()));
            return true;
        }
    }
}
