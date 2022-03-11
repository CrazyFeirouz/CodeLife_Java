package basic.reflection.test2;

/**
 * @description: 获得Class类的几种方式
 * @author: Feirouz
 * @date: 2022-03-12 1:35
 */
public class ReflectionTest2Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student("小明");
        System.out.println("这个人是 ：" + person.name);

        // 方式一： 通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1);         // class basic.reflection.test2.Student

        // 方式二： forName获得
        Class c2 = Class.forName("basic.reflection.test2.Student");
        System.out.println(c2);         // class basic.reflection.test2.Student

        // 方式三： 通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3);         // class basic.reflection.test2.Student

        // 方式四： 基本内置类型的包装类都会有一个Type属性
        Class c4 = Integer.TYPE;
        System.out.println(c4);         // int

        System.out.println(c1 == c2);   // true
        System.out.println(c2 == c3);   // true
        System.out.println(c1 == c3);   // true

    }
}
