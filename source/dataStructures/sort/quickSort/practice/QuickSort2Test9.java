package dataStructures.sort.quickSort.practice;

import java.util.Arrays;

/**
 * @description:
 * @author: Feirouz
 * @date: 2022-05-15 2:40
 */
public class QuickSort2Test9 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int curVal = arr[left];
        int i = left;
        int j = right;
        int temp = -1;
        while (i < j) {
            while (i < j && arr[j] >= curVal) {
                j--;
            }
            while (i < j && arr[i] <= curVal) {
                i++;
            }
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[left] = arr[i];
        arr[i] = curVal;

        sort(arr, left, i - 1);
        sort(arr, i + 1, right);

    }
}
