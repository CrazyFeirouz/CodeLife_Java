package test.api.strings;

import org.junit.Test;

/**
 * @description: String的实例化方式
 * @author: Feirouz
 * @date: 2021-06-14 16:03
 *
 * 方式一： 通过字面量定义的方式
 * 方式二： 通过new + 构造器的方式
 *
 * 面试题：String str2 = new String("abc") 创建对象，在内存中创建了几个对象？
 *      两个。
 *      ① 堆空间的new结构
 *      ② char[] 对应的常量池中的数据：”abc“
 */
public class StringTest {

    @Test
    public void test() {
        // 通过字面量定义的方式：此时的s1和s2的数据JavaEE声明在方法区中的字符串常量池中
        String s1 = "javaEE";
        String s2 = "javaEE";
        // 通过new + 构造器的方式：此时的s3和s4保存的地址值，是数据在堆空间中开辟以后对应的地址值
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);   //true
        System.out.println(s1 == s3);   //false
        System.out.println(s1 == s4);   //false
        System.out.println(s3 == s4);   //false
    }
}
