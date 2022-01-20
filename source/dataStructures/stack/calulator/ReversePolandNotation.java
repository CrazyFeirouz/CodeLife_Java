package dataStructures.stack.calulator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 逆波兰表达式计算器
 * @author: Feirouz
 * @date: 2021-08-31 23:48
 */
public class ReversePolandNotation {
    public static void main(String[] args) {
        // 先定义个逆波兰表达式
        String suffixExpression = "3 4 + 5 * 6 -";
        // 1. 将“表达式”放进列表中
        List<String> stringList = getListString(suffixExpression);
        // 2. 将 ArrayList 配合栈方法完成计算
        int res = calculate(stringList);
        System.out.println("结果是" + res);
    }

    @Test
    public void test1() {
        // 测试中缀表达式转后缀表达式
        String expression = "2*20+(30+4)*5-6";
        List<String> strings = toInfixExpressionList(expression);
        System.out.println(strings);
        List<String> list = parseSuffixExpressionList(strings);
        System.out.println(list);

        // 转换后缀表达式以后运算一下
        int res = calculate(list);
        System.out.println("运算结果为" + res);
    }

    // 将一个逆波兰表达式，依次将数据和运算符 放入到 ArrayList 中
    public static List<String> getListString (String suffixExpression) {
        // 将 suffixExpression 分隔
        String[] s = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : s) {
            list.add(ele);
        }
        return list;
    }

    /**
     * 完成对逆波兰表达式的运算
     *  1. 从右至左扫描，将3和4压入栈
     *  2. 遇到 + 运算符，因此弹出4和3（4位栈顶元素，3位次栈顶元素），计算出3+4的值=7，再将7入栈
     *  3. 将5入栈
     *  4. 接下来是 * 运算符，因此弹出5和7，计算5*7=35，将35入栈
     *  5. 将6入栈
     *  6. 最后是 - 运算符，计算出35-6的值，即29，由此得出最终结果
     */
    public static int calculate(List<String> ls) {
        // 创建给栈，只需要一个栈即可
        Stack<String> strStack = new Stack<>();
        // 遍历ls
        for (String item : ls) {
            // 这里使用正则表达式来取数
            if (item.matches("\\d+")) { // 匹配的是多位数
                // 入栈
                strStack.push(item);
            } else {
                // pop出两个数，并运算，再入栈
                int num1 = Integer.parseInt(strStack.pop());
                int num2 = Integer.parseInt(strStack.pop());
                int res = 0;
                switch (item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        throw new RuntimeException("含有非运算符/数字，请重新检查表达式");
                }
                // 把res 入栈
                strStack.push("" + res);
            }
        }
        // 最后留在stack中的数据是运算结果
        return Integer.parseInt(strStack.pop());
    }

    // 将中缀表达式转换成对应的List
    public static List<String> toInfixExpressionList(String s) {
        // 定义一个List，存放中缀表达式 对应的内容
        ArrayList<String> slist = new ArrayList<>();
        String str = ""; // 用于多位数的拼接
        char c;     // 用于判断当前字符
        int i = 0;  //指针
        while(i < s.length()) {
            c = s.charAt(i);
            if (c < 48 || c > 57) { // c是非数字，则直接加入ls
                slist.add("" + c);
                i++;
            }else { // 是一个数字
                str = "";
                while (i < s.length() &&  (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57){
                    str += c;   // 拼接
                    i++;
                }
                slist.add(str);
            }
        }
        return slist;
    }

    public static List<String> parseSuffixExpressionList(List<String> ls) {
        Stack<String> s1 = new Stack<>();
        // 说明：因为s2这个栈，在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出
        // 因此比较麻烦，这里我们就不用 Stack<String> 直接使用 List<String> s2;
        ArrayList<String> s2 = new ArrayList<>();

        // 遍历ls
        for (String item : ls) {
            // 如果是一个数，加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {  // 如果是"("，直接加入s1
                s1.push(item);
            } else if (item.equals(")")) {
                // 如果右边号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();   // 将(弹出s1栈，消除小括号
            } else {
                // 接下来是运算符
                // 当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
                // 问题：我们缺少一个比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                // 最后将item压入栈
                s1.push(item);
            }
        }
        // 将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() > 0) {
            s2.add(s1.pop());
        }
        return s2;
    }
}

// 编写一个类 Operation 可以返回一个运算符 对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    // 写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}

