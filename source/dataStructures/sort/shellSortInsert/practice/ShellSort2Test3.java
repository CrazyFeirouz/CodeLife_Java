package dataStructures.sort.shellSortInsert.practice;

import java.util.Arrays;

/**
 * @description: 练习3 - 希尔排序（插入法）
 * @author: Feirouz
 * @date: 2022-02-11 16:20
 */
public class ShellSort2Test3 {
    public static void main(String[] args) {
        int[] arr = {0,-4,2,5,8,3,4,9};

        sort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr) {
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int curVal = arr[i];            // 后
                int j = i - gap;                // 前
                while (j >= 0 && arr[j] > curVal) {
                    arr[j+gap] = arr[j];
                    j-=gap;
                }
                arr[j+gap] = curVal;
            }
        }
    }
}
