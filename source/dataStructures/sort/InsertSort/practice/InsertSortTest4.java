package dataStructures.sort.InsertSort.practice;

import java.util.Arrays;

/**
 * @description: 练习4 - 插入排序
 * @author: Feirouz
 * @date: 2022-02-11 22:03
 */
public class InsertSortTest4 {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {   // 前 > 后
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
}
