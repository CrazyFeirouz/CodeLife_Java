package dataStructures.sort.quickSort.practice;

import java.util.Arrays;

/**
 * @description: 练习5 -
 * @author: Feirouz
 * @date: 2022-02-25 19:15
 */
public class QuickSort2Test5 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int baseNum = arr[left];
            int i = left;
            int j = right;
            int temp = -1;
            while (i < j) {
                while (i < j && arr[j] >= baseNum) {
                    j--;
                }
                while (i < j && arr[i] <= baseNum) {
                    i++;
                }
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            arr[left] = arr[i];
            arr[i] = baseNum;

            // 向左递归
            sort(arr, left, i);
            // 向右递归
            sort(arr, i + 1, right);
        }
    }
}
