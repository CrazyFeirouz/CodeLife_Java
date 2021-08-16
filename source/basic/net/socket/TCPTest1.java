package basic.net.socket;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @description: 实现TCP的网络编程的小练习
 * @author: Feirouz
 * @date: 2021-07-23 16:09
 *
 * 实现TCP网络编程
 *  客户端发送消息给服务端，服务端将数据显示在控制台上
 */
public class TCPTest1 {
    //客户端
    @Test
    public void client() {
        Socket cs = null;
        OutputStream os = null;

        try {
            // 1. 创建Socket对象，指明服务器的ip和端口号
            InetAddress cnet = InetAddress.getByName("127.0.0.1");
            cs = new Socket(cnet, 12345); //端口号最大值：65535
            // 2. 获取一个输出流，用于输出数据
            os = cs.getOutputStream();
            // 3. 写出数据的操作
            os.write("你好，我是客户端".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 资源关闭
            if (cs != null) {
                try {
                    cs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //服务端 -- 为了可观性，服务端处理异常我就直接抛了
    @Test
    public void server() throws IOException {
        // 1. 创建服务器端的ServerSocket，指明自己的端口号
        ServerSocket ss = new ServerSocket(12345);
        // 2. 调用accept()表示接收来自客户端的socket - 若无接收到，服务器会一直停在这步
        Socket socket = ss.accept();
        // 3. 获取socket的输入流
        InputStream is = socket.getInputStream();

        // 4. 读取输入流
        // 读取写法一：不建议这样写
//        byte[] buffer = new byte[2];  //这里给小，会出现乱码，给大没事
//        int len;
//        while((len = is.read(buffer)) != -1) {
//            String s = new String(buffer, 0, len, "UTF-8");
//            System.out.print(s);
//        }

        // 读取写法二：由于你传输的字符含有中文 - 可以使用 转换流
//        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
//        char[] c = new char[2];
//        int len;
//        while ((len = isr.read(c)) != -1) {
//            String s = new String(c, 0, len);
//            System.out.print(s);
//        }
//        is.close();
//        socket.close();
//        ss.close();

        // 写法三：使用 写入ByteArrayOutputStream 来代替 创建String的过程
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[2];
        int len;
        while((len = is.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
        }
        System.out.println("接受来自：" + socket.getInetAddress().getHostAddress() + "的数据");
        System.out.println(baos.toString());

        // 5. 关闭资源
        baos.close();   // 这个其实可以不用关，关了以后一样能调用且不会报异常
        is.close();
        socket.close();
        ss.close();
    }
}
