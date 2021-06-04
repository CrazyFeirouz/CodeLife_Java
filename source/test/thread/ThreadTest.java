package test.thread;

/**
 * @description: 学习1 线程的创建方式
 * @author: Feirouz
 * @date: 2021-06-04 16:16
 *
 * 多线程的创建 方式一：继承于Thread类
 *  1. 创建一个继承于Thread类的子类
     *  2. 重写Thread类的run() --> 将此线程执行的操作声明在run()中
 *  3. 创建Thread类的子类对象
 *  4. 通过此对象调用start()
 *
 * 例子：遍历100以内的所有偶数
 */

// 1. 创建一个继承于Thread类的子类
class MyThread extends Thread {

    // 2. 重写Thread类的run() --> 将此线程执行的操作声明在run()中
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " = " + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        // 3. 创建Thread类的子类对象
        MyThread myThread = new MyThread();

        // 4. 通过此对象调用start() ：①启动当前线程 ②调用当前线程的run()
        myThread.start();

        // 问题一：我们不能通过直接调用run() 的方式启动线程。（直接调用其实是 main主线程在调用）
//        myThread.run();
        // 问题二：在启动一个线程，不可以再让已经start()的线程去执行。（会报IllegalThreadException）
//        myThread.start();
        // 问题二解决方式：在创建一个线程的对象，重写调用start()
        MyThread myThread2 = new MyThread();
        myThread2.start();

        // 这里是主线程的遍历 - (每次会不一致)
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + " = " + i);
            }
        }

        /*
            运行结果：
                Thread-0 = 0
                Thread-1 = 0
                Thread-1 = 2
                Thread-1 = 4
                Thread-1 = 6
                Thread-1 = 8
                Thread-1 = 10
                Thread-1 = 12
                main = 1
                Thread-1 = 14
                ....
         */
    }
}
