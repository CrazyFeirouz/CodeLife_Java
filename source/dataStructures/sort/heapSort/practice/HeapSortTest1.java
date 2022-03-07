package dataStructures.sort.heapSort.practice;

import java.util.Arrays;

/**
 * @description: 练习1 - 堆排序
 * @author: Feirouz
 * @date: 2022-03-07 22:13
 */
public class HeapSortTest1 {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 调整成大顶堆
        // arr.length / 2 - 1 可以取到 最下&最右的父节点
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 将堆顶元素与末尾交换，将最大元素"沉"到数组末端
        int temp = -1;
        for (int i = arr.length - 1; i > 0; i--) {
            // 交换
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }

    }


    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        // 1. 遍历左子节点
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            // 取出最大的一方
            if (j + 1 < length && arr[j] < arr[j + 1]){
                j++;
            }
            if (arr[j] > temp) {        // 子节点 大于 父节点
                arr[i] = arr[j];
                i = j;
            } else {                    // 子节点 没有大于 父节点
                break;
            }
        }
        arr[i] = temp;                  // 将temp放到调整之后的位置
    }
}
