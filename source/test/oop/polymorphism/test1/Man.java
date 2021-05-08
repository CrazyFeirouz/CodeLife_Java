package test.oop.polymorphism.test1;

public class Man extends Person{
    public int power = 100;

    public void manIntroduction(){
        System.out.println("我的力量值是" + power);
    }

    public void introduction(){
        System.out.println("我是男人");
    }
}
