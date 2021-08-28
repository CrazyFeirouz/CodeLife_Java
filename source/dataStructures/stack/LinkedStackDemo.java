package dataStructures.stack;

/**
 * @description: 使用链表来模拟栈
 * @author: Feirouz
 * @date: 2021-08-28 19:19
 */

public class LinkedStackDemo {
    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);

        // 注意，这个 show 会破坏链表结构
//        linkedStack.show();
        int popNum = linkedStack.pop();
        System.out.println("拿到数据：" + popNum);

        linkedStack.show2();
    }
}

class LinkedStack {
    private StackNode top = null;

    // 判断空栈
    public boolean isEmpty() {
        return top == null;
    }

    // 入栈
    public void push(int data) {
        StackNode newNode = new StackNode();
        newNode.data = data;
        StackNode curNode = top;
        newNode.pre = curNode;
        top = newNode;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("当前栈为空，无法出栈");
        }else {
        int data = top.data;
        top = top.pre;
        return data;
        }
    }

    // 展示
    public void show() {
        while (!isEmpty()) {
            System.out.printf("%d\n", top.data);
            top = top.pre;
        }
    }

    // 展示2
    public void show2() {
        StackNode temp = top;
        while (temp != null) {
            System.out.printf("%d\n", temp.data);
            temp = temp.pre;
        }
    }
}

class StackNode {
    public int data;
    public StackNode pre;

    @Override
    public String toString() {
        return "StackNode{" +
                "data=" + data +
                ", pre=" + pre +
                '}';
    }
}