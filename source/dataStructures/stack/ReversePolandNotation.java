package dataStructures.stack;

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
}

