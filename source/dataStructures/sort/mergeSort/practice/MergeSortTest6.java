package dataStructures.sort.mergeSort.practice;

import java.util.Arrays;

/**
 * @description: 练习6 - 归并排序 (丝滑)
 * @author: Feirouz
 * @date: 2022-02-25 19:08
 */
public class MergeSortTest6 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 分
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);

            // 治
            int index = 0;
            int i = left;
            int j = mid + 1;
            while (i <= mid && j <= right) {
                if (arr[i] < arr[j]) {
                    temp[index] = arr[i];
                    i++;
                }else {
                    temp[index] = arr[j];
                    j++;
                }
                index++;
            }
            while (i <= mid) {
                temp[index] = arr[i];
                i++;
                index++;
            }
            while (j <= right) {
                temp[index] = arr[j];
                j++;
            }
            for (int k = 0; k < index; k++) {
                arr[left + k] = temp[k];
            }

        }
    }
}
