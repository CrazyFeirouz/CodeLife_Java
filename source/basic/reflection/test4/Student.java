package basic.reflection.test4;

/**
 * @description: 练习反射操作注解
 * @author: Feirouz
 * @date: 2022-03-16 23:43
 */

@TableFei("db_student")
public class Student {
    @FieldFei(columnName = "db_id", type = "int", length = 10)
    private int id;
    @FieldFei(columnName = "db_age", type = "int", length = 10)
    private int age;
    @FieldFei(columnName = "db_name", type = "varchar", length = 10)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
