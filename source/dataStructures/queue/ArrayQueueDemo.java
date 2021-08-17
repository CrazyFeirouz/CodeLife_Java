package dataStructures.queue;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @description: 使用数组模拟队列
 * @author: Feirouz
 * @date: 2021-08-17 15:31
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';     // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("===========================");
            System.out.println("s(show)：显示队列");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从数列取出数据");
            System.out.println("h(head)：查看队列头的数据");
            System.out.println("e(exit)：退出程序");
            System.out.println("===========================");
            key = scanner.next().charAt(0);     // 接收一个字符
            switch (key) {
                case 's':   // 显示队列
                    arrayQueue.showQueue();
                    break;
                case 'a':   // 添加数据到队列
                    System.out.print("请输入要添加的值：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {   // 从数列取出数据
                        int data = arrayQueue.getQueue();
                        System.out.println("获得数据：" + data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':   // 查看队列头的数据
                    try {
                        int head = arrayQueue.headQueue();
                        System.out.println("获得头数据：" + head);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'e':   // 退出程序
                    scanner.close();
                    System.out.println("程序结束");
                    loop = false;
            }
        }
    }

}

// 使用数组模拟队列 - 编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize;    // 表示数组的最大容量
    private int front;      // 队列头
    private int rear;       // 队列尾
    private int[] arr;      // 该数据用于存储数据，模拟队列

    // 创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;     // 指向队列头部，front是指向队列头的前一个位置
        rear = -1;      // 指向队列尾部，指向队尾（队列最后一个数据）具体下标
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        // 判断队列是否满
        if(isFull()) {
            System.out.println("队列已满，添加失败");
            return;
        }
        rear++; // 让rear后移
        arr[rear] = n;
    }

    // 获取队列的数据，出队列
    public int getQueue() {
        // 判断队列是否为空
        if(isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列为空，无数据显示");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d]\t", i);
        }
        System.out.println();
        for (int i : arr){
            System.out.printf(" %d\t", i);
        }
        System.out.println();
    }

    // 显示队列的头数据，注意：不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无数据取出");
        }
        return arr[front + 1];
    }


}
