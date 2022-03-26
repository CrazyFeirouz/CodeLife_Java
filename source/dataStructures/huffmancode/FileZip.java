package dataStructures.huffmancode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @description: 使用赫夫曼编码对文件压缩
 * @author: Feirouz
 * @date: 2022/3/26 14:46
 */
public class FileZip {
    public static void main(String[] args) {
        // 测试压缩文件
        String srcFile = "source/dataStructures/huffmancode/files/fei.bmp";
        String dstFile = "source/dataStructures/huffmancode/files/fei.zip";
        zipFile(srcFile, dstFile);
        System.out.println("===压缩完成===");

    }

    /**
     * 编写方法, 将一个文件进行压缩
     * @param srcFile 需要压缩的文件路径
     * @param dstFile 压缩后存储的文件路径
     */
    public static void zipFile(String srcFile, String dstFile) {
        // 压缩类
        HuffmanCode huffmanCode = new HuffmanCode();

        // 创建输出流
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        // 创建输入流
        FileInputStream fis = null;

        try {
            // 创建文件的输入流
            fis = new FileInputStream(srcFile);
            // 创建一个和源文件大小一样的byte[]
            byte[] bytes = new byte[fis.available()];
            // 读取文件
            fis.read(bytes);
            // 直接对源文件进行压缩
            byte[] huffmanBytes = HuffmanCode.huffmanZip(bytes);
            // 创建文件的输出流, 存放压缩文件
            fos = new FileOutputStream(dstFile);
            // 创建一个和文件输出相关联的oos
            oos = new ObjectOutputStream(fos);
            // 把赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            // 注意我们以 对象六的方式写入 赫夫曼编码, 是为了以后我们恢复源文件
            // 注意一定要把赫夫曼编码写入压缩文件
            oos.writeObject(HuffmanCode.getHuffmanCodes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
