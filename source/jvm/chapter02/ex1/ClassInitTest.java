package jvm.chapter02.ex1;

/**
 * @description:
 * @author: Feirouz
 * @date: 2022/9/5 18:16
 */
public class ClassInitTest {
    private static int num = 1;

    static {
        num = 2;
        number = 20;
        System.out.println(num);
//        System.out.println(number); // 报错,非法的前向引用
    }

    private static int number = 10; // linking之prepare：number = 0 --> initial: 20 --> 10

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);      // 2
        System.out.println(ClassInitTest.number);   // 10
    }
}


/**
 * .class文件
 * public class ClassInitTest {
 *     private static int num = 1;
 *     private static int number;
 *
 *     public ClassInitTest() {
 *     }
 *
 *     public static void main(String[] args) {
 *         System.out.println(num);
 *         System.out.println(number);
 *     }
 *
 *     static {
 *         num = 2;
 *         number = 20;
 *         System.out.println(num);
 *         number = 10;
 *     }
 * }
 */

/**
 * <clinit>方法 - 类的加载过程中的第三阶段 - 初始化
 *  0 iconst_1
 *  1 putstatic #3 <jvm/chapter02/ex1/ClassInitTest.num>
 *  4 iconst_2
 *  5 putstatic #3 <jvm/chapter02/ex1/ClassInitTest.num>
 *  8 bipush 20
 * 10 putstatic #5 <jvm/chapter02/ex1/ClassInitTest.number>
 * 13 getstatic #2 <java/lang/System.out>
 * 16 getstatic #3 <jvm/chapter02/ex1/ClassInitTest.num>
 * 19 invokevirtual #4 <java/io/PrintStream.println>
 * 22 bipush 10
 * 24 putstatic #5 <jvm/chapter02/ex1/ClassInitTest.number>
 * 27 return
 */