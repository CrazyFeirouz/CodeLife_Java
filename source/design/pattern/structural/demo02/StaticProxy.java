package design.pattern.structural.demo02;

/**
 * @description:
 * @author: Feirouz
 * @date: 2023-06-04 19:06
 */

// 静态代理模式案例：你结婚和婚庆公司

/**
 * 静态代理模式总结：
 * 真实对象和代理对象都要实现同一个接口
 * 代理对象要代理真实角色
 */
public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

// 真实角色，你去结婚
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("小明要结婚了，超开心");
    }
}

// 代理角色，帮助你结婚
class WeddingCompany implements Marry{
    // 代理谁 ==> 真实目标角色
    private Marry target;

    public WeddingCompany(Marry target){
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void before(){
        System.out.println("结婚之前，布置现场");
    }

    private void after(){
        System.out.println("结婚之后，收尾款");
    }
}