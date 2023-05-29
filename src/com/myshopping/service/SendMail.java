package com.myshopping.service;

/**
 * 功能 javamail
 *
 * @author caojianbang
 * @date 31.5.22 12:42 AM
 */
import java.util.*;
import javax.mail.*;

import javax.mail.internet.*;

import javax.activation.*;

public class SendMail {

    private MimeMessage mimeMsg; // MIME邮件对象

    private Session session; // 邮件会话对象
    private Properties props; // 系统属性
    private boolean needAuth = false; // smtp是否需要认证

    private String username = ""; // smtp认证用户名和密码
    private String password = "";

    private Multipart mp; // Multipart对象,邮件内容,标题,附件等内容均添加到其中后再生成MimeMessage对象

    public SendMail() {

        // setSmtpHost(getConfig.mailHost);//如果没有指定邮件服务器,就从getConfig类中获取
        createMimeMessage();

    }

    public SendMail(String smtp) {

        setSmtpHost(smtp);
        createMimeMessage();

    }

    /**
     * @param hostName
     *            String
     */
    public void setSmtpHost(String hostName) {

        System.out.println("设置系统属性：mail.smtp.host = " + hostName);
        if (props == null)
            props = System.getProperties(); // 获得系统属性对象

        props.put("mail.smtp.host", hostName); // 设置SMTP主机

    }

    /**
     * @return boolean
     */
    public boolean createMimeMessage() {
        try {
            System.out.println("准备获取邮件会话对象！");
            session = Session.getDefaultInstance(props, null); // 获得邮件会话对象
        }

        catch (Exception e) {
            System.err.println("获取邮件会话对象时发生错误！" + e);
            return false;
        }

        System.out.println("准备创建MIME邮件对象！");

        try {

            mimeMsg = new MimeMessage(session); // 创建MIME邮件对象
            mp = new MimeMultipart();

            return true;

        } catch (Exception e) {

            System.err.println("创建MIME邮件对象失败！" + e);
            return false;
        }
    }

    /**
     * @param need
     *            boolean
     */
    public void setNeedAuth(boolean need) {

        System.out.println("设置smtp身份认证：mail.smtp.auth = " + need);
        if (props == null)
            props = System.getProperties();

        if (need) {

            props.put("mail.smtp.auth", "true");
        } else {

            props.put("mail.smtp.auth", "false");
        }
    }

    /**
     * @param name
     *            String
     * @param pass
     *            String
     */
    public void setNamePass(String name, String pass) {
        username = name;
        password = pass;
    }

    /**
     * @param mailSubject
     *            String
     * @return boolean
     */
    public boolean setSubject(String mailSubject) {
        System.out.println("设置邮件主题！");
        try {
            mimeMsg.setSubject(mailSubject);
            return true;
        } catch (Exception e) {
            System.err.println("设置邮件主题发生错误！");
            return false;
        }
    }

    /**
     * @param mailBody
     *            String
     */
    public boolean setBody(String mailBody) {
        try {
            BodyPart bp = new MimeBodyPart();
            bp.setContent(
                    "<meta http-equiv=Content-Type content=text/html; charset=gb2312>"
                            + mailBody, "text/html;charset=GB2312");
            mp.addBodyPart(bp);

            return true;
        } catch (Exception e) {
            System.err.println("设置邮件正文时发生错误！" + e);
            return false;
        }
    }

    /**
     * @param name
     *            String
     * @param pass
     *            String
     */
    public boolean addFileAffix(String filename) {

        System.out.println("增加邮件附件：" + filename);

        try {
            BodyPart bp = new MimeBodyPart();
            FileDataSource fileds = new FileDataSource(filename);
            bp.setDataHandler(new DataHandler(fileds));
            bp.setFileName(fileds.getName());

            mp.addBodyPart(bp);

            return true;
        } catch (Exception e) {
            System.err.println("增加邮件附件：" + filename + "发生错误！" + e);
            return false;
        }
    }

    /**
     * @param name
     *            String
     * @param pass
     *            String
     */
    public boolean setFrom(String from) {
        System.out.println("设置发信人！");
        try {
            mimeMsg.setFrom(new InternetAddress(from)); // 设置发信人
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param name
     *            String
     * @param pass
     *            String
     */
    public boolean setTo(String to) {
        if (to == null)
            return false;

        try {
            mimeMsg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * @param name
     *            String
     * @param pass
     *            String
     */
    public boolean setCopyTo(String copyto) {
        if (copyto == null)
            return false;
        try {
            mimeMsg.setRecipients(Message.RecipientType.CC,
                    (Address[]) InternetAddress.parse(copyto));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param name
     *            String
     * @param pass
     *            String
     */
    public boolean sendout() {
        try {
            mimeMsg.setContent(mp);
            mimeMsg.saveChanges();
            System.out.println("正在发送邮件....");

            Session mailSession = Session.getInstance(props, null);
            Transport transport = mailSession.getTransport("smtp");
            transport.connect((String) props.get("mail.smtp.host"), username,
                    password);
            transport.sendMessage(mimeMsg,
                    mimeMsg.getRecipients(Message.RecipientType.TO));

            System.out.println("发送邮件成功！");
            transport.close();

            return true;
        } catch (Exception e) {

            System.err.println("邮件发送失败！" + e);
            return false;
        }

    }

    //可以修改的部分

    public static void main(String[] args) {
        String mailbody="hhh";
        String title="test";
        String toEmail="13062600485@sohu.com";
        sendToOther(mailbody, title, toEmail);

    }

    public static void sendToOther(String mailbody, String title, String toEmail) {
        try {
            //指明让哪个smtp转发
            SendMail themail=new SendMail("smtp.163.com");
            //校验身份
            themail.setNeedAuth(true);

            //邮件标题
            if(themail.setSubject(title) == false) return;
            //将要发送的 内容放入邮件体
            if(themail.setBody(mailbody) == false) return;

            //发送到哪里
            if(themail.setTo(toEmail) == false) return;

            //谁发送的
            if(themail.setFrom("13062600485@163.com") == false) return;

            //将在sohu网站上的邮件用户名和 密码 放入邮件体
            //重要
            //必须开启smtp服务
            //密码必须是授权码
            themail.setNamePass("13062600485@163.com","IYOJGQJLIIIDHRCE");

            //发送
            if(themail.sendout() == false) return;
        } catch (Exception e) {
            throw  new RuntimeException(e.getMessage());
        }
    }
}