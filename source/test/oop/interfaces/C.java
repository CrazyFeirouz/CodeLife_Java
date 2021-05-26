package test.oop.interfaces;

/**
 * 接口题目1
 * 请判断以下代码是否正确
 */

interface A {
    int x = 0;
}

class B {
    int x = 1;
}

public class C extends B implements A{
    public void pX() {
        // 请判断以下代码是否正确
//        System.out.println(x);
//        System.out.println(C.x);

        /*
         * 错误！
         * 编译失败：Reference to 'x' is ambiguous, both 'B.x' and 'A.x' match
         */

        // 正确方式：
        // 调用父类的x
        System.out.println(super.x);        // 1
        // 调用接口的x
        System.out.println(A.x);    // 0 。 接口中定义的属性默认为static final的常量，所以可以 接口.属性 调用

    }

    public static void main(String[] args) {
        new C().pX();
    }
}

