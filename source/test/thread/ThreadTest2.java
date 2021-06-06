package test.thread;

/**
 * @description: 学习2 线程的创建方式
 * @author: Feirouz
 * @date: 2021-06-04 17:23
 *
 * 多线程的创建 方式一：继承于Thread类 使用匿名子类的方式
 * 练习：创建两个线程，其中一个遍历100内的偶数，一个遍历100内的奇数
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        // 1. 创建Thread类的匿名子类
        new Thread(){
            // 2. 重写run()方法
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " = " + i);
                    }
                }
            }
        // 3.调用start()
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + " = " + i);
                    }
                }
            }
        }.start();

        /*
            运行结果：
                ...
                Thread-0 = 30
                Thread-1 = 1
                Thread-1 = 3
                Thread-1 = 5
                Thread-1 = 7
                Thread-1 = 9
                Thread-0 = 32
                ...
         */
    }
}
