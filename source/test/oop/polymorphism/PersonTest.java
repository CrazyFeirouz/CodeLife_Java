package test.oop.polymorphism;

public class PersonTest {
    public static void main(String[] args) {
        System.out.println("=========多态的简单使用==========");
        Person p1 = new Person();
        p1.introduction();
        //多态使用的前提：①类的继承关系 ②方法的重写
        //对象的多态性：父类的引用指向子类对象
        Person p2 = new Man();
        //多态的使用:当调用父类同名同参方法时，实际调用的是子类重写父类的方法 --- 虚拟方法调用 -- 编译看左边，运行看右边
        p2.introduction();
//        p2.manIntroduction(); //子类特有方法无法调用

        /**
         * =========多态的简单使用==========
         * 我是普通人
         * 我是男人
         */

        System.out.println("=============多态的特点==============");
        pIntroduction(new Person());
        pAge(new Person());
        System.out.println("***************************");
        pIntroduction(new Man());
        pAge(new Man());
        System.out.println("***************************");
        pIntroduction(new Woman());
        pAge(new Woman());

        /**
         * =============多态的特点==============
         * 我是普通人
         * 我的年龄是10
         * ***************************
         * 我是男人
         * 我的年龄是10
         * ***************************
         * 我是女人
         * 我的年龄是10
         */
    }

    /**
     * 多态性的体现
     * @param p 传入Person类，子类Man和Woman也可。
     */
    public static void pIntroduction(Person p){
        p.introduction();
    }
    public static void pAge(Person p){
        System.out.println("我的年龄是" + p.age);
    }

    // 若无多态性：如下，我们想实现具有通用性的接口就麻烦了，只能分开两个类来分开调用
//    public static void pIntroduction(Man p){
//        p.introduction();
//    }
//    public static void pIntroduction(Woman p){
//        p.introduction();
//    }
}

class Person {
    int age = 10;

    void introduction(){
        System.out.println("我是普通人");
    }
}

class Man extends Person{
    int age = 25;
    int power = 100;

    void manIntroduction(){
        System.out.println("我的力量值是" + power);
    }

    void introduction(){
        System.out.println("我是男人");
    }
}

class Woman extends Person{
    int age = 18;
    int charm = 100;

    void womanIntroduction(){
        System.out.println("我的魅力值是" + charm);
    }
    void introduction(){
        System.out.println("我是女人");
    }
}
