package basic.reflection.test1;

/**
 * @description: 了解什么是反射
 * @author: Feirouz
 * @date: 2022-03-12 1:09
 */
public class ReflectionTestDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        // 通过反射获取类的Class对象
        // 一个类被加载后，类的整个结构都会被封装在Class对象中
        Class c1 = Class.forName("basic.reflection.test1.User");
        System.out.println(c1);         // class basic.reflection.test1.User
        Class c2 = Class.forName("basic.reflection.test1.User");
        // 一个类在内存中，只有一个Class对象
        System.out.println(c1 == c2);   // true
    }
}
