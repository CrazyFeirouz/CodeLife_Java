package dataStructures.sort.quickSort;

import java.util.Arrays;

/**
 * @description: 快速排序 - Leetcode学习版本
 * @author: Feirouz
 * @date: 2022-02-10 14:47
 */

// 由于之前版本的快速排序学的并不是很懂，所以换一个版本学习。
public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 0, 3, 5};

        sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        // 这里让arr[l] - 第一个数作为基数
        int i = l;  // 左指针
        int j = r;  // 右指针

        while(i < j) {
            while (i < j && arr[j] >= arr[l]) {     // 找出右边比基数小的数
                j--;
            }
            while (i < j && arr[i] <= arr[l]) {     // 找出左边比基数大的数
                i++;
            }
            // 交换
            swap(arr, i, j);
        }
        // 到这步时，i和j指针都会指向 一个 比基数 小的数
        // 这时将 i 和 基数 位置交换， 就会呈现 [左边小 - 基数 - 右边大] 的情况
        swap(arr, i, l);

        System.out.println("当前情况：" + Arrays.toString(arr));     // 当前情况：[2, 0, 1, 4, 3, 5]

        sort(arr, l, i - 1);
        sort(arr, i + 1, r);
    }

    public static void swap(int[] arr, int a, int b) {
        if(a == b) {
            return;
        }
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
