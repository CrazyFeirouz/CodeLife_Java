package design.pattern.creational;

/**
 * -*- coding: utf-8 -*-
 * @Author Feirouz
 * @Date 2021/5/20 17:00
 * @Des 单例模式 - 懒汉式
 * 单例设计模式：
 *      采取一定的方法保证整个的软件系统中，对于某个类 只能存在一个对象实例
 */

public class Singleton2 {
    public static void main(String[] args) {
        Order order1 = Order.getInstace();
        Order order2 = Order.getInstace();
        System.out.println(order1 == order2);   //true
    }
}

/**
 * 单例模式 - 懒汉式实现
 * 懒汉式注意点：
 *      G - ① 会延迟对象的创建时间
 *      B - ② 目前的写法会导致线程不安全 ---> 后续使用多线程修改 -- 已修改_2021.06.09
 */

class Order {
    // 1.私有化类的构造器
    private Order() {}

    // 2.声明当前类的对象，没有初始化
    // 4.由于静态方法调用，则此对象也必须声明为静态的
    private static Order instance = null;

    // 3.提供公共的静态方法，返回类的对象
//    public static synchronized Order getInstance() {  //方式二：同步方法，隐藏的同步监视器：Order.class，效果和下面（↓）的一致，略低
    public static Order getInstace(){
        // 方式一：同步代码块 - 解决方式一 ： 这样效率会略低，因为后续如果早就创建好了，每次还是要执行这个同步代码块，上面（↑）的同步方法也是
//        synchronized (Order.class) {
//            if (instance == null){
//                instance = new Order();
//            }
//            return instance;
//        }
        // 方式一：同步代码块 - 解决方式二 ：对比上面的方法，效率会有所提高。
        if (instance == null) {
            synchronized (Order.class) {
                if (instance == null) {
                    instance = new Order();
                }
            }
        }
        return instance;

    }

}