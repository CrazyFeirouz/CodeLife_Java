package dataStructures.sort.quickSort.practice;

import java.util.Arrays;

/**
 * @description: 练习3 - 快速排序
 * @author: Feirouz
 * @date: 2022-02-14 16:44
 */
public class QuickSort2Test3 {
    public static void main(String[] args) {
//        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        int[] arr = {8,10,1,2,3,-4,8,-9,6,8};

        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;

        int temp = -1;
        while (i < j) {
            while (i < j & arr[j] >= arr[left]){
                j--;
            }
            while (i < j & arr[i] <= arr[left]){
                i++;
            }
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        temp = arr[left];
        arr[left] = arr[i];
        arr[i] = temp;

        // 向左
        sort(arr, left, i);
        // 向右
        sort(arr, i + 1, right);

    }
}
