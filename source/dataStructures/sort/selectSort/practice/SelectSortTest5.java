package dataStructures.sort.selectSort.practice;

import java.util.Arrays;

/**
 * @description:
 * @author: Feirouz
 * @date: 2022-03-09 17:21
 */
public class SelectSortTest5 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int minVal = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minVal) {
                    minIndex = j;
                    minVal = arr[j];
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = minVal;
        }
    }
}
