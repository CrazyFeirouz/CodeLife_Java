package dataStructures.sort.mergeSort.practice;

import java.util.Arrays;

/**
 * @description: 测验13 - 归并排序
 * @author: Feirouz
 * @date: 2022-05-23 6:18
 */
public class MergeSortTest13 {
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
        // 分
        sort(arr, left, mid, temp);
        sort(arr, mid + 1, right, temp);

        // 治
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]){
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
        for (int k = 0; k < index; k++) {
            arr[k + left] = temp[k];
        }
    }
}
