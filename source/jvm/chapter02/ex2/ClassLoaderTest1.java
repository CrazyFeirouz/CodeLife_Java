package jvm.chapter02.ex2;

/**
 * @description:
 * @author: Feirouz
 * @date: 2022/9/13 18:07
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {
        try {
            // 1. 获取当前类的ClassLoader
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);    //null
            // 2. 获取当前线程上下文的ClassLoader
            ClassLoader ClassLoader1 = Thread.currentThread().getContextClassLoader();
            System.out.println(ClassLoader1);   // sun.misc.Launcher$AppClassLoader@18b4aac2 - 系统类加载器
            // 3. 获取系统的ClassLoader
            ClassLoader classLoader2 = ClassLoader.getSystemClassLoader().getParent();
            System.out.println(classLoader2);   // sun.misc.Launcher$ExtClassLoader@1b6d3586 - 扩展类加载器
            // 4. 获取调用者的ClassLoader
            // 略
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
