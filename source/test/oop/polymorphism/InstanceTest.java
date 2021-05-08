package test.oop.polymorphism;

/**
 *  前提类
 */
class Person2 {
    protected String name = "person";
    protected int age = 50;
    public String getInfo() {
        return "Name:" + name + "\nage:" + age;
    }
}
class Student extends Person2 {
    protected String school = "pku";
    public String getInfo() {
        return "Name:" + name + "\nage:" + age + "\nschool:" + school;
    }
}
class Graduate extends Student {
    public String major = "IT";
    public String getInfo() {
        return "Name:" + name + "\nage:" + age + "\nschool:" + school + "\nmajor" + major;
    }
}

/**
 * 测试 instanceof 所满足的情况
 * true的情况：a instanceof a类/a的直接父类或间接父类
 */
public class InstanceTest {
    public static void main(String[] args) {
        method(new Person2());
        /**
         * Name:person
         * age:50
         * person
         */
        System.out.println("-------------");
        method(new Student());
        /**
         * Name:person
         * age:50
         * school:pku
         * student
         * person
         */
        System.out.println("-------------");
        method(new Graduate());
        /**
         * Name:person
         * age:50
         * school:pku
         * majorIT
         * graduated student
         * student
         * person
         */

    }
    public static void method(Person2 person) {
        String info = person.getInfo();
        System.out.println(info);

        if (person instanceof Graduate){
            System.out.println("graduated student");
        }
        if (person instanceof Student){
            System.out.println("student");
        }
        if (person instanceof Person2) {
            System.out.println("person");
        }
    }
}

