package dataStructures.sort.mergeSort.practice;

import java.util.Arrays;

/**
 * @description: 练习5 - 归并排序 (这次写的有点慢)
 * @author: Feirouz
 * @date: 2022-02-24 15:23
 */
public class MergeSortTest5 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            // 向左
            sort(arr, left, mid);
            // 向右
            sort(arr, mid + 1, right);

            // 并
            int[] temp = new int[arr.length];
            int index = 0;

            int i = left;       // 左边开始下标
            int j = mid + 1;        // 右边开始下标

            while (i <= mid && j <= right) {     // 谁小放谁
                if (arr[i] < arr[j]) {
                    temp[index] = arr[i];
                    i++;
                } else {
                    temp[index] = arr[j];
                    j++;
                }
                index++;
            }

            // 其中一边有剩余
            while (i <= mid) {
                temp[index] = arr[i];
                i++;
                index++;
            }
            while (j <= right) {
                temp[index] = arr[j];
                j++;
                index++;
            }

            // 放回
            for (int k = 0; k < index; k++) {
                arr[left + k] = temp[k];
            }
        }
    }
}
