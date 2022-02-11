package dataStructures.sort.mergeSort.practice;

import java.util.Arrays;

/**
 * @description: 练习1 - 归并排序
 * @author: Feirouz
 * @date: 2022-02-11 13:22
 */
public class MergeSortTest1 {
    public static void main(String[] args) {
        int[] arr = {90,5,6,-5,40,20,10,2,-9,0};

        sort(arr, 0, arr.length - 1, new int[arr.length]);

        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr, int start, int end, int[] temp) {
        if (start < end) {
            int mid = (start + end) / 2;
            // 左边分解
            sort(arr, start, mid, temp);
            // 右边分解
            sort(arr, mid + 1, end, temp);
            // 合并
            merge(arr, start, mid, end, temp);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end, int[] temp) {
        int left = start;           // 左边有序序列的初始索引
        int right = mid + 1;        // 右边有序序列的初始索引
        int tempIndex = 0;          // 指向temp数组的当前索引

        // 1. 先把左右两边的数据（有序）填充到temp数组中
        while (left <= mid && right <= end) {
            if(arr[left] < arr[right]) {        // 左边小
                temp[tempIndex] = arr[left];
                left++;
            }else {                             // 右边小
                temp[tempIndex] = arr[right];
                right++;
            }
            tempIndex++;
        }

        // 2. 把剩余的数据全部填充到temp
        while (left <= mid) {
            temp[tempIndex] = arr[left];
            left++;
            tempIndex++;
        }
        while (right <= end) {
            temp[tempIndex] = arr[right];
            right++;
            tempIndex++;
        }

        // 3. 将temp数组的元素拷贝回arr
        // 注意：不是每次都拷贝所有
        tempIndex = 0;

        for (int left2 = start; left2 <= end; left2++) {
            arr[left2] = temp[tempIndex];
            tempIndex++;
        }

    }
}
