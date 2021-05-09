package test.api.wrapper;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;
import test.api.object.InterviewTest1;

public class WrapperTest {

    /**
     * String类型 --> 基本数据类型、包装类：调用包装类的parseXxx()
     */
    @Test
    public void test5(){
        String str1 = "123";
        //错误的情况
//        int num1 = (int)str1;
//        Integer in1 = (Integer)str1;  //没有子父类关系就不能强转，编译都给你报错
        //可能会报NumberFormatException
        int num2 = Integer.parseInt(str1);
        System.out.println(num2 + 1);   //124

        String str2 = "true1";
        boolean b1 = Boolean.parseBoolean(str2);
        System.out.println(b1);         //false - 不为空，且不为true的通通都是false，而不会报错（和test1那块同理）
    }
    /**
     * 基本数据类型、包装类 --> String类型：调用String重载的valueOf(XXX xxx)
     */
    @Test
    public void test4(){
        int num1 = 10;
        //方式一：连接运算
        String str1 = num1 + "";
        //方式二：调用String的valueOf(XXX xxx)
        float f1 = 12.3f;
        Double d1 = new Double(12.4);
        String str2 = String.valueOf(f1);
        String str3 = String.valueOf(d1);

        System.out.println(str2);   //12.3
        System.out.println(str3);   //12.4

    }

    /**
     * JDK 5.0 新特性 : 自动装箱和自动拆箱
     */
    @Test
    public void test3(){
        int num1 = 10;
        // 基本数据类型 --> 包装类的对象
        method(num1);   //这里就算做一种自动装箱

        // 自动装箱： 基本数据类型 --> 包装类
        int num2 = 10;
        Integer in1 = num2; //自动装箱

        boolean b1 = true;
        Boolean b2 = b1;    //自动装箱

        // 自动拆箱： 包装类 --> 基本数据类型
        int num3 = in1; //自动拆箱
    }
    public void method(Object object) {}

    /**
     * 包装类 --> 基本数据类型：调用包装类的 XXX.xxxValue()
     * 拆箱
     */
    @Test
    public void test2(){
        Integer i1 = new Integer(12);
        int i2 = i1.intValue();
        System.out.println(i2 + 1);         //13

        Float f1 = new Float(12.3);
        float f2 = f1.floatValue();
        System.out.println(f2 + 1);         //13.3
    }

    /**
     * 基本数据类型 --> 包装类：调用包装类的构造器
     * 装箱
     */
    @Test
    public void test1(){
        int num1 = 10;
        Integer integer1 = new Integer(num1);
        System.out.println(integer1.toString());//10

        Integer integer2 = new Integer("123");
        System.out.println(integer2);           //123

        //报异常
        //java.lang.NumberFormatException: For input string: "123abc"
//        Integer integer3 = new Integer("123abc");
//        System.out.println(integer3);

        Float f1 = new Float(12.3f);
        Float f2 = new Float("12.3");
        System.out.println(f1);                 //12.3
        System.out.println(f2);                 //12.3

        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("TrUe");
        System.out.println(b2);                 //true
        Boolean b3 = new Boolean("true123");
        /**
         * 这块源码是这样的，所以不为空，且不为true的通通都是false，而不会报错
         * public static boolean parseBoolean(String s) {
         *     return ((s != null) && s.equalsIgnoreCase("true"));
         * }
         */
        System.out.println(b3);                 //false

        Order order = new Order();
        System.out.println(order.isMale);       //false
        System.out.println(order.isFemale);     //null
    }
}

class Order{
    boolean isMale;
    Boolean isFemale;
}