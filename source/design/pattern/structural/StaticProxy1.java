package design.pattern.structural;

/**
 * -*- coding: utf-8 -*-
 * @Author Feirouz
 * @Date 2021/5/26 16:41
 * @Des 代理 模式 - 例子一
 * 代理 设计模式：
 *      为其他对象提供一种代理以控制对这个对象的访问。
 */

public class StaticProxy1 {
    public static void main(String[] args) {
        // 4. 创建 被代理类对象
        Server server = new Server();
        // 5. 创建 代理类对象
        ProxyServer proxyServer = new ProxyServer(server);
        // 6. 代理类对象 调用 代理方法
        proxyServer.browse();

        /**
         * 运行结果：
         *      联网之前的检查工作
         *      真实的服务器访问网络
         */
    }
}

/**
 * 代理 模式 - 例子1 实现
 * 代理 模式 注意点：
 *      G - ① 职责清晰
 *          ② 高扩展性
 *          ③ 智能化
 *      B - ① 由于在客户端和真实主题之间增加了代理对象，因此有些类型的代理模式可能会造成请求的处理速度变慢。
 *          ② 实现代理模式需要额外的工作，有些代理模式的实现非常复杂。
 */

// 1. 首先一个接口
interface NetWork{
    public void browse();
}

// 2. 被代理类 实现接口
class Server implements NetWork{

    @Override
    public void browse() {
        System.out.println("真实的服务器访问网络");
    }
}

// 3. 代理类 实现接口
class ProxyServer implements NetWork{

    // 3.1 私有化接口对象
    private NetWork server;

    public ProxyServer(NetWork server){
        this.server = server;
    }

    public void check(){
        System.out.println("联网之前的检查工作");
    }

    @Override
    public void browse() {
        check();

        // 3.2 调用传入的对象（被代理类对象）的browse方法（体现多态性）
        server.browse();
    }
}

