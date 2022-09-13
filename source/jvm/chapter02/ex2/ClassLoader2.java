package jvm.chapter02.ex2;

import sun.misc.Launcher;
import sun.security.ec.ECOperations;

import java.net.URL;
import java.security.Provider;

/**
 * @description:
 * @author: Feirouz
 * @date: 2022/9/6 22:31
 */
public class ClassLoader2 {
    public static void main(String[] args) {
        System.out.println("***********启动类加载器**************");
        // 获取BootstrapClassLoader能够加载的api路径
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL element : urLs) {
            System.out.println(element.toExternalForm());
        }
        // 从上面的路径随意选择一个类, 来看看他的类加载器是什么
        ClassLoader classLoader = Provider.class.getClassLoader();  // Provider类是用引导类加载器加载的
        System.out.println(classLoader);    // null


        System.out.println("***********扩展类加载器**************");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }
        // 从上面的路径随意选择一个类, 来看看他的类加载器是什么
        ClassLoader classLoader2 = ECOperations.class.getClassLoader();  // 老师演示的CurveDB已加入引导类加载器那边, ECOperations类是用扩展类加载器加载的
        System.out.println(classLoader2);   // sun.misc.Launcher$ExtClassLoader@38af3868
    }
}
