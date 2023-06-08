package basic.thread.senior;

/**
 * @description:
 * @author: Feirouz
 * @date: 2023-06-08 11:25
 */

// 测试：生产者消费者模型-->利用缓冲区解决：管程法
// 生产者，消费者，产品，缓冲区
public class PCTest {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        Productor productor = new Productor(container);
        Consumer consumer = new Consumer(container);

        productor.start();
        consumer.start();
    }
}

// 生产者
class Productor extends Thread{
    SynContainer container;

    public Productor(SynContainer container){
        this.container = container;
    }

    // 生产
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            container.push(new Chicken(i));
        }
    }
}

// 消费者
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            container.pop();
        }
    }
}

// 产品
class Chicken{
    int id;     // 产品编号

    public Chicken(int id) {
        this.id = id;
    }
}

class SynContainer{
    // 需要一个容器大小
    Chicken[] chickens = new Chicken[10];
    // 容器计数器
    int count = 0;

    // 生产者放入产品
    public synchronized void push(Chicken chicken){
        // 如果容器满了，就需要等待消费者消费
        if (count == chickens.length){
            // 通知消费者消费，生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        // 如果没有满，我们就需要生产产品
        chickens[count] = chicken;
        System.out.println("生产了鸡" + chicken.id + "号");
        count++;

        // 可以通知消费者消费了
        this.notifyAll();
    }

    // 消费者消费产品
    public synchronized Chicken pop(){
        // 判断是否能消费
        if (count == 0){
            // 消费者等待生产者生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 如果可以消费
        count--;
        Chicken chicken = chickens[count];
        System.out.println("消费了鸡" + chicken.id + "号");

        // 吃完了，通知生产者生产
        this.notifyAll();

        return chicken;
    }
}