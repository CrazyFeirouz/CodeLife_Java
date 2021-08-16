package basic.oop.mixture;

/**
 * 题目2
 * 当静态代码块、代码块、构造器、继承等元素混起来时
 * 请判断以下代码执行顺序
 */

class Father {
    static {
        System.out.println("111");
    }
    {
        System.out.println("222");
    }
    public Father(){
        System.out.println("333");
    }
}

class Son extends Father {
    static {
        System.out.println("444");
    }
    {
        System.out.println("555");
    }
    public Son(){
        System.out.println("666");
    }

    public static void main(String[] args) {
        System.out.println("********");
        System.out.println("777");
        System.out.println("********");
        new Son();
        System.out.println("********");
        new Son();
        System.out.println("********");
        new Father();
    }
}

/**
 *  总结：
 *      ① 由父及子，静态先行
 *      ② new √ 非代码块 -> 构造方法
 *  运行结果：
 *      111
 *      444
 *      ********
 *      777
 *      ********
 *      222
 *      333
 *      555
 *      666
 *      ********
 *      222
 *      333
 *      555
 *      666
 *      ********
 *      222
 *      333
 */