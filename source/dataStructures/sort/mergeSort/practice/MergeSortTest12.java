package dataStructures.sort.mergeSort.practice;

import java.util.Arrays;

/**
 * @description: 练习12 - 归并排序
 * @author: Feirouz
 * @date: 2022-04-20 11:13
 */
public class MergeSortTest12 {
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
        int j = mid + 1;        // 注意这里不是r，而是mid+1
        int index = 0;
        while (i <= mid && j <= right) {
            if (j <= right && arr[j] < arr[i]) {
                temp[index] = arr[j];
                j++;
            }else {
                temp[index] = arr[i];
                i++;
            }
            index++;
        }

        for (int k = i; k <= mid; k++) {
            temp[index] = arr[i];
            index++;
            i++;
        }

        for (int k = j; k <= right; k++) {
            temp[index] = arr[j];
            index++;
            j++;
        }

        // 按顺序放回
        for (int k = 0; k < index; k++) {
            arr[left + k] = temp[k];
        }
    }
}
