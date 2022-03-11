package dataStructures.sort.mergeSort.practice;

import java.util.Arrays;

/**
 * @description: 练习10 - 归并排序
 * @author: Feirouz
 * @date: 2022-03-11 18:16
 */
public class MergeSortTest9 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        // 向左
        sort(arr, left, mid, temp); // 这里的left可能会跟mid相等，注意！！！
        // 向右
        sort(arr, mid + 1, right, temp);
        // 并
        //排序
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
        // 放回
        for (int k = 0, n = 0; k < index; k++, n++) {
            arr[left + k] = temp[n];
        }

    }
}
