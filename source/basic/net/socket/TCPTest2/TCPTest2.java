package basic.net.socket.TCPTest2;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: 实现TCP的网络编程练习2
 * @author: Feirouz
 * @date: 2021-07-24 17:35
 *
 * 实现TCP网络编程
 *  客户端发送文件给服务端，服务端将文件保存在本地
 */

public class TCPTest2 {
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
        FileInputStream fis = new FileInputStream("source/basic/net/socket/TCPTest2/clientFile/photo.jpg");
        // 3.2 创建缓存流
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(os);
        // 3.3 开始读取并写入bos操作
        byte[] buffer = new byte[1024];
        int len;
        while((len = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }

        // 4.关闭资源
        bos.close();    //外层关闭时内层也会关闭
        bis.close();
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
        FileOutputStream fos = new FileOutputStream("source/basic/net/socket/TCPTest2/serverFile/photo.jpg");
        // 4.2. 创建缓存流
        BufferedInputStream bis = new BufferedInputStream(is);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        // 4.3 开始读取文件并写入服务器本地操作
        byte[] buffer = new byte[1024];
        int len;
        while((len = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }

        // 5.关闭资源
        bos.close();    //外层关闭时内层也会关闭
        bis.close();
        ss.close();

    }
}
