package design.pattern.structural;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * -*- coding: utf-8 -*-
 * @Author Feirouz
 * @Date 2021/8/6 20:18
 * @Des 动态代理 模式 - 例子一
 *
 * 要想实现动态代理，需要解决的问题？
 *  问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 *  问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a？
 */

public class DymanicProxy1 {
    public static void main(String[] args) {
        // 被代理类的对象
        SuperMan superMan = new SuperMan();
        // 代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        // 调用代理类对象的方法 -> 内部调用被代理类方法
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("云吞");
    }
}

// 接口
interface Human{
    String getBelief();
    void eat(String food);
}

// 被代理类
class SuperMan implements Human{
    @Override
    public String getBelief() {
        return "I belief I can fly.";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

// 动态代理类
class ProxyFactory{
    // 调用此方法，返回一个代理类的对象。 - 解决问题1
    public static Object getProxyInstance(Object obj){  // obj：被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        Object proxy = java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), handler);

        return proxy;
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object obj; // obj：被代理对象

    public void bind(Object obj){
        this.obj = obj; // 需要使用被代理类的对象进行赋值
    }

    // 当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke() - 解决问题2
    // 将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // proxy： 1.可以使用反射获取代理对象的信息。
        //         2.可以将代理对象返回以进行连续调用。
        // method：即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        // args：方法参数
        Object returnValue = method.invoke(obj, args);
        // 上述方法的返回值就作为当前类中的invoke()的返回值
        return returnValue;
    }
}