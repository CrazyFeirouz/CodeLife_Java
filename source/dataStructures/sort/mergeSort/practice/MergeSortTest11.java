package dataStructures.sort.mergeSort.practice;

import basic.arrays.crl.ArrayReverse;

import java.util.Arrays;

/**
 * @description: 练习11 - 归并排序
 * @author: Feirouz
 * @date: 2022-04-03 13:03
 */
public class MergeSortTest11 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }else {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);

            int i = left;
            int j = mid + 1;
            int index = 0;
            while (i <= mid && j <= right) {
                if (arr[i] < arr[j]) {
                    temp[index] = arr[i];
                    i++;
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
            for (int k = 0; k < index; k++) {
                arr[left + k] = temp[k];
            }
        }
    }
}
