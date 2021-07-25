package test.net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @description: URL网络编程练习1
 * @author: Feirouz
 * @date: 2021-07-25 19:21
 *
 * URL网络编程
 * 1.URL ： 统一资源定位符，对应着互联网的某一资源地址
 * 2.格式 ：
 *  http://localhost:8080/files/photo.jpg?username=Feirouz
 *  协议      主机名   端口号   资源地址        参数列表
 */
public class URLTest1 {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://github.com/CrazyFeirouz/CodeLife_Java/blob/main/source/test/net/URLTest1.java");

            System.out.println("协议名：" + url.getProtocol());
            System.out.println("主机名：" + url.getHost());
            System.out.println("端口号：" + url.getPort());
            System.out.println("文件路径：" + url.getPath());
            System.out.println("文件名：" + url.getFile());
            System.out.println("查询名：" + url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
