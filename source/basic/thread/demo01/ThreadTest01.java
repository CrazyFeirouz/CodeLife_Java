package basic.thread.demo01;

/**
 * @description:
 * @author: Feirouz
 * @date: 2023-06-01 19:30
 */

// 创建线程方式一：继承Thread类，重写run方法，调用start开启线程

// 总结：注意，线程开局不一定立即执行，由CPU调度执行
public class ThreadTest01 extends Thread{
    @Override
    public void run() {
        // run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args) {
        // main线程，主线程

        // 创建一个线程对象
        ThreadTest01 t1 = new ThreadTest01();
        // 调用 start() 开启线程
        t1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程---" + i);
        }
    }
}
