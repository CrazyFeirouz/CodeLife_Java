package test.api.wrapper;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;
import test.api.object.InterviewTest1;

public class WrapperTest {

    /**
     * 基本数据类型 --> 包装类：调用包装类的构造器
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