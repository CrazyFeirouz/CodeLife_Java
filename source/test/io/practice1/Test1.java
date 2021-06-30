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
                char ch = (char)c;
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


    }
}
