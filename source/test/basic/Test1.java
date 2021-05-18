package test.basic;

/**
 * 测试 += 和 =+ 的区别
 */
public class Test1 {
    public static void main(String[] args) {
        // +=运算符
        short s1 = 10;
        // s1 = s1 + 2;    // ！！编译失败 - 不兼容的类型: 从int转换到short可能会有损失
        s1 += 2;           // 优点：不会改变变量本身的数据类型
        System.out.println(s1);
    }
}
