package dataStructures.sort.mergeSort.practice;

import java.util.Arrays;

/**
 * @description: 练习4 - 归并排序
 * @author: Feirouz
 * @date: 2022-02-15 13:33
 */
public class MergeSortTest4 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};

        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        int mid = (left + right) / 2;

        if (left < right) {
            // 向左
            sort(arr, left, mid);
            // 向右
            sort(arr, mid + 1, right);
        }

        // 并
        int i = left;
        int j = mid + 1;
        int[] temp = new int[arr.length];
        int index = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
                i++;
            } else if (arr[i] > arr[j]) {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        // 放完，其中一边肯定还有
        while (i <= mid) {
            temp[index] = arr[i];
            i++;
            index++;
        }
        while (j <= right) {
            temp[index] = arr[j];
            j++;
            index++;
        }
        int h = left;
        // 放完，接下来取回
        for (int k = 0; k < index; k++) {
            arr[h] = temp[k];
            h++;
        }

    }
}
