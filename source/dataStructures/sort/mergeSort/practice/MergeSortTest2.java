package dataStructures.sort.mergeSort.practice;

import java.util.Arrays;

/**
 * @description: 练习2 - 归并排序
 * @author: Feirouz
 * @date: 2022-02-11 21:38
 */
public class MergeSortTest2 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,8,6,-1,2,-8,0};

        sort(arr, 0, arr.length - 1, new int[arr.length]);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;

            // 左边分
            sort(arr, left, mid, temp);
            // 右边分
            sort(arr, mid + 1, right, temp);

            // 并
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 左右比较，看看谁更小
        int i = left;
        int j = mid + 1;
        int index = 0;      // 临时数组下标
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {       // 左边小
                temp[index] = arr[i];
                i++;
            } else {       // 右边小
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        // 上面其中一边已经放好了
        // 左边没放完的情况
        while (i <= mid) {
            temp[index] = arr[i];
            index++;
            i++;
        }
        // 右边没放完的情况
        while (j <= right) {
            temp[index] = arr[j];
            index++;
            j++;
        }

        // 换好以后，返回数据到原数组中
        int arrIndex = left;
        for (int k = 0; k < index; k++) {
            arr[arrIndex] = temp[k];
            arrIndex++;
        }
    }
}
