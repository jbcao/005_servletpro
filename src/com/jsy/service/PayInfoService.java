package com.jsy.service;

import com.jsy.domain.PageBean;
import com.jsy.domain.PayInfo;
import com.user.util.DBUtil;

import javax.xml.bind.Element;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * 功能
 *
 * @author caojianbang
 * @date 3.6.22 10:04 PM
 */
public class PayInfoService {
    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    //引用传递，不需要返回

    public void getPayInfo(PageBean pb) {
        int pageNow = pb.getPageNow();
        int pageSize = pb.getPageSize();
        int pageCount = 0;
        int rowCount = 0;
        ArrayList al = pb.getAl();
        try {
            cn = DBUtil.getConnection();
            ps = cn.prepareStatement("select * from payInfo where checkState = 1 limit ?,?");
            ps.setInt(1, (pageNow - 1) * pageSize);
            ps.setInt(2, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                PayInfo pay = new PayInfo();
                /**
                 * rs可以用getObject(数字)来获取字段
                 * 也可以通过名字来获取字段
                 */
                pay.setId(rs.getInt("Id"));
                pay.setTitle(rs.getString("Title"));
                pay.setCheckState(rs.getByte("checkState"));
                pay.setContent(rs.getString("content"));
                //这里用sql里面的date,数据库里面的格式可以直接转过去
                pay.setPublishDate(rs.getDate("publishDate"));
                pay.setKeepDays(rs.getInt("keepDays"));
                pay.setLinkman(rs.getString("linkman"));
                pay.setTel(rs.getString("tel"));
                al.add(pay);
            }
            ps = cn.prepareStatement("select count(*) from payInfo where checkState = 1 ");
            rs = ps.executeQuery();
            if (rs.next()) {
                rowCount = rs.getInt(1);

            }
            pageCount=(rowCount-1)/pageSize+1;
            pb.setPageCount(pageCount);
            pb.setRowcount(rowCount);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            DBUtil.close(rs, ps, cn);
        }
    }
    //我们自己分页

}
