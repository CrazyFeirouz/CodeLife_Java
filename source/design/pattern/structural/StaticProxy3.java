package design.pattern.structural;

import test.oop.interfaces.C;

import java.sql.SQLOutput;

/**
 * -*- coding: utf-8 -*-
 * @Author Feirouz
 * @Date 2021/8/6 19:41
 * @Des 静态代理 模式 - 例子三（准备动态代理之前的回顾）
 *
 * 静态代理特点：代理类和被代理类在编译期间，就确定下来了
 */

public class StaticProxy3 {
    public static void main(String[] args) {
        // 创建被代理类对象
        ClothFactory liNing = new LiNing();
        // 创建代理类对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(liNing);
        proxyClothFactory.produceCloth();
    }
}

interface ClothFactory{
    void produceCloth();
}

// 代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;   // 用呗代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备");
        factory.produceCloth();
        System.out.println("代理工厂做一些收尾工作");
    }
}

// 被代理类
class LiNing implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("原厂生产衣服");
    }
}