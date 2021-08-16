package basic.api.strings;

/**
 * @description: String 与 char[] 之间的转换题目
 * @author: Feirouz
 * @date: 2021-06-14 19:42
 *
 * 题目：将 “abc123” 转为 “a21cb3”
 *      优化：不论数组长度及内容，保留第一位和最后一位，其余位数反转
 */
public class SimpleTest {
    public static void main(String[] args) {
        String s1 = "abc123";                   //原字符串

        char[] c1 = new char[s1.length() - 2];  //目标字符数组（需要 去除 前后字符）

        s1.getChars(1,s1.length() - 1, c1, 0);      // 将字符串 从第2个到倒数第2位 转为字符数组

        for (int i = 0; i < c1.length / 2; i++){    //字符数组开始反转
            char reverse = c1[i];
            c1[i] = c1[c1.length - i - 1];
            c1[c1.length - i - 1] = reverse;
        }

        String result = s1.charAt(0) + new String(c1) + s1.charAt(s1.length() - 1);  //将 前 中 后 部分拼接 得到指定要求格式的字符串
        System.out.println("转换完成：" + result);

    }
}
