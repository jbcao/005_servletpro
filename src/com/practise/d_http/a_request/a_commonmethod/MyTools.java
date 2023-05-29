package com.practise.d_http.a_request.a_commonmethod;

import java.io.UnsupportedEncodingException;

/**
 * 功能
 *
 * @author caojianbang
 * @date 18.4.22 8:52 PM
 */
public class MyTools {
    public static String getNewString(String str){
        String res="";
        try {
            res=new String(str.getBytes("utf-8"),"gb2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return res;
    }
}
