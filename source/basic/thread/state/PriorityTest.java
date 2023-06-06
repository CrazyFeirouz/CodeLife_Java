package basic.thread.state;

/**
 * @description:
 * @author: Feirouz
 * @date: 2023-06-06 13:25
 */

// 测试线程优先级
public class PriorityTest{
    public static void main(String[] args) {
        // 主线程默认优先级
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());

        MyPriority mp = new MyPriority();
        Thread t1 = new Thread(mp,"random");
        Thread t2 = new Thread(mp,"p1");
        Thread t3 = new Thread(mp,"p4");
        Thread t4 = new Thread(mp,"pMax");
        Thread t5 = new Thread(mp,"p-1");
        Thread t6 = new Thread(mp,"p11");

        // 先设置优先级，再启动
        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);    //MAX_PRIORITY=10
        t4.start();

        t5.setPriority(-1);
        t5.start();

        t6.setPriority(11);
        t6.start();



    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }
}