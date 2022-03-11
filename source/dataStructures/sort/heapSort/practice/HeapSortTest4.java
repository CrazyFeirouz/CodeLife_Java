package dataStructures.sort.heapSort.practice;

import java.util.Arrays;

/**
 * @description: 练习4 - 堆排序
 * @author: Feirouz
 * @date: 2022-03-11 20:22
 */
public class HeapSortTest4 {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, 10, 7, 3, 1, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            toBigTopHeap(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            toBigTopHeap(arr, 0, i);
        }
    }

    public static void toBigTopHeap(int[] arr, int i, int len) {
        int curVal = arr[i];
        for (int j = i * 2 + 1; j < len; j = j * 2 + 1) {
            if (j + 1 < len && arr[j] < arr[j + 1]) {       // 第一次噢，粗心了，不是j + 1 > len噢
                j++;
            }
            if (arr[j] > curVal) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = curVal;
    }
}
