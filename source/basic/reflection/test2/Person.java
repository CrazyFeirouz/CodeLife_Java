package basic.reflection.test2;

/**
 * @description: 测试的类
 * @author: Feirouz
 * @date: 2022-03-12 1:36
 */
public class Person {
    public String name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
