package test.net.URLTest2;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @description: URL网络编程练习2
 * @author: Feirouz
 * @date: 2021-07-25 19:56
 *
 * URL网络编程练习
 *  将网上的java文件下载到本地上
 */
public class URLTest2 {
    public static void main(String[] args) throws IOException {
        // 1.初始化参数
        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;

        try {
            // 2.创建需要连接的url网址
            URL url = new URL("https://github.com/CrazyFeirouz/CodeLife_Java/blob/main/source/test/net/URLTest1.java");

            // 3.开始连接
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            // 4.获取输入流
            is = urlConnection.getInputStream();

            // 5.创建输出流
            fos = new FileOutputStream("source/test/net/URLTest2/download/downloadHtml.html");

            // 6.读取并写出文件操作
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            // 7.提示
            System.out.println("下载完成");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 8.关闭资源
            if(fos != null) {
                fos.close();
            }
            if(is != null) {
                is.close();
            }
            if(urlConnection != null) {
                urlConnection.disconnect();
            }
        }


    }
}
