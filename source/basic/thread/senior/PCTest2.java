package basic.thread.senior;

/**
 * @description:
 * @author: Feirouz
 * @date: 2023-06-08 12:31
 */

// 测试生产者消费者问题2：信号灯法，标志位解决

public class PCTest2 {
    public static void main(String[] args) {
        TV tv = new TV();
        Player player = new Player(tv);
        Watcher watcher = new Watcher(tv);

        player.start();
        watcher.start();
    }
}

// 生产者 --> 演员
class Player extends Thread{
    TV tv;
    public Player(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0){
                this.tv.play("快乐大本营播放中");
            }{
                this.tv.play("抖音记录生活");
            }
        }
    }
}

// 消费者 --> 观众
class Watcher extends Thread{
    TV tv;
    public Watcher(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

// 产品 --> 节目
class TV{
    // 演员表演，观众等待 T
    // 观众观看，演员等待 F

    String voice;   // 表演的节目
    boolean flag = true;

    // 表演
    public synchronized void play(String voice) {
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("演员表演了:" + voice);
        // 通知观众观看
        this.notifyAll();   //通知唤醒
        this.voice = voice;
        flag = !flag;
    }
    // 观看
    public synchronized void watch(){
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("观看了:" + voice);
        // 通知演员表演
        this.notifyAll();;
        flag = !flag;
    }
}
