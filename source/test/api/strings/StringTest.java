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

    /**
     * Java intern() 方法
     *      intern() 方法返回字符串对象的规范化表示形式。
     *          但是这个方法会首先检查字符串池中是否有”ab”这个字符串，如果存在则返回这个字符串的引用，
     *          否则就将这个字符串添加到字符串池中，然会返回这个字符串的引用。
     *
     * 结论
     *  1. 常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量
     *  2. 只要其中一个是变量，结果就在堆中
     *  3. 如果拼接的结果调用intern()方法，返回值就在常量池中
     */
    @Test
    public void test2() {
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);   //true
        System.out.println(s3 == s5);   //false
        System.out.println(s3 == s6);   //false
        System.out.println(s3 == s7);   //false
        System.out.println(s5 == s6);   //false
        System.out.println(s5 == s7);   //false
        System.out.println(s6 == s7);   //false

        String s8 = s5.intern();    //返回值 = 常量池中已经存在的“javaEEhadoop”
        System.out.println(s3 == s8);   //true
    }
}
