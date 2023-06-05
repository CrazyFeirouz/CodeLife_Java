package basic.thread.state;

import basic.thread.demo01.ThreadTest05;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: Feirouz
 * @date: 2023-06-05 19:55
 */
// 模拟网络延时 ： 放大问题的发生性
public class SleepTest implements Runnable{
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0){
                break;
            }
            // 模拟延时
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "买到了第" + ticketNums-- + "张票");
        }
    }

    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num <= 0) {
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        SleepTest t1 = new SleepTest();
//
//        new Thread(t1,"小明").start();
//        new Thread(t1,"小红").start();
//        new Thread(t1,"小黑").start();
//
//        Thread.sleep(2000);
//        System.out.println("最后剩余" + t1.ticketNums + "张票");

        // 打印系统时间
        Date startTime = new Date(System.currentTimeMillis());  // 获取系统当前时间
        while (true) {
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            startTime = new Date(System.currentTimeMillis());
        }
    }

}
