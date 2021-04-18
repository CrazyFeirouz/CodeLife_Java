package basic.operator.logic;

/**
 * -*- coding: utf-8 -*-
 * @Author Feirouz
 * @Date 2021/4/18 20:49
 * @Des 模拟进制转换, 使用 & 和 位移运算 来实现
 */

public class BHDConverter {
    public static void main(String[] args) {
        binToHex(60);
    }

    /**
     * 十进制 转 十六进制
     * @param num 需要转换的数
     */
    public static void binToHex(int num){
        //实现0-255的转换，255 - 1111 1111

        // 方式一：自动实现
//        String str2 = Integer.toHexString(num);
//        System.out.println(str2);

        // 方式二：手动实现

        // 转换第一位Hex
        int transNum1 = num & 15;       //15 - 1111，取出二进制 后4位数
        String hex1 = transNum1 > 9 ? (char)(transNum1 - 10 + 'A') + "" : transNum1 + "";   //十六进制数 1-9， A-F

        // 转换第二位Hex
        num = num >>> 4;        //右移4位，去除刚刚已取出的4位
        int transNum2 = num & 15;       //同理
        String hex2 = transNum2 > 9 ? (char)(transNum2 - 10 + 'A') + "" : transNum2 + "";

        System.out.println(hex2 + "" + hex1);

    }
}
