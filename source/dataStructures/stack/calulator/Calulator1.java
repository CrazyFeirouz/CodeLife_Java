package dataStructures.stack.calulator;

/**
 * @description: 模拟计算器
 * @author: Feirouz
 * @date: 2021-08-29 16:55
 * 该程序有问题：
 *      1. 无法计算多位数 (已解决)
 *      2. 无法计算负数
 *      3. 可计算运算符只有 "/+-*"
 */
public class Calulator1 {
    public static void main(String[] args) {
        // 完成表达式的运算
        String expression = "12+24*200+700";
        // 创建两个栈，数栈、符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        // 定义需要的相关变量
        int index = 0;  // 用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';   // 将每次扫描得到的char保存到ch
        String keepNum = "";    // 用于拼接 多位数
        // 开始while循环的扫描expression
        while(index < expression.length()) {   // 让 index + 1，并判断是否扫描到expression最后
            // 依次得到expression的每一个字符
            ch = expression.charAt(index);
            // 判断ch是什么，然后做相应的处理
            if (operStack.isOper(ch)) { // 如果是运算符
                // 判断当前的符号栈是否为空
                if (operStack.isEmpty()) {  // 符号栈为空，直接入栈
                    operStack.push(ch);
                } else {    // 当前符号栈不为空
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        // 如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或等于栈中的操作符
                        //      就需要从数栈中pop出两个数，从符号栈pop出一个符号，进行运算
                        //      得到结构后，入数栈，然后将当前操作符入符号栈
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        // 如果当前的操作符优先级大于符号栈中的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                }
            } else {    // 当前是数，直接进入数栈
                // 分析思路
                // 1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                // 2. 在处理数，需要expression的表达式的index。后在看一位，如果是数就进行扫面，如果是符号才入栈。
                // 3. 因为我们需要定义一个变量 字符串，用于拼接

                // 处理多位数
                keepNum += ch;

                if (index + 1 == expression.length()){  // 如果ch已经是expression的最后一位，就直接入栈
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    // 判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                    // 注意看后一位，不是index++
                    if (operStack.isOper(expression.charAt(index+1))){
                        // 如果后一位是运算符，则入栈 keepNum = "1" 或者 "123"
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
                // 旧方案
//                numStack.push(ch - 48);
            }
            // 循环变量迭代
            index++;
        }
        // 当表达式扫描完毕，并录入了栈，就顺序的从 数栈和符号栈 中pop出相应的数和符号，并运行
        while(!operStack.isEmpty()) {   // 如果栈符号为空，则计算到最后的结果，数栈中只有一个数字【结果】
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);     //结果入栈
        }
        int sum = numStack.pop();
        System.out.printf("表达式 %s = %d", expression, sum);

    }
}

// 模拟栈类
class ArrayStack2 {
    private int maxSize;    // 栈的大小
    private int[] stack;    // 数组，数组模拟栈，数据就放在该数组
    private int top = -1;   // top表示栈顶，初始化为-1

    // 构造器
    public ArrayStack2(int maxSize) {
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

    // 返回运算符的优先级，优先级程序员来确定，优先级使用数字来表示
    // 数字越大，则优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;  // 假定目前的表达式只有 +-*/
        }
    }

    // 判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;    // 用于存放计算结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;  // 注意顺序：先入后出，num2是先入的
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;  // 注意顺序：先入后出，num2是先入的
                break;
        }
        return res;
    }

    // 返回当前栈顶的值，但不是pop
    public int peek() {
        return stack[top];
    }
}