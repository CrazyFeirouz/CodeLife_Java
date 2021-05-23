package design.pattern.behavioral;

/**
 * -*- coding: utf-8 -*-
 * @Author Feirouz
 * @Date 2021/5/23 17:51
 * @Des 模板方法 / 模板 模式 - 例子二
 * 模板方法 / 模板 设计模式：
 *      当功能内部一部分实现是确定的，一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类去实现。
 */

public class TemplateMethod2 {
    public static void main(String[] args) {

        // 5.创建子类对象 调用 父类模板
        new DrawMoney().process();
        System.out.println("========");
        new ManageMoney().process();

        /**
         * 执行结果：
         *      取号排队
         *      我要取款
         *      反馈评分
         *      ========
         *      取号排队
         *      我要理财
         *      反馈评分
         */
    }
}

/**
 * 模板方法 / 模板 模式 - 例子2 实现
 * 模板方法 / 模板 模式 注意点：
 *      G - ① 封装不变部分，扩展可变部分。
 *          ② 提取公共代码，便于维护。
 *          ③ 行为由父类控制，子类实现。
 *      B - ① 每一个不同的实现都需要一个子类来实现，导致类的个数增加，使得系统更加庞大。
 */

// 1. 创建一个抽象类
abstract class BankTemplateMethod {

    // 2. 模板方法，把基本操作组合到一起，设置为final，子类一般不能重写
    public final void process() {
        this.takeNumber();

        this.transact();    // 像个钩子，具体执行时，挂哪个子类，就执行哪个子类的实现代码

        this.evaluate();
    }

    public void takeNumber() {
        System.out.println("取号排队");
    }

    // 3. 不确定的部分
    public abstract void transact();    // 钩子方法/回调方法

    public void evaluate() {
        System.out.println("反馈评分");
    }
}

// 4.创建子类，继承父类，重写不确定方法
class DrawMoney extends BankTemplateMethod {

    @Override
    public void transact() {
        System.out.println("我要取款");
    }
}

// 4.创建子类，继承父类，重写不确定方法
class ManageMoney extends BankTemplateMethod {

    @Override
    public void transact() {
        System.out.println("我要理财");
    }
}