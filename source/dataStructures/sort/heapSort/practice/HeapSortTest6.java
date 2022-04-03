package dataStructures.sort.heapSort.practice;

import java.util.Arrays;

/**
 * @description: 练习6 - 堆排序
 * @author: Feirouz
 * @date: 2022-04-03 12:35
 */
public class HeapSortTest6 {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, 10, 7, 3, 1, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {         // =的条件不要漏
            toBigTopHead(arr, i, arr.length);
        }

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[0];
            arr[0] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
            toBigTopHead(arr, 0, arr.length - i - 1);
        }
    }

    public static void toBigTopHead(int[] arr, int i, int len) {
        int curVal = arr[i];
        for (int j = 2 * i + 1; j < len; j = j * 2 + 1) {       // ！！！迭代条件错了 ， 是 2n+1
            if (j + 1 < len && arr[j] < arr[j + 1]) {
                j++;
            }
            if (curVal < arr[j]) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = curVal;
    }
}
