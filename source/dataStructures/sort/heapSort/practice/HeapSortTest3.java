package dataStructures.sort.heapSort.practice;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @description: 练习3 - 堆排序
 * @author: Feirouz
 * @date: 2022-03-09 22:20
 */
public class HeapSortTest3 {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, 10, 7, 3, 1, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
            toBigTopHeap(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            toBigTopHeap(arr, 0, i);
        }
    }

    public static void toBigTopHeap(int[] arr, int i, int length) {
        // 先存父节点
        int curVal = arr[i];

        // for遍历左子节点
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j+1]) {      // !!! j + 1 < length漏了，不然会越界的
                j++;
            }
            if (arr[j] > curVal) {
                arr[i] = arr[j];
                i = j;
            }else {
                break;
            }
        }
        arr[i] = curVal;
    }
}
