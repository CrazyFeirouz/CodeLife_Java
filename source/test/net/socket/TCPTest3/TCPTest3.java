package test.net.socket.TCPTest3;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @description: 实现TCP的网络编程练习3
 * @author: Feirouz
 * @date: 2021-07-24 18:20
 *
 * 实现TCP网络编程
 *  从客户端发送文件给服务端，服务端保存到本地。
 *  并返回“发送成功”给客户端，关闭相应连接（在练习2基础上加了这一步）
 */
public class TCPTest3 {
    //客户端 -- 为了可观性，服务端处理异常我就直接抛了
    @Test
    public void client() throws IOException {
        // 1.创建Socket对象，指明服务器ip和端口号
        InetAddress cnet = InetAddress.getByName("127.0.0.1");
        Socket cs = new Socket(cnet, 12345);

        // 2.获取一个输出流，用于输出数据
        OutputStream os = cs.getOutputStream();

        // 3.读取文件数据并写进os操作
        // 3.1 创建字节输入流
        FileInputStream fos = new FileInputStream("source/test/net/socket/TCPTest3/clientFile/photo.jpg");
        // 3.2 创建缓存流
        BufferedInputStream bis = new BufferedInputStream(fos);
        // 3.3 开始读取并写入bos操作
        byte[] buffer = new byte[1024];
        int len;
        while((len = bis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        // 4.通知服务器，输入操作已终止 -- “可停止流接收，清进行下一步操作”
        //      如果没有这一步，两边都会阻塞
        //          客户端：文件已传完，执行至getInputStream，等待服务器反馈
        //          服务端：虽然我文件已经存好了，但我并没有收到指令停止接收，所以我还在接收状态中，也不会执行到getOutputStream

        cs.shutdownOutput();

        // 5.等待接收服务端反馈，并显示到控制台上
        InputStream is = cs.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2 = is.read(buffer2)) != -1) {
            baos.write(buffer2, 0, len2);
        }
        System.out.println("接收来自：" + cs.getInetAddress().getHostAddress() + "的信息");
        System.out.println("\t" + baos.toString());


        // 5.关闭资源
        os.close();
        bis.close();
        is.close();
        baos.close();   // 这个其实可以不用关，关了以后一样能调用且不会报异常
        cs.close();
    }

    //服务器端 -- 为了可观性，服务端处理异常我就直接抛了
    @Test
    public void server() throws IOException {
        // 1.创建服务器端的ServerSocket，指明自己的端口号
        ServerSocket serverSocket = new ServerSocket(12345);

        // 2. 调用accept()表示接收来自客户端的socket - 若无接收到，服务器会一直停在这一步
        Socket ss = serverSocket.accept();

        // 3. 获取socket的输入流
        InputStream is = ss.getInputStream();

        // 4.读取客户端发来的文件
        // 4.1 创建字节输出流
        FileOutputStream fos = new FileOutputStream("source/test/net/socket/TCPTest3/serverFIle/photo.jpg");
        // 4.2. 创建缓存流
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        // 4.3 开始读取文件并写入服务器本地操作
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }

        // 5.给予客户端反馈
        OutputStream os = ss.getOutputStream();
        os.write("服务器端已接收，连接关闭".getBytes(StandardCharsets.UTF_8));

        // 6.关闭资源
        bos.close();    //外层关闭时内层也会关闭
        is.close();
        os.close();
        ss.close();

    }
}
