package basic.thread.state;

/**
 * @description:
 * @author: Feirouz
 * @date: 2023-06-05 21:06
 */
public class JoinTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("线程vip来了... ==" + i + "== 闪亮登场");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 启动我们的线程
        JoinTest joinTest = new JoinTest();
        Thread thread = new Thread(joinTest);
        thread.start();

        // 主线程
        for (int i = 0; i < 300; i++) {
            if (i == 10){
                thread.join();  // 排队
            }
            System.out.println("main线程回归... --" + i + "--");
        }
    }
}
