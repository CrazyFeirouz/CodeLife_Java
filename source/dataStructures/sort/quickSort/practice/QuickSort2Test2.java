package dataStructures.sort.quickSort.practice;

import java.util.Arrays;

/**
 * @description: 练习2 - 快速排序（LeetCode学习版）
 * @author: Feirouz
 * @date: 2022-02-12 17:56
 */
public class QuickSort2Test2 {
    public static void main(String[] args) {
        int[] arr = {1, 9, 5, 3, -5, 0, 2, 7};

        sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

//        int baseNum = arr[left];       // 左边第一个数当基数

        int i = left;       // 左下标
        int j = right;      // 右下标

        int temp = -1;

        while (i < j) {
            while (i < j && arr[j] >= arr[left]){
                j--;
            }
            while (i < j && arr[i] <= arr[left]){
                i++;
            }
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        temp = arr[i];
        arr[i] = arr[left];
        arr[left] = temp;

        // 向左递归
        sort(arr, left, i);
        // 向右递归
        sort(arr, i + 1, right);
    }


}
