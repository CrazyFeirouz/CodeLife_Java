package dataStructures.sort.InsertSort.practice;

import java.util.Arrays;

/**
 * @description: 练习2 - 插入排序
 * @author: Feirouz
 * @date: 2022-02-10 12:53
 */
public class InsertSortTest2 {
    public static void main(String[] args) {
        int[] arr = {-1,2,6,8,4,2,-4,9};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxVal = arr[i+1];
            int tempIndex = i;
            while(tempIndex >= 0 && arr[tempIndex] > maxVal) {
                arr[tempIndex+1] = arr[tempIndex];
                tempIndex--;
            }
            arr[tempIndex+1] = maxVal;
        }
    }
}
