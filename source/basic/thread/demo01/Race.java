package basic.thread.demo01;

/**
 * @description:
 * @author: Feirouz
 * @date: 2023-06-02 12:18
 */

// 案例：龟兔赛跑
public class Race implements Runnable{
    // 胜利者
    private static String winner;

    @Override
    public void run() {
        int step = 0;
        // 判断比赛是否结束
        while (!gameOver(step)) {
            // 模拟兔子休息
            if (Thread.currentThread().getName().equals("兔子") && step % 10 == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "->> 跑了 " + step + "步");
            step++;
        }
    }

    public boolean gameOver(int steps){
        // 判断是否有胜利者
        if (winner != null) {   // 已经存在胜利者了
            return true;
        }{
            if (steps >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner is " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
