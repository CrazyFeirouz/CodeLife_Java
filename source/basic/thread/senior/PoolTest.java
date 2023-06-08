package basic.thread.senior;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: Feirouz
 * @date: 2023-06-08 17:14
 */

// 测试线程池
public class PoolTest {

    public static void main(String[] args) {
        // 1. 创建服务，创建线程池
        // newFixedThreadPool 参数为：线程池大小
        ExecutorService ser = Executors.newFixedThreadPool(10);

        // 执行
        ser.execute(new MyThread());
        ser.execute(new MyThread());
        ser.execute(new MyThread());
        ser.execute(new MyThread());

        // 2.关闭链接
        ser.shutdown();
    }
}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
