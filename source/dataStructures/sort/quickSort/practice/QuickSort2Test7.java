package dataStructures.sort.quickSort.practice;

import java.util.Arrays;

/**
 * @description: 练习7 - 快速排序
 * @author: Feirouz
 * @date: 2022/3/20 16:18
 */

public class QuickSort2Test7 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr, 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int curTemp = arr[i];
        int temp = -1;
        while (i < j) {
            while (i < j && arr[j] >= curTemp) {
                j--;
            }
            while (i < j && arr[i] <= curTemp) {
                i++;
            }
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[left] = arr[i];
        arr[i] = curTemp;

        // 向左
        sort(arr, left, i - 1);
        // 向右
        sort(arr, i + 1, right);
    }
}
