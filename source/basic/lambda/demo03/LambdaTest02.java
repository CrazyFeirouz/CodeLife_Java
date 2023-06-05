package basic.lambda.demo03;

/**
 * @description:
 * @author: Feirouz
 * @date: 2023-06-05 13:17
 */

/**
 * Lambda总结
 *  前提是接口为函数式接口
 *  Lambda表达式只能有一行代码的情况下才能简化成为一行，如果有多行，那么就用代码块包裹
 *  多个参数也可以去掉参数类型，要去掉就都去掉，必须加上括号
 */
public class LambdaTest02 {
    public static void main(String[] args) {

        // Lambda - 表示简化
        ILove l1 = (int a) -> {
            System.out.println("i love you--->" + a);
        };
        l1.love(1);

        // Lambda简化1 - 参数类型简化
        ILove l2 = (a) -> {
            System.out.println("i love you--->" + a);
        };
        l2.love(2);

        // Lambda简化2 - 参数括号简化
        ILove l3 = a -> {
            System.out.println("i love you--->" + a);
        };
        l3.love(3);

        // Lambda简化3 - 花括号简化
        ILove l4 = a -> System.out.println("i love you--->" + a);
        l4.love(4);
    }
}

interface ILove{
    void love(int a);
}


