package basic.api.wrapper;

import org.junit.Test;

public class InterviewTest2S {

    /**
     * 面试题2
     * 猜猜答案是多少？
     * @Date 2021.05.09
     * @Des 考察关于Integer的内部类IntegerCache的知识
     * 有意思....
     */
    @Test
    public void test1() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);         //false

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);         //true

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);         //false

        /**
         * Why???
         * 这里就有个知识点：
         *      在Integer类中，有个名为IntegerCache的内部类 —— Integer的缓存类
         *          IntegerCache会在Integer初始化时同时进行第一次初始化。
         *
         *          源码：
         *          private static class IntegerCache {
         *                  static final int low = -128;
         *                  static final int high;
         *                  static final Integer cache[];
         *
         *          为啥要有这个类？ 为了提高性能：
         *              [-128,127] 范围内的Integer都被存储到了 cache[] 当中。
         *              如果我们使用自动装箱的方式，给Intefer赋值的范围在 -128~127中时，
         *              可以直接使用数组中的元素，不用再去new了。
         *
         * 这题就对应，由于值为1的Integer在cache[]中，所以直接使用了数组中的同一个Integer，所以==时，比较地址时完全一样的。
         * 但由于128超出范围，并不在缓存中，结果还是new出来的。导致==比较地址不一致。
         */

    }
}
