package basic.operator.logic;

/**
 * -*- coding: utf-8 -*-
 * @Author Feirouz
 * @Date 2021/4/18 20:49
 * @Des 模拟进制转换, 使用 & 和 位移运算 来实现
 */

public class BHDConverter {
    public static void main(String[] args) {
        // 方式一：自动实现
        String str1 = Integer.toBinaryString(60);
        String str2 = Integer.toHexString(60);

        System.out.println("二进制：" + str1 + "；十六进制：" + str2);
    }
}
