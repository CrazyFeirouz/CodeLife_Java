package dataStructures.stack;

import java.util.Scanner;

/**
 * @description: 栈的模拟
 * @author: Feirouz
 * @date: 2021-08-28 16:56
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        // 测试一下 ArrayStack
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        ArrayStack arrayStack = null;
        int data = -1;
        while(loop) {
            System.out.println("====================================");
            System.out.println("n - 创建新栈");
            System.out.println("o - 出栈");
            System.out.println("p - 入栈");
            System.out.println("s - 展示栈");
            System.out.println("e - 退出程序");
            System.out.println("====================================");
            System.out.printf("请输入你需要的操作：");
            key = scanner.next();
            switch (key) {
                case "n":   // 输入创建新栈
                    System.out.printf("请输入创建的栈大小：");
                    int size = scanner.nextInt();
                    arrayStack = new ArrayStack(size);
                    break;
                case "o":   // 出栈操作
                    if (arrayStack != null) {
                        int num = arrayStack.pop();
                        System.out.println("出栈数据为" + num);
                    }else {
                        System.out.println("请先创建栈");
                    }
                    break;
                case "p":   // 入栈操作
                    if (arrayStack != null) {
                        System.out.printf("请输入要入栈的数据（int类型）：");
                        data = scanner.nextInt();
                        arrayStack.push(data);
                    }else {
                        System.out.println("请先创建栈");
                    }
                    break;
                case "s":   // 展示栈结构
                    if (arrayStack != null) {
                        arrayStack.show();
                    }else {
                        System.out.println("请先创建栈");
                    }
                    break;
                case "e":
                    loop = false;
            }
        }
    }
}

// 模拟栈类
class ArrayStack {
    private int maxSize;    // 栈的大小
    private int[] stack;    // 数组，数组模拟栈，数据就放在该数组
    private int top = -1;   // top表示栈顶，初始化为-1

    // 构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    // 判断空栈
    public boolean isEmpty() {
        return top == -1;
    }

    // 判断满栈
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 入栈
    public void push(int data) {
        if (isFull()) {
            System.out.println("当前栈已满，无法入栈");
            return;
        }
        top++;
        stack[top] = data;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("当前栈为空，无法出栈");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 遍历栈
    public void show() {
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] - %d\n", i, stack[i]);
        }
    }


}


