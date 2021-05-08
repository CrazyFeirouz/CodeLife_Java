package test.oop.polymorphism.test1;

public class Woman extends Person{
    public int charm = 100;

    public void womanIntroduction(){
        System.out.println("我的魅力值是" + charm);
    }
    public void introduction(){
        System.out.println("我是女人");
    }
}
