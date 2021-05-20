package design.pattern.creational;

/**
 * -*- coding: utf-8 -*-
 * @Author Feirouz
 * @Date 2021/5/20 16:39
 * @Des 单例模式 - 饿汉式
 * 单例设计模式：
 *      采取一定的方法保证整个的软件系统中，对于某个类 只能存在一个对象实例
 */

public class Singleton1 {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank1 == bank2); //true
    }
}

/**
 * 单例模式 - 饿汉式实现
 * 饿汉式注意点：
 *      G - ① 饿汉式是线程安全的
 *      B - ② 对象加载时间会被延长
 */

class Bank {

    // 1.私有化类的构造器
    private Bank() {}

    // 2.内部创建类的对象
    // 4.由于静态方法调用，则此对象也必须声明为静态的
    private static Bank instance = new Bank();

    // 3.提供公共的静态方法，返回类的对象
    public static Bank getInstance(){
        return instance;
    }
}
