package dataStructures.sort.heapSort.practice;

import java.util.Arrays;

/**
 * @description: 练习2 - 堆排序
 * @author: Feirouz
 * @date: 2022-03-08 19:50
 */
public class HeapSortTest2 {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, 10, 7, 3, 1, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 先将整个数组排成大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            toBigTopHeap(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        // 开始排序
        int temp = -1;
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            toBigTopHeap(arr, 0, i);
        }
    }

    // 将当前节点的树排成有序
    public static void toBigTopHeap(int[] arr, int i, int length) {
        // 存入当前节点值
        int temp = arr[i];
        // 转到最后一个节点
        // 遍历左节点
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            // 找到最大一方
            // !!! j + 1 < length 不要漏
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;              // 这里表示，要是和右边换了，我们再排序右边的大小关系
            } else {
                break;
            }
        }
        arr[i] = temp;


    }
}
