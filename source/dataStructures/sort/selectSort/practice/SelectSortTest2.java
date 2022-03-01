package dataStructures.sort.selectSort.practice;

import java.util.Arrays;

/**
 * @description: 练习2 - 选择排序
 * @author: Feirouz
 * @date: 2022-03-01 21:25
 */
public class SelectSortTest2 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int minVal = arr[i];
            for (int j = i; j < arr.length; j++) {  // 可以 i + 1, 这里多比较了一次
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
