package basic.oop.mixture.test1;

/**
 *  对象可以赋值的位置
 *      PS：静态属性和非静态属性同理
 *      ①默认初始化
 *      ②显式初始化  /  在代码块中赋值 --- 这俩同级，分辨优先度 请看 上下顺序
 *      ③构造器中初始化
 *      ④有了对象以后，可以通过“对象.属性”或“对象.方法”的方式，进行赋值
 *
 *  执行顺序
 *      ① -> ② -> ③ -> ④
 */
public class BankTest {
    public static void main(String[] args) {
        System.out.println(Bank.id);
        new Bank();
        System.out.println(Bank.id);
        // ④对象.方法 进行赋值
        Bank.id = 4;
        System.out.println(Bank.id);

        /**
         * 执行结果：
         *      2
         *      1
         *      3
         *      4
         */
    }
}
class Bank {

    // ②
    // 代码块中赋值
    static {
        id = 2;
        System.out.println(Bank.id);
    }
    // 显式初始化
    static int id = 1;

    // ③构造器中初始化
    Bank () {
        id = 3;
    }

}
