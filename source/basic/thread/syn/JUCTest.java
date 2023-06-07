package basic.thread.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @description:
 * @author: Feirouz
 * @date: 2023-06-07 21:22
 */

// 测试JUC安全类型的集合
public class JUCTest {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            });
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list.size());
    }
}
