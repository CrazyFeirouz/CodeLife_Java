package jvm.chapter02.ex1;

/**
 * @description:
 * @author: Feirouz
 * @date: 2022/9/5 18:16
 */
public class ClinitTest1 {
    static class Father{
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Son extends Father{
        public static int B = A;
    }

    public static void main(String[] args) {
        // 加载Father类, 其次在加载Son类
        System.out.println(Son.B); // 2
    }
}
