package com.practise.j_session.shoppingcart;

import java.util.ArrayList;

/**
 * 功能:自己的一个数据库
 *
 * @author caojianbang
 * @date 13.5.22 10:22 PM
 * <p>
 * 使用ArrayList模拟一个内存数据库
 */
public class DB {
    private static ArrayList<Book> al = null;

    public static ArrayList getDB() {
        return al;
    }

    /**
     * 构造函数做成私有化
     */
    private DB() {
    }

    static {
        /**
         * 如果将来有什么书，在这里动态添加
         */
        al = new ArrayList<Book>();
        Book book = new Book();
        book.setId("1");
        book.setName("java");
        Book book2 = new Book();
        book2.setId("2");
        book2.setName("oracle");
        Book book3 = new Book();
        book3.setId("3");
        book3.setName("linux");
        al.add(book);
        al.add(book2);
        al.add(book3);
    }

    public static Book getBookById(String id) {
        Book book = null;
        boolean b=false;
        for (int i = 0; i < al.size(); i++) {
            book = (Book) al.get(i);
            if (book.getId().equals(id)) {
                /**
                 * 遍历到了之后就结束遍历
                 */
                b=true;
                break;
            }
        }
        if(b){
            return book;
        }else {
            return null;
        }

    }
}
