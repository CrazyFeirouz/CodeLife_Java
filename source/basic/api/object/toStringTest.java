package basic.api.object;

/**
 * Object类中toString()的使用：
 * 1. 当我们输出一个对象的引用时，实际上就是调用当前对象的toString()
 * 2. Object类中的toString()的定义：
 *        public String toString() {
 *            return getClass().getName() + "@" + Integer.toHexString(hashCode());
 *        }
 * 3. 像String、Date、File、包装类等都重写了Object类中的toString()方法。
 *    使得在调用对象的toString()时，返回 “实体内容” 信息
 * 4. 自定义类也可以重写toString()方法，当调用此方法时，返回对象的 “实体内容”
 */

public class toStringTest {
    public static void main(String[] args) {
        Custromer custromer = new Custromer("Tom",18);
        System.out.println(custromer);              //test.object.Custromer@1b6d3586
        System.out.println(custromer.toString());   //test.object.Custromer@1b6d3586

        String hello = new String("hello");
        System.out.println(hello);
    }
}

class Custromer{
    String name;
    int age;
    Custromer(){}
    Custromer(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
