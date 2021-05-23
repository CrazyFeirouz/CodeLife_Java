package design.pattern.behavioral;

/**
 * -*- coding: utf-8 -*-
 * @Author Feirouz
 * @Date 2021/5/23 17:13
 * @Des 模板方法 / 模板 模式 - 例子一
 * 模板方法 / 模板 设计模式：
 *      当功能内部一部分实现是确定的，一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类去实现。
 */

public class TemplateMethod1 {
    public static void main(String[] args) {
        // 5.创建子类对象 调用 父类模板
        SubTemplate subTemplate = new SubTemplate();
        subTemplate.spendTime();
    }
}

/**
 * 模板方法 / 模板 模式 - 例子1 实现
 * 模板方法 / 模板 模式 注意点：
 *      G - ① 封装不变部分，扩展可变部分。
 *          ② 提取公共代码，便于维护。
 *          ③ 行为由父类控制，子类实现。
 *      B - ① 每一个不同的实现都需要一个子类来实现，导致类的个数增加，使得系统更加庞大。
 */

// 1.创建抽象类
abstract class Template{
    // 2. 确定的部分，模板方法被设置为final，子类一般不能重写
    //计算某段代码执行所需要花费的时间
    public final void spendTime(){
        long start = System.currentTimeMillis();

        code(); //不确定部分、易变部分

        long end = System.currentTimeMillis();
        System.out.println("花费时间为：" + (end - start));
    }

    // 3. 不确定的部分
    public abstract void code();
}

// 4.创建子类，继承父类，重写不确定方法
class SubTemplate extends Template{

    @Override
    public void code() {
        final int NUM = 1000;
        for (int i = 2; i <= NUM; i++){
            boolean isFlag = true;
            for (int j = 2; j <= Math.sqrt(i); j++){
                if (i % j == 0){
                    isFlag = false;
                    break;
                }
            }
            if (isFlag){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}