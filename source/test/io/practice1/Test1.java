package test.io.practice1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description: I/O练习1
 * @author: Feirouz
 * @date: 2021-06-30 17:10
 *
 * 获取文本上每个字符出现的次数
 * 提示：遍历文本的每一个字符；字符及出现的次数保存在Map中；将Map中数据写入文件
 *
 * 涉及知识：
 *      1. 字节流 - 字符流
 *      2. 处理流 - 缓冲流
 *      3. Map
 *      4. Set
 *      5. 泛型
 *
 */
public class Test1 {
    public static void main(String[] args) {
        // 1. 创建文件和相应的流
        // 读的操作只需要读一个字符，所以只需要FileReader就能完成
        FileReader fileReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            fileReader = new FileReader("source/test/io/practice1/hello.txt");
            bufferedWriter = new BufferedWriter(new FileWriter("source/test/io/practice1/helloOut.txt"));

            HashMap<Character, Integer> map = new HashMap<>();

            // 2. 读取文本，同时记录每个字出现次数
            int c = 0;
            while ((c = fileReader.read()) != -1){
                System.out.print(c + "-");
                char ch = (char)c;      // char型范围2个字节，在0-65535内，按照unicode的编码范围，包含中文正常来讲是没有问题的
                System.out.println(ch);
                if (map.get(ch) == null){
                    map.put(ch, 1);
                }else {
                    map.put(ch, (map.get(ch) + 1));
                }
            }

            // 3. 格式化文本输出
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
            for (Map.Entry<Character, Integer> entry: entries) {
                switch (entry.getKey()) {
                    case ' ':
                        bufferedWriter.write("空格 = " + entry.getValue());
                        break;
                    case '\t':
                        bufferedWriter.write("tab = " + entry.getValue());
                        break;
                    case '\r':
                        bufferedWriter.write("回车 = " + entry.getValue());
                        break;
                    case '\n':
                        bufferedWriter.write("换行 = " + entry.getValue());
                        break;
                    default:
                        bufferedWriter.write(entry.getKey() + " = " + entry.getValue());
                        break;
                }
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        /*
         * 插个题外话：或许你想知道为什么占3-4个字节的中文字符能存进char里。
         *      中文3-4个字节，而char只占2字节，为啥还不会溢出？
         *      这里就要引入一个 “编码方式”
         *          以UTF-8编码方式举例：（指标准版，UTF-8修正版要6个字节了的都有）
         *      |            ( 二进制 )                     |   占用字节    |   实际数据占用位数(x) |
         *      |    0xxxxxxx (兼容原来的ASCII)              |    1字节     |       7位          |
         *      |    110xxxxx 10xxxxxx                     |    2字节     |       11位         |
         *      |    1110xxxx 10xxxxxx 10xxxxxx            |    3字节     |       16位         |
         *      |    11110xxx 10xxxxxx 10xxxxxx 10xxxxxx   |    4字节     |       21位         |
         *
         *      这里的0、110、1110等开头是为了标识我该字符应该读取几位而设定的，并且不与ASCII有所冲突。
         *      实际上要存储的字符编码值要比真正存储进计算机的二进制数要小很多。
         *      也就是 我们读取中文（正常3字节，含繁体）时，读取二进制，根据编码方式，我们从二进制中取出我们想要的 编码值（也就是x的组合数）——也就是Unicode唯一编码值（2字节）
         *                                      如 “尚”
         *       Unicode编码值：23578   二进制：01011100 00011010
         *       按照上面的编码方式  | 选用 1110xxxx 10xxxxxx 10xxxxxx
         *                       | 填入 11100101 10110000 10011010
         *                      这里的    0101   110000   011010 这串二进制就是你真正的编码值
         *
         *        好了，聊完这里我们就可以聊聊这块程序了。
         *          1. InputStreamReader.read() 根据源码注释：Reads a single character.
         *             每次读取一个字符（注意不是字节），返回他的编码值
         *          2. int c接收到编码值
         *          3. char ch接收到c编码值 转换而来的字符
         *              （这里具体用什么字符编码我还不清楚，也不是这次要探讨的重点）
         *              主要是 ch 的范围 2字节，在0-65535内，按照unicode的编码范围，包含一个中文的编码值正常来讲都是没有问题的
         *
         */
    }
}
