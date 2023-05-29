package com.practise.j_session.shoppingcart;

import java.io.Serializable;

/**
 * 功能
 *
 * @author caojianbang
 * @date 13.5.22 4:45 PM
 * 可能会报非序列化错误
 * 序列化的作用有2个
 * 1。目的是能让数据在网络中传送
 * 2.可以往集合中存放的时候，可以有区分
 *
 */
public class Book implements Serializable {
      private String id;
      private String name;
      private int num;

      public String getId() {
            return id;
      }

      public void setId(String id) {
            this.id = id;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public int getNum() {
            return num;
      }

      public void setNum(int num) {
            this.num = num;
      }
}
