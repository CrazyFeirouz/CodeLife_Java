package basic.api.wrapper;

import org.junit.Test;

public class InterviewTest1 {

    /**
     * 关于包装类的面试题1
     * @Date 2021.05.09
     * @Des 三元运算符 + 自动拆箱 + 自动装箱 + 多态性
     * 这个题有点意思，特别指后面新问题
     */
    @Test
    public void test1() {

        Object o1 = true ? new Integer(1) : new Double(2.0);
        // 三目运算符比较基本数据类型，所以在编译阶段自动拆箱为 int 和 double 类型，
        // 由于三目运算符要求 表达式2 和 表达式3 类型一致,以在编译阶段自动类型提升（即 int 自动类型转换为 double 类型），
        // 再自动装箱为Object，
        System.out.println(o1.getClass().getName());    //java.lang.Double
        System.out.println(o1);                         //1.0
        // 然后 由于这里满足多态的情况，调用重写的toString();即 Double包装类的toString();

        //上面题目简化 ↓
        double d1 = 2;
        Object o = d1;                              //既是多态，也是自动装箱
        System.out.println(o.getClass().getName()); //java.lang.Double
        System.out.println(o);                      //2.0

        /**
         * 这里引入新问题：
         *     小老弟lol:大佬请教个问题：
         *     Object o1 = true ? new Integer(1) : "asdasd";
         *     System.out.println(o1.getClass().getName());
         *     返回值是Integer，表达式2和3怎么保持一致的
         */

        Object o2 = true ? new Integer(1) : "asd";
        System.out.println(o2.getClass().getName());   //java.lang.Integer
        System.out.println(o2);                        //1

        Object o3 = false ? new Integer(1) : "asd";
        System.out.println(o3.getClass().getName());   //java.lang.String
        System.out.println(o3);                        //asd

        Object o4 = true ? 1.1f : "asd";
        System.out.println(o4.getClass().getName());   //java.lang.Float
        System.out.println(o4);                        //1.1

        Object o5 = false ? 1.1f : "123";
        System.out.println(o5.getClass().getName());   //java.lang.String
        System.out.println(o5);                        //123

        //那么我们根据测试结论可知：若基本数据类型与String作比较：
        //      将不会要求 表达式2 和 表达式3 类型一致（和 基本数据类型 在三元运算符中的要求不同）
    }

    /**
     * 这题主要是为了和上面题对应而已，没什么好看的
     */
    @Test
    public void test2() {
        Object o2;
        if (true)
            o2 = new Integer(1);
        else
            o2 = new Double(2.0);
        System.out.println(o2);     //1
    }
}
