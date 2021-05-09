package test.api.object;

import java.util.Date;

/**
 *  == 和 equals() 的区别
 */
public class InterviewTest1 {
    public static void main(String[] args) {
        // ==
        equal1();
        // equals()
//        equal2();
    }

    /**
     * == ： 运算符
     * 1. 可以使用在基本数据类型变量和引用数据类型变量中
     * 2. 如果比较的是基本数据类型变量：比较两个变量保存的数据是否相等。（不一定要类型相同）
     *    如果比较的是引用数据类型变量：比较两个对象的地址值是否相同，即两个引用是否指向同一个对象实体。
     * 补充：必须保证左右两边变量类型一致
     */
    public static void equal1(){
        // 基本数据类型：
        int i = 10;
        int j = 10;
        double d = 10.0;
        System.out.println(i == j);     //true
        System.out.println(i == d);     //true

        boolean b = true;
//        System.out.println(i == b);   //编译错误，基本数据类型中，其余类型不带布尔类型一起玩的
//        System.out.println(b == a);     //true，可以编译，也可运行，但是idea这边喜欢爆红警告“Value 'b' is always 'true' ”，我就暂时注释了
        boolean a = true;

        char c = 10;
        System.out.println(i == c);     //true

        char c1 = 'A';
        char c2 = 65;
        System.out.println(c1 == c2);   //true

        // 引用数据类型
        Guy guy1 = new Guy(18);
        Guy guy2 = new Guy(18);
        System.out.println(guy1 == guy2);   //false

        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1 == s2);       //false
    }

    /**
     * equals() : 方法
     * 1. 是一个方法，而非运算符
     * 2. 只能适用于引用数据类型
     * 3. Object类中equals()的定义：
     *        public boolean equals(Object obj) {
     *          return (this == obj);
     *        }
     *        说明：Object类中定义的equals()和==的作用是相同的。
     * 4. 像String、Date、File、包装类等都重写了Object类中的equals()方法。
     *        重写以后，比较的不是两个引用的地址是否相同，二十比较两个对象的 “实体内容” 是否相同。
     * 5. 通常情况下，我们自定义的类如果使用equals()的话，也通常时比较两个对象的“实体内容”是否相同
     *        那么我们就需要对Object类中的equals()进行重写
     *        重写的原则：比较两个对象的实体内容是否相同
     */
    public static void equal2() {
        // 引用数据类型
        Guy guy1 = new Guy(20);
        Guy guy2 = new Guy(20);
        System.out.println(guy1.equals(guy2));   //false

        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1.equals(s2));       //true

        Date date1 = new Date(32432525324L);
        Date date2 = new Date(32432525324L);
        System.out.println(date1.equals(date2));    //true
    }
}

class Guy {
    int age;
    Guy() {}
    Guy(int age) {
        this.age = age;
    }
}
