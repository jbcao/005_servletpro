package com.myshopping.service;

import com.myshopping.domain.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 功能
 *
 * @author caojianbang
 * @date 28.5.22 4:26 PM
 */
public class MyCart {
    HashMap<String, Book> hm = new HashMap<String, Book>();

    //添加书的第2方法
    public void addBook2(String id) {
        if (hm.containsKey(id)) {
            //
            //如果已经购买过，修改数量
            Book book = hm.get(id);
            int shoppingNum = book.getShoppingNum();
            book.setShoppingNum(shoppingNum + 1);
        } else {
            //没买过，直接加进去
            hm.put(id, new BookService().getBookById(id));
        }
    }

    //添加书
    //这个方法第一次添加的话可以，后面添加都创建对象，浪费空间
    public void addBook(String id, Book book) {
        if (hm.containsKey(id)) {
            //
            //如果已经购买过，修改数量
            Book book1 = hm.get(id);
            int shoppingNum = book1.getShoppingNum();
            book1.setShoppingNum(shoppingNum + 1);
        } else {
            //没买过，直接加进去
            hm.put(id, book);
        }
    }

    //删除书
    public void delBook(String id) {
        hm.remove(id);

    }

    //更新书（对购物车进行更新）
    public void updateBook(String id, String nums) {
        Book book = hm.get(id);
        book.setShoppingNum(Integer.parseInt(nums));
    }

    //显示该购物车中所有商品信息
    public ArrayList showMyCart() {
        ArrayList<Book> al = new ArrayList<Book>();
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            String id = iterator.next();
            Book book = hm.get(id);
            al.add(book);
        }
        return al;
    }

    //获得总价
    public float getTotalPrice() {
        float total = 0.0f;
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            String id = iterator.next();
            Book book = hm.get(id);
            total += book.getPrice() * book.getShoppingNum();
        }
        return total;
    }

    //清空书，清空购物出
    public void clearBook() {
        hm.clear();
    }
}
