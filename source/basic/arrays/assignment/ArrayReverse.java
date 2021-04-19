package basic.arrays.assignment;

/**
 * -*- coding: utf-8 -*-
 * @Author Feirouz
 * @Date 2021/4/19 21:57
 * @Des 数组反转
 */

public class ArrayReverse {
    public static void main(String[] args) {
        String[] array = new String[]{"AA", "BB", "CC", "DD", "EE", "FF","GG"};
        for (int i = 0; i < array.length; i++) {            //先遍历反转前数组
            System.out.print(array[i] + "\t");
        }

        String temp;                                        //反转临时变量
        for (int i = 0; i < array.length/2; i++) {          //开始反转
            temp = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = temp;
        }

        System.out.println("\n=========反转后=========");      //反转后输出
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
