package basic.oop.polymorphism;

/**
 * 多态中特别的注意事项
 */

// 前提类
class Base2 {
    public void add(int a, int... arr) {    // int[] arr 可看作 int... arr ，这里可看作重写
        System.out.println("base2");
    }
}
class Sub2 extends Base2 {
    public void add(int a, int[] arr) {     // int[] arr 可看作 int... arr ，这里可看作重写
        System.out.println("sub2_1");
    }
    public void add(int a, int b, int c) {
        System.out.println("sub2_2");
    }
}

public class InterviewTest1 {
    public static void main(String[] args) {
        Base2 base = new Sub2();
        //这里由于多态性，那么必定看左边父类存在的方法先，运行时再执行子类重写父类的方法。
        base.add(1, 2, 3);  //sub2_1


        Sub2 s = (Sub2)base;
        //这里由于直接调用子类方法，那么确定的方法优先调用
        s.add(1,2,3);   //sub2_2
    }
}
