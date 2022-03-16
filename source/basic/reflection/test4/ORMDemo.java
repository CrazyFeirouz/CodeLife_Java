package basic.reflection.test4;

import java.io.FileOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @description: 练习反射操作注解
 * @author: Feirouz
 * @date: 2022-03-16 23:51
 */
public class ORMDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("basic.reflection.test4.Student");

        // 通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // 获取注解的value值
        TableFei tableFei = (TableFei)c1.getAnnotation(TableFei.class);
        System.out.println(tableFei.value());

        // 获得指定属性的注解
        Field f = c1.getDeclaredField("name");
        FieldFei fieldFei = (FieldFei)f.getAnnotation(FieldFei.class);
        System.out.println(fieldFei.columnName());
        System.out.println(fieldFei.type());
        System.out.println(fieldFei.length());
    }
}
