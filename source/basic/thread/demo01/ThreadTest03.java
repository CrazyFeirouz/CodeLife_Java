package basic.thread.demo01;

/**
 * @description:
 * @author: Feirouz
 * @date: 2023-06-01 22:23
 */

// 创建线程方式二：实现runnable接口，重写run方法，职行线程需要丢入runnable接口实现类，调用start方法
public class ThreadTest03 implements Runnable{
    @Override
    public void run() {
        // run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args) {
        // main线程，主线程

        // 创建runnable接口的实现类对象
        ThreadTest03 t1 = new ThreadTest03();
        // 创建线程对象，通过线程对象来开启我们的线程，代理
        new Thread(t1).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程---" + i);
        }
    }
}
