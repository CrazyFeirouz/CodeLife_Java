package basic.throwable;

/**
 * finally的执行顺序测试
 * 判断以下执行顺序
 */

public class ReturnExceptionDemo {
    static void methodA() {
        try {
            System.out.println("进入方法A");
            throw new RuntimeException("制造异常");
        } finally {
            System.out.println("用A方法的finally");
        }
    }

    static void methodB() {
        try {
            System.out.println("进入方法B");
        } finally {
            System.out.println("用B方法的finally");
        }
    }

    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        methodB();

        /*
            运行结果：
                进入方法A
                用A方法的finally
                制造异常
                进入方法B
                用B方法的finally
         */
    }
}
