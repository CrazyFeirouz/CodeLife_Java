package dataStructures.queue;

import java.util.Scanner;

/**
 * @description: 使用数组模拟环形队列
 * @author: Feirouz
 * @date: 2021-08-17 22:06
 */
public class CircleQueueDemo {
    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(4);
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
                    circleQueue.showQueue();
                    break;
                case 'a':   // 添加数据到队列
                    System.out.print("请输入要添加的值：");
                    int value = scanner.nextInt();
                    circleQueue.addQueue(value);
                    break;
                case 'g':
                    try {   // 从数列取出数据
                        int data = circleQueue.getQueue();
                        System.out.println("获得数据：" + data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':   // 查看队列头的数据
                    try {
                        int head = circleQueue.headQueue();
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

// 使用数组模拟环形队列 - 编写一个CircleQueue类
class CircleQueue {
    private int maxSize;    // 表示数组的最大容量
    private int front;      // 队列头 - 默认0
    private int rear;       // 队列尾 - 默认0
    private int[] arr;      // 该数据用于存储数据，模拟队列

    // 创建队列的构造器
    public CircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    // 获取队列的数据，出队列
    public int getQueue() {
        // 判断队列是否为空
        if(isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列为空，无数据显示");
            return;
        }
        for (int i = front; i < front + size(); i++){
            System.out.printf("[%d]=%d\t", i % maxSize, arr[i % maxSize]);
        }
        System.out.println();
    }

    // 求出当前队列的有效数据个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列的头数据，注意：不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无数据取出");
        }
        return arr[front];
    }
}