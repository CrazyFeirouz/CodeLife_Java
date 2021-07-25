package test.net.socket;

import org.junit.Test;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * @description: 实现UDP协议的网络编程练习1
 * @author: Feirouz
 * @date: 2021-07-25 18:13
 *
 * 实现UDP网络编程
 *  发送端广播给接收端，接收端将数据显示在控制台上
 */
public class UDPTest1 {

    //发送端 -- 为了可观性，服务端处理异常我就直接抛了
    @Test
    public void sender() throws IOException {
        // 1. 创建DatagramSocket
        DatagramSocket socket = new DatagramSocket();

        // 2.1 要发送的地址
        InetAddress inet = InetAddress.getLocalHost();
        // 2.2 要发送的数据
        String str = "数据信息xxxxxxx";
        byte[] data = str.getBytes(StandardCharsets.UTF_8);
        // 2.3 创建创建DatagramPacket，指明要发送的地址，数据，数据长度，端口
        DatagramPacket packet = new DatagramPacket(data, data.length, inet, 12345);

        // 3. 使用DatagramSocket发送DatagramPacket
        socket.send(packet);

        // 4. 关闭DatagramSocket
        socket.close();
    }

    //接收端 -- 为了可观性，服务端处理异常我就直接抛了
    @Test
    public void receiver() throws IOException {
        // 1. 创建DatagramSocket，指明要接收的端口
        DatagramSocket socket = new DatagramSocket(12345);

        // 2.1 创建接收数据的数组
        byte[] buffer = new byte[1024];
        // 2.2 创建DatagramPacket，指明存储数组和有效数据长度
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        // 3. 接收数据
        socket.receive(packet);

        // 4. 打印接收数据
        System.out.println(new String(packet.getData(), 0, packet.getLength()));

        // 5. 关闭DatagramSocket
        socket.close();
    }
}
