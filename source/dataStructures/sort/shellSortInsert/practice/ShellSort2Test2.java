package dataStructures.sort.shellSortInsert.practice;

import java.util.Arrays;

/**
 * @description: 练习2 - 希尔排序（插入法）
 * @author: Feirouz
 * @date: 2022-02-10 13:37
 */
public class ShellSort2Test2 {
    public static void main(String[] args) {
        int[] arr = {-5,3,9,8,2,-90,51,20,54,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i - gap;
                int minValue = arr[j+gap];
                while (j >= 0 && arr[j] > minValue) {
                    arr[j+gap] = arr[j];
                    j-=gap;
                }
                arr[j+gap] = minValue;
            }
        }
    }
}
