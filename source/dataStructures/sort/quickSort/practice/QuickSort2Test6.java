package dataStructures.sort.quickSort.practice;

import java.util.Arrays;

/**
 * @description: 练习6 - 快速排序
 * @author: Feirouz
 * @date: 2022-03-08 19:30
 */
public class QuickSort2Test6 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int curBase = arr[left];
            int i = left;
            int j = right;
            int temp = -1;
            while (i < j) {
                while (i < j && arr[j] >= curBase) {
                    j--;
                }
                while (i < j && arr[i] <= curBase) {
                    i++;
                }
                // 交换
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            // i=j,指向最小的数
            arr[left] = arr[i];
            arr[i] = curBase;

            // 向左
            sort(arr, left, i);     // ！！！中间位置已经确定了， 其实 i 换成 i - 1更好
            // 向右
            sort(arr, i + 1, right);
        }
    }
}
