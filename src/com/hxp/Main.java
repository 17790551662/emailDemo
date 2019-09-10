package com.hxp;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import javax.net.ssl.SSLContext;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Main {

//    private static CloseableHttpClient httpClient;
    /*static {
        try {
            SSLContext sslContext = new SSLContextBuilder().useProtocol(SSLConnectionSocketFactory.SSL)
                    .loadTrustMaterial(null,(x, y) -> true).build();

            RequestConfig config = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(5000).build();
            httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).setSSLContext(sslContext).setSSLHostnameVerifier((x, y) -> true).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) {
        List<String> receiver = new ArrayList<String>();
        if(args.length == 1){
            receiver.add(args[0]);
        }else{
            receiver.add("378663395@qq.com"); //ffkxelfjqdgwbjefmain()

        }

        List<String> stringList = (List<String>)receiver.subList(0, 3);


        MailInfo mailInfo = new MailInfo("测试邮件","测试邮件 --->  "+new Date().toString(),receiver,null);

        MessageSender.sendMail(mailInfo);
    }
}
