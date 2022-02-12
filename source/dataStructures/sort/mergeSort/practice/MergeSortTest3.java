package dataStructures.sort.mergeSort.practice;

import java.util.Arrays;

/**
 * @description: 练习3 - 归并排序
 * @author: Feirouz
 * @date: 2022-02-12 18:32
 */
public class MergeSortTest3 {
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

        // 向左递归
        sort(arr, left, mid, temp);
        // 向右
        sort(arr, mid + 1, right, temp);

        // 治
        int index = 0;  // 临时数组下标
        int i = left;   // 左边 第一个
        int j = mid + 1;    // 右边 第一个
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {          // 左边的数小
                temp[index] = arr[i];
                i++;
            }else if (arr[i] >= arr[j]) {   // 右边的数小， 或者相等的情况，默认先放右边
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        // 左右两边一定其中一边放完了
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
        // 放好temp了， 最后返回原数组
        for (int k = 0, g = left; k < index; k++, g++) {
            arr[g] = temp[k];
        }
    }

}
