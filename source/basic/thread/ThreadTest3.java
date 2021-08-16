package basic.thread;

/**
 * @description: 学习3 线程的创建方式
 * @author: Feirouz
 * @date: 2021-06-06 18:04
 *
 * 多线程的创建 方式二：实现Runnable接口
 *  1. 创建一个实现了Runnable接口的类
 *  2. 实现类去实现Runnable中的抽象方法：run()
 *  3. 创建实现类的对象
 *  4. 将此对象作为参数传递到了Thread类的构造器中，创建Thread类的对象
 *  5. 通过Thread类的对象调用start()
 */

// 1. 创建一个实现了Runnable接口的类
class myRunnable implements Runnable {

    // 2. 实现类去实现Runnable中的抽象方法：run()
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
public class ThreadTest3 {
    public static void main(String[] args) {
        // 3. 创建实现类的对象
        myRunnable myRunnable = new myRunnable();
        // 4. 将此对象作为参数传递到了Thread类的构造器中，创建Thread类的对象
        Thread thread1 = new Thread(myRunnable);
        // 5. 通过Thread类的对象调用start() ：
        // ①启动线程
        // ②调用当前线程的run() --> 调用了Runnable类型的target的run()
        thread1.start();


        Thread thread2 = new Thread(myRunnable);
        thread2.setName("线程2");
        thread2.start();
    }
}
