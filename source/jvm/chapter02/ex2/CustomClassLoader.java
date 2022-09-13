package jvm.chapter02.ex2;

import java.io.FileNotFoundException;

/**
 * @description:
 * @author: Feirouz
 * @date: 2022/9/13 17:44
 */
public class CustomClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = getClassFromCustomPath(name);
            if (result == null) {
                throw new FileNotFoundException(name);
            }else {
                return defineClass(name, result, 0, result.length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private byte[] getClassFromCustomPath(String name) {
        // 从自定义路径中加载指定类: 细节略
        // 如果指定路径字节码文件进行了加密,则需要在次方法中进行解密操作
        return null;
    }
}
