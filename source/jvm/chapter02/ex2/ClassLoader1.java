package jvm.chapter02.ex2;

/**
 * @description: 各个加载器
 * @author: Feirouz
 * @date: 2022/9/6 17:36
 */
public class ClassLoader1 {
    public static void main(String[] args) {
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);  // sun.misc.Launcher$AppClassLoader@18b4aac2

        // 获取其上层: 扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);     // sun.misc.Launcher$ExtClassLoader@1b6d3586

        // 获取其上层
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);   // null

        // 对于用户自定义类来说 - 默认使用系统类加载器加载
        ClassLoader classLoader = ClassLoader1.class.getClassLoader();
        System.out.println(classLoader);        // sun.misc.Launcher$AppClassLoader@18b4aac2

        // String 类使用引导类加载器进行加载的 --> Java的核心类库都是使用引导类加载器进行加载的
        ClassLoader stringClassLoader = String.class.getClassLoader();
        System.out.println(stringClassLoader);  // null
    }
}
