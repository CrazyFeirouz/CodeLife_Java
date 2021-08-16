package basic.oop.interfaces;

/**
 * Java 8 -> 接口改进：
 *      可以定义静态方法、默认方法
 * 注意点：
 *      关于 接口多实现 和 父类继承 混合时 所需要注意的事项
 */
public class StudyTest1 {
    public static void main(String[] args) {
        SubClass s = new SubClass();

        // 知识点1 ： 接口中定义的静态方法，只能通过接口来调用
//        s.method1();          // ×
//        SubClass.method1();   // ×
        CompareA.method1();     // √       CompareA : 静态方法

        System.out.println("===============================");

        // 知识点2 ：
        //   通过实现类的对象，可以调用接口中的默认方法
        //   如果实现类重写了接口中的默认方法，调用时，仍是调用重写以后的方法
        s.method2();    //SubClass : 实现类重写默认方法
        s.method3();    //CompareA : 缺省默认

        System.out.println("===============================");

        // 知识点3 :
        //   如果子类（或实现类）继承的父类和实现的接口中声明了同名同参的默认方法，
        //   那么子类在没有重写此类方法的情况下，默认调用的是父类中的同名同参数的方法
        // 类优先原则
        s.method4();    //SuperClass : method4

        System.out.println("===============================");

        // 知识点4 ：
        //    如果实现类实现了多个接口（无 继承 含同名方法的父类 情况），
        //    而这多个接口中定义了同名同参数的默认方法，那么在实现类没有重写此方法的情况下，
        //    报错。--> 接口冲突
        // 解决方式：
        //    在实现类中重写此方法
        s.method5();

    }
}

// 接口 1
interface CompareA {
    // 静态方法
    public static void method1() {
        System.out.println("CompareA : 静态方法");
    }
    // 默认方法
    public default void method2() {
        System.out.println("CompareA : 公开默认");
    }
    default void method3() {
        System.out.println("CompareA : 缺省默认");
    }
    default void method4() {
        System.out.println("CompareA : method4");
    }
    default void method5() {
        System.out.println("CompareA : method5");
    }
}

interface CompareB {
    default void method5() {
        System.out.println("CompareA : method5");
    }
}

// 父类
class SuperClass {
    public void method4() {
        System.out.println("SuperClass : method4");
    }
    public void method5() {
        System.out.println("SuperClass : method5");
    }
}

// 实现类
class SubClass extends SuperClass implements CompareA, CompareB {

    @Override
    public void method2() {
        System.out.println("SubClass : 实现类重写默认方法");
    }

    @Override
    public void method5() {
        System.out.println("SubClass : method5");
    }

    // 知识点5 ：如何在子类（或实现类）的方法中调用父类、接口中被重写的方法
    public void myMethod() {
        // 调用自己自定义的重写方法
        method5();
        this.method5();

        // 调用的是父类中声明的
        super.method5();

        // 调用接口中的默认方法
        CompareA.super.method5();
        CompareB.super.method5();
    }


}

