package design.pattern.structural.demo02;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @description:
 * @author: Feirouz
 * @date: 2023-06-04 18:05
 */

// 线程创建的方式三：实现Callable接口
/*
Callable的好处
1. 可以定义返回值
2. 可以抛出异常
 */
public class CallableTest implements Callable<Boolean> {
    private String url;
    private String filename;

    public CallableTest(String url, String filename){
        this.url = url;
        this.filename = filename;
    }

    // 下载图片执行体
    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloade(url,filename);
        System.out.println("下载的文件名为" + filename);
        return true;
    }

    public static void main(String[] args) {
        CallableTest t1 = new CallableTest("https://i0.hdslb.com/bfs/archive/8a4c723d26489e3a08ef0497f2eb2f00335bcb29.png","file/photo/1.png");
        CallableTest t2 = new CallableTest("https://i0.hdslb.com/bfs/archive/8a4c723d26489e3a08ef0497f2eb2f00335bcb29.png","file/photo/2.png");
        CallableTest t3 = new CallableTest("https://i0.hdslb.com/bfs/archive/8a4c723d26489e3a08ef0497f2eb2f00335bcb29.png","file/photo/3.png");

        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        // 提交执行
        Future<Boolean> result1 = ser.submit(t1);
        Future<Boolean> result2 = ser.submit(t2);
        Future<Boolean> result3 = ser.submit(t3);
        // 获取结果
        try {
            boolean r1 = result1.get();
            boolean r2 = result2.get();
            boolean r3 = result3.get();

            System.out.println(r1);
            System.out.println(r2);
            System.out.println(r3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 关闭服务
        ser.shutdownNow();
    }

}

// 下载器
class WebDownloader {
    // 下载方法
    public void downloade(String url, String filename){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，download方法出现异常");
        }
    }
}