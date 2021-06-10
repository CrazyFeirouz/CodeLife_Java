package test.thread;

import test.oop.interfaces.C;

/**
 * @description: 线程通信的应用：经典例题：生产者/消费者
 * @author: Feirouz
 * @date: 2021-06-10 16:05
 * <p>
 * 生产者（Productor）将产品交给店员（Clerk），
 * 而消费者（Customer）从店员处取走产品，
 * 店员一次只能持有固定数量的产品（比如：20），
 * 如果生产者试图生产更多的产品，店员会叫生产者停一下，如果店中有空位了再通知生产者继续生产；
 * 如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 * <p>
 * 分析：
 * 1. 是否是多线程问题？ 是，生产者线程，消费者线程，店员线程
 * 2. 是否有共享数据？ 是，店员（或产品）
 * 3. 如何解决线程安全问题？ 同步机制，有三种方法
 * 4. 是否涉及线程的通信？ 是
 */

class Clerk {
    public int proQuantity = 0;

    //消费产品
    public synchronized void cost() {
        if (proQuantity > 0) {
            System.out.println(Thread.currentThread().getName() + "开始销售第" + proQuantity + "个产品");
            proQuantity--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    //生产产品
    public synchronized void product() {
        if (proQuantity < 20) {
            proQuantity++;
            System.out.println(Thread.currentThread().getName() + "开始生产第" + proQuantity + "个产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

// 生产者
class Producer implements Runnable {
    private Clerk clerk = null;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() { //生产产品
        while (true) {

            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.product();
        }
    }
}

// 消费者
class Customer implements Runnable {
    private Clerk clerk = null;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.cost();
        }
    }
}

public class ProAndCost {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Customer customer = new Customer(clerk);

        Thread p1 = new Thread(producer);
        p1.setName("生产者1");

        Thread c1 = new Thread(customer);
        c1.setName("消费者1");

        Thread c2 = new Thread(customer);
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();
    }
}
