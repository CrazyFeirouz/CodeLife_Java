package dataStructures.sort.shellSortInsert.practice;

import java.util.Arrays;

/**
 * @description: 希尔排序 (插入法)
 * @author: Feirouz
 * @date: 2022/4/12 18:00
 */
public class ShellSort2Test11 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int temp = -1;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int curVal = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > arr[j + gap]) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = curVal;
            }
        }
    }
}
