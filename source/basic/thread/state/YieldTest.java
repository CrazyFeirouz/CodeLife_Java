package basic.thread.state;

/**
 * @description:
 * @author: Feirouz
 * @date: 2023-06-05 20:53
 */
// 礼让线程
public class YieldTest implements Runnable{
    public static void main(String[] args) {
        YieldTest YieldTest = new YieldTest();
        new Thread(YieldTest,"a").start();
        new Thread(YieldTest,"b").start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程结束执行");
    }
}
