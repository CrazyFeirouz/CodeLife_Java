package basic.throwable.exception;

import org.junit.Test;

import java.util.Date;
import java.util.Scanner;

/**
 * 常见的运行时异常 有什么？
 */

public class Test1 {

    // ArithmeticException
    @Test
    public void test6 () {
        int a = 10;
        int b = 0;
//        System.out.println(a / b);  // ArithmeticException: / by zero
    }

    //InputMismatchException
    @Test
    public void test5() {
        Scanner scanner = new Scanner("abc");
//        int score = scanner.nextInt();  // InputMismatchException
        scanner.close();
    }

    // NumberFormatException
    @Test
    public void test4() {
        String str = "abc";
//        int num = Integer.parseInt(str);    // NumberFormatException: For input string: "abc"
    }

    // ClassCastException
    @Test
    public void test3() {
        Object obj = new Date();
//        String str = (String) obj;  // ClassCastException: java.util.Date cannot be cast to java.lang.String
    }

    // IndexOutOfBoundException
    @Test
    public void test2() {
        // ArrayIndexOutOfBoundsException
        int[] arr = new int[3];
//        System.out.println(arr[3]); // ArrayIndexOutOfBoundsException: 3

        // StringIndexOutOfBoundsException
        String str = new String("abc");
//        System.out.println(str.charAt(3));  // StringIndexOutOfBoundsException: String index out of range: 3
    }

    // NullPointerException
    @Test
    public void test1() {
        int[] arr = null;
//        System.out.println(arr[3]); // NullPointerException

        String s = null;
//        System.out.println(s.charAt(0)); // NullPointerException
    }
}
