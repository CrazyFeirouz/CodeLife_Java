package dataStructures.sort.selectSort.practice;

import java.util.Arrays;

/**
 * @description: 练习1 - 选择排序
 * @author: Feirouz
 * @date: 2022-02-26 17:19
 */

public class SelectSortTest1 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int minVal = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minVal) {
                    minIndex = j;
                    minVal = arr[j];
                }
            }
            int temp = arr[i];
            arr[i] = minVal;
            arr[minIndex] = temp;
        }
    }
}
