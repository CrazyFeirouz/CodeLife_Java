package basic.thread.demo01;

/**
 * @description:
 * @author: Feirouz
 * @date: 2023-06-02 11:43
 */

// 多个线程同时操作同一个对象
// 买火车票的例子

// 发现问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱
public class ThreadTest05 implements Runnable{

    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0){
                break;
            }
            // 模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "买到了第" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest05 t1 = new ThreadTest05();

        new Thread(t1,"小明").start();
        new Thread(t1,"小红").start();
        new Thread(t1,"小黑").start();

        Thread.sleep(2000);
        System.out.println("最后剩余" + t1.ticketNums + "张票");

    }
}
