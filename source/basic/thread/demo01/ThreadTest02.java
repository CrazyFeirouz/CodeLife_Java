package basic.thread.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @description:
 * @author: Feirouz
 * @date: 2023-06-01 20:55
 */
// 使用方式一来完成下载图片案例
public class ThreadTest02 extends Thread{
    private String url;
    private String filename;

    public ThreadTest02(String url, String filename){
        this.url = url;
        this.filename = filename;
    }

    // 下载图片执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloade(url,filename);
        System.out.println("下载的文件名为" + filename);
    }

    public static void main(String[] args) {
        ThreadTest02 t1 = new ThreadTest02("https://i0.hdslb.com/bfs/archive/8a4c723d26489e3a08ef0497f2eb2f00335bcb29.png","file/photo/1.png");
        ThreadTest02 t2 = new ThreadTest02("https://i0.hdslb.com/bfs/archive/8a4c723d26489e3a08ef0497f2eb2f00335bcb29.png","file/photo/2.png");
        ThreadTest02 t3 = new ThreadTest02("https://i0.hdslb.com/bfs/archive/8a4c723d26489e3a08ef0497f2eb2f00335bcb29.png","file/photo/3.png");

        // 不一定按照你写的顺序下载，看系统分配
        t1.start();
        t2.start();
        t3.start();
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
