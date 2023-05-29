package com.myshopping.service;

import com.myshopping.domain.Book;
import com.user.util.SqlHelper;

import java.util.ArrayList;

/**
 * 功能 业务逻辑类，用于处理book表相关的业务
 *
 * @author caojianbang
 * @date 28.5.22 1:22 AM
 */
public class BookService {
    /**
     * 根据书id返回book实例
     */
     public Book getBookById(String id){
         Book book = new Book();
         String sql="select * from book where id =?";
         String para[]={id};
         ArrayList al = SqlHelper.executeQuery3(sql,para);
         if(al.size()==1){
             Object obj[] = (Object[]) al.get(0);
             book.setId(Integer.parseInt(obj[0].toString()));
             book.setName(obj[1].toString());
             book.setAuthor(obj[2].toString());
             book.setPublishHouse(obj[3].toString());
             book.setPrice(Float.parseFloat(obj[4].toString()));
             book.setNums(Integer.parseInt(obj[5].toString()));
         }
         return book;
     }
    /**
     * 得到所有书籍信息
     */
    public ArrayList getAllBook() {
        //这里用1=1偷个懒
        String sql = "select * from book where 1=?";
        String para[] = {"1"};
        ArrayList al = SqlHelper.executeQuery3(sql, para);
        ArrayList<Book> neaAl = new ArrayList<Book>();
        //二次封装
        for (int i = 0; i < al.size(); i++) {
            Object obj[] = (Object[]) al.get(i);
            Book book = new Book();
            book.setId(Integer.parseInt(obj[0].toString()));
            book.setName(obj[1].toString());
            book.setAuthor(obj[2].toString());
            book.setPublishHouse(obj[3].toString());
            book.setPrice(Float.parseFloat(obj[4].toString()));
            book.setNums(Integer.parseInt(obj[5].toString()));
            neaAl.add(book);
        }
        return neaAl;
    }
}
