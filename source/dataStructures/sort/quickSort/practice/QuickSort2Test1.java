package dataStructures.sort.quickSort.practice;

import java.util.Arrays;

/**
 * @description: 练习1 - 快速排序（LeetCode学习版）
 * @author: Feirouz
 * @date: 2022-02-11 12:33
 */
public class QuickSort2Test1 {
    public static void main(String[] args) {
        int[] arr = {1,5,3,9,-5,10,-90,50};

        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int temp = -1;

        int left = start;
        int right = end;

        while (left < right) {
            while (left < right && arr[right] > arr[start]) {
                right--;
            }
            while (left < right && arr[left] <= arr[start]) {
                left++;
            }
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        temp = arr[left];
        arr[left] = arr[start];
        arr[start] = temp;

        // 左
        sort(arr, start, left - 1);
        // 右
        sort(arr, left + 1, end);
    }
}
