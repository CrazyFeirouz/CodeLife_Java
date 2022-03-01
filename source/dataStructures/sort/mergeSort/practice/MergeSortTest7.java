package dataStructures.sort.mergeSort.practice;

import java.util.Arrays;

/**
 * @description: 练习7 - 归并排序
 * @author: Feirouz
 * @date: 2022-03-01 18:48
 */
public class MergeSortTest7 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr, 0, arr.length-1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 向左
            sort(arr, left, mid, temp);
            // 向右
            sort(arr, mid + 1, right, temp);

            int i = left;
            int j = mid + 1;
            int index = 0;
            while (i <= mid && j <= right) {
                if (arr[i] < arr[j]) {
                    temp[index] = arr[i];
                    i++;
//                } else if (arr[j] < arr[i]) {     // 这次的问题出在这里： 如果相等呢？
                } else {
                    temp[index] = arr[j];
                    j++;
                }
                index++;
            }
            for (int k = i; k <= mid; k++) {
                temp[index] = arr[k];
                index++;
            }
            for (int k = j; k <= right; k++) {
                temp[index] = arr[k];
                index++;
            }
            int index2 = 0;
            for (int k = left; k < left + index; k++) {
                arr[k] = temp[index2];
                index2++;
            }
        }
    }
}
