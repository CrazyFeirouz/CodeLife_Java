package dataStructures.sort.selectSort.practice;

import java.util.Arrays;

/**
 * @description: 选择排序
 * @author: Feirouz
 * @date: 2022/4/12 18:03
 */
public class SelectSortTest7 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minVal = arr[i];
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < minVal) {
                    minIndex = j;
                    minVal = arr[j];
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = minVal;
        }
    }
}
