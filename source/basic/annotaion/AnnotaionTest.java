package basic.annotaion;

import java.lang.annotation.*;

/**
 * @description: 自定义注解
 * @author: Feirouz
 * @date: 2022-03-09 15:48
 */

@MyAnnotation(schools = {"小学","中学"})
public class AnnotaionTest {

    // 注解可以显式赋值，如果没有默认值，则必须给注解参数赋值
    @MyAnnotation(name = "ccc", schools = {"小学","中学"})
    public void test() {

    }
}

// 这里去掉了public，因为每个编译单元(文件)都只能有一个public类
// 表示我们的注解可以用到什么地方
@Target(value = {ElementType.METHOD,ElementType.TYPE})
// 表示我们的注解在什么地方还有小
@Retention(value = RetentionPolicy.RUNTIME)
// 表示是否将我们的注解生成在JavaDOC中
@Documented
// 子类可以继承父类的注解
@Inherited
@interface MyAnnotation {
    // 注解的参数：参数类型+参数名()
    String name() default "abc";
    int age() default 0;
    int id() default -1;    // 如果默认值为-1，代表找不到

    String[] schools();
}
