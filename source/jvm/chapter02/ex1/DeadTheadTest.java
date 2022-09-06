package jvm.chapter02.ex1;

/**
 * @description:
 * @author: Feirouz
 * @date: 2022/9/6 16:59
 */
public class DeadTheadTest {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            DeadThread dead = new DeadThread();
            System.out.println(Thread.currentThread().getName() + "结束");
        };

        Thread t1 = new Thread(r, "线程1");
        Thread t2 = new Thread(r, "线程2");

        t1.start();
        t2.start();
    }
}

class DeadThread{
    static {
        if (true) {
            System.out.println(Thread.currentThread().getName() + "初始化");
            //虚拟机必须保证一个类的<clinit>()方法在多线程下被同步加锁。
            while (true){

            }

            /**
             * 若上面的while不加
             * 线程1开始
             * 线程2开始
             * 线程2初始化 --- 只会初始化一次
             * 线程2结束
             * 线程1结束
             */

            /**
             * 若上面的while加
             * 线程1开始
             * 线程2开始
             * 线程1初始化
             */
        }
    }
}