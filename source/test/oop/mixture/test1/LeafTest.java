package test.oop.mixture.test1;

/**
 * 题目1
 * 当静态代码块、代码块、构造器、继承等元素混起来时
 * 请判断以下代码执行顺序
 */

class Root{
    static {
        System.out.println("Root的静态初始化块");
    }
    {
        System.out.println("Root的初始化块");
    }
    public Root(){
        System.out.println("Root的无参构造器");
    }
}

class Mid extends Root{
    static {
        System.out.println("Mid的静态初始化块");
    }
    {
        System.out.println("Mid的初始化块");
    }
    public Mid(){
        //super();
        System.out.println("Mid的无参构造器");
    }
    public Mid(String msg){
        //通过this调用同一类中重载的构造器
        this();
        System.out.println("Mid的带参构造器，其参数值为：" + msg);
    }
}

class Leaf extends Mid{
    static {
        System.out.println("Leaf的静态初始化块");
    }
    {
        System.out.println("Leaf的初始化块");
    }
    public Leaf(){
        //通过super调用父类中有一个字符串参数的构造器
        super("Feirouz");
        System.out.println("Leaf的无参构造器");
    }
}
public class LeafTest {
    public static void main(String[] args) {
        new Leaf();
        System.out.println("===================");
        new Leaf();
    }
}
/**
 * 总结：
 *      ① 由父及子，静态先行
 *      ② new √ 非代码块 -> 构造方法
 * 运行结果：
 *      Root的静态初始化块
 *      Mid的静态初始化块
 *      Leaf的静态初始化块
 *      Root的初始化块
 *      Root的无参构造器
 *      Mid的初始化块
 *      Mid的无参构造器
 *      Mid的带参构造器，其参数值为：Feirouz
 *      Leaf的初始化块
 *      Leaf的无参构造器
 *      ===================
 *      Root的初始化块
 *      Root的无参构造器
 *      Mid的初始化块
 *      Mid的无参构造器
 *      Mid的带参构造器，其参数值为：Feirouz
 *      Leaf的初始化块
 *      Leaf的无参构造器
 */
