package dataStructures.sort.mergeSort.practice;

import java.util.Arrays;

/**
 * @description: 练习8 - 归并排序
 * @author: Feirouz
 * @date: 2022-03-05 15:54
 */
public class MergeSortTest8 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr, 0 , arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 向左
            sort(arr, left, mid, temp);
            // 向右
            sort(arr, mid + 1, right, temp);

            // 并
            int i = left;
            int j = mid + 1;
            int index = 0;
            // 两边比较
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
            // 两边剩余
            for (int k = i; k <= mid; k++) {
                temp[index] = arr[k];
                index++;                    // 这次漏了
            }
            for (int k = j; k <= right; k++) {
                temp[index] = arr[k];
                index++;                    // 这次漏了
            }
            // 回归
            for (int k = 0; k < index; k++) {
                arr[k + left] = temp[k];
            }
        }
    }
}
