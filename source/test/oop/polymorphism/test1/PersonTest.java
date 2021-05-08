package test.oop.polymorphism.test1;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.introduction();
        //多态使用的前提：①类的继承关系 ②方法的重写
        //对象的多态性：父类的引用指向子类对象
        Person p2 = new Man();
        //多态的使用:当调用父类同名同参方法时，实际调用的是子类重写父类的方法 --- 虚拟方法调用 -- 编译看左边，运行看右边
        p2.introduction();
//        p2.manIntroduction(); //子类特有方法无法调用

        System.out.println("===========================");
        pIntroduction(new Person());
        System.out.println("***************************");
        pIntroduction(new Man());
        System.out.println("***************************");
        pIntroduction(new Woman());
    }

    public static void pIntroduction(Person p){
        p.introduction();
    }
}

class Person {
    public int age;

    public void introduction(){
        System.out.println("我是普通人");
    }
}

class Man extends Person{
    public int power = 100;

    public void manIntroduction(){
        System.out.println("我的力量值是" + power);
    }

    public void introduction(){
        System.out.println("我是男人");
    }
}

class Woman extends Person{
    public int charm = 100;

    public void womanIntroduction(){
        System.out.println("我的魅力值是" + charm);
    }
    public void introduction(){
        System.out.println("我是女人");
    }
}
