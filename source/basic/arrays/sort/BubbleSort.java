package basic.arrays.sort;

/**
 * -*- coding: utf-8 -*-
 * @Author Feirouz
 * @Date 2021/4/21 17:08
 * @Des 冒泡排序
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{43, 25, 65, 1, 20, 47, 89, 30};

        //冒泡排序
        for(int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }


        //输出
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();

    }
}
