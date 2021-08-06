package design.pattern.structural;

/**
 * -*- coding: utf-8 -*-
 * @Author Feirouz
 * @Date 2021/5/26 17:12
 * @Des 代理 模式 - 例子二
 * 代理 设计模式：
 *      为其他对象提供一种代理以控制对这个对象的访问。
 */

public class StaticProxy2 {
    public static void main(String[] args) {
        // 4. 创建 被代理类对象
        RealStar realStar = new RealStar();
        // 5. 创建 代理类对象
        Proxy proxy = new Proxy(realStar);

        proxy.confer();
        proxy.signContract();
        proxy.bookTicket();
        proxy.collectMoney();

        // 6. 代理类对象 调用 代理方法
        proxy.sing();

        /**
         * 运行结果：
         *      经济人面谈
         *      经纪人签合同
         *      经纪人订票
         *      经纪人收钱
         *      明星唱歌~~~
         */
    }
}

/**
 * 代理 模式 - 例子2 实现
 * 代理 模式 注意点：
 *      G - ① 职责清晰
 *          ② 高扩展性
 *          ③ 智能化
 *      B - ① 由于在客户端和真实主题之间增加了代理对象，因此有些类型的代理模式可能会造成请求的处理速度变慢。
 *          ② 实现代理模式需要额外的工作，有些代理模式的实现非常复杂。
 */

// 1. 首先一个接口
interface Star {
    void confer();          // 面谈
    void signContract();    // 签合同
    void bookTicket();      // 订票
    void sing();            // 唱歌
    void collectMoney();    // 收钱
}

// 2. 被代理类 实现接口
class RealStar implements Star {

    @Override
    public void confer() { }

    @Override
    public void signContract() { }

    @Override
    public void bookTicket() { }

    @Override
    public void sing() {
        System.out.println("明星唱歌~~~");
    }

    @Override
    public void collectMoney() { }
}

// 3. 代理类 实现接口
class Proxy implements Star {

    // 3.1 私有化接口对象
    private Star realstar;

    public Proxy(Star realstar) {
        this.realstar = realstar;
    }
    @Override
    public void confer() {
        System.out.println("经济人面谈");
    }

    @Override
    public void signContract() {
        System.out.println("经纪人签合同");
    }

    @Override
    public void bookTicket() {
        System.out.println("经纪人订票");
    }

    @Override
    public void sing() {
        // 3.2 调用传入的对象（被代理类对象）的browse方法（体现多态性）
        realstar.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("经纪人收钱");
    }
}