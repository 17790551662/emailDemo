package com.hxp;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class MailInfo {
    private String mailServerHost; // 发送邮件的服务器的IP
    private String mailServerPort; // 发送邮件的服务器端口
    private String userName; // 登陆邮件发送服务器的用户名
    private String userPassword; // 登陆邮件发送服务器的密码
    private String fromAddress; // 邮件发送者的地址
    private String toAddress; // 邮件接收者的地址
    private String ccAddress; // 邮件抄送者的地址
    private String fromUserName = "邮件測試"; // 邮件发送者的名称，显示在他人邮件的发件人
    private String mailSubject; // 邮件主题
    private String mailContent; // 邮件的文本内容
    private boolean authValidate = true; // 是否需要身份验证
    private Properties properties; // 邮件会话属性

    public MailInfo() {
    }

    public MailInfo(String title, String content, List<String> receiver, List<String> ccList) {
        Properties pro = getPro();
        this.mailServerHost = pro.getProperty("SMTP_SERVER");//MailCenterConstant.SMTP_SERVER;
        this.userName = pro.getProperty("USER");//MailCenterConstant.USER;
        this.userPassword = pro.getProperty("PWD");//MailCenterConstant.PWD;
        this.fromAddress = pro.getProperty("FROM_ADDRESS");//MailCenterConstant.FROM_ADDRESS;
        this.mailServerPort = pro.getProperty("PORT");
        this.toAddress = listToStringFormat(receiver);
        this.ccAddress = ccList==null?"":listToStringFormat(ccList);
        this.mailSubject = title;
        this.mailContent = content;
    }


    public Properties getPro(){
        try {
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("email.properties");
            Properties pro = new Properties();
            pro.load(in);
            return pro;
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
        return null;
    }


    private synchronized String listToStringFormat(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                stringBuilder.append(list.get(i));
            } else {
                stringBuilder.append(list.get(i)).append(",");
            }
        }
        return stringBuilder.toString();
    }

    public String getMailServerHost() {
        return mailServerHost;
    }

    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }

    public String getMailServerPort() {
        return mailServerPort;
    }

    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getCcAddress() {
        return ccAddress;
    }

    public void setCcAddress(String ccAddress) {
        this.ccAddress = ccAddress;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public boolean isAuthValidate() {
        return authValidate;
    }

    public void setAuthValidate(boolean authValidate) {
        this.authValidate = authValidate;
    }

    public Properties getProperties() {
        Properties p = new Properties();
        p.put("mail.smtp.host", this.mailServerHost);
        p.put("mail.smtp.port", this.mailServerPort);
        p.put("mail.smtp.auth", authValidate ? "true" : "false");
        p.put("mail.smtp.starttls.enable", "true");
        return p;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }


}
