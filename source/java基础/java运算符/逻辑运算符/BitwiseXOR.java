package javabasic.javaoperators.logicaloperators;

/**
 * -*- coding: utf-8 -*-
 * @Author Feirouz
 * @Date 2021/4/18 00:37
 * @Des 演示三种替换方式，重点演示逻辑异或^运算
 */

public class BitwiseXOR {

    public static void main(String[] args) {

        // 三种替换方式
        int num1 = 1;
        int num2 = 2;
        System.out.println("num1 = " + num1 + "; num2 = " + num2);

        // 第一种 —— 定义临时变量（常用方式）
//        int temp;
//        temp = num1;
//        num1 = num2;
//        num2 = temp;

        // 第二种
        // 好处：无需临时变量
        // 弊端：①可能会溢出 ②局限性-只适用于数值类型
//        num1 = num1 + num2;
//        num2 = num1 - num2;
//        num1 = num1 - num2;

        // 第三种 —— 使用位运算符（逻辑异或-^）
        // 好处：①无需临时变量 ②不会溢出
        // 弊端：局限性-只适用于整数类型
        num1 = num1 ^ num2;     // num1 = num1 ^ num2;
        num2 = num1 ^ num2;     // num2 = (num1 ^ num2) ^ num2;
        num1 = num1 ^ num2;     // num1 = (num1 ^ num2) ^ (num1 ^ num2) ^ num2;

        System.out.println("=======交换后=======");
        System.out.println("num1 = " + num1 + "; num2 = " + num2);

    }
}
