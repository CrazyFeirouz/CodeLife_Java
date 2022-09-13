package jvm.chapter02.ex2;

/**
 * @description: 双亲委派机制 - 测试
 * @author: Feirouz
 * @date: 2022/9/13 21:48
 */
public class StringTest1 {
    public static void main(String[] args) {
        // 若新建java.lang.String, 也不会先加载你新建的
        String s = new java.lang.String();
        System.out.println("Hello");
    }
}
