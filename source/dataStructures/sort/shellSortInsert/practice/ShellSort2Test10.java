package dataStructures.sort.shellSortInsert.practice;

import java.util.Arrays;

/**
 * @description: 练习10 - 希尔排序(插入法)
 * @author: Feirouz
 * @date: 2022/4/1 13:01
 */
public class ShellSort2Test10 {
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
                while (j >= 0 && arr[j + gap] < arr[j]) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = curVal;
            }
        }
    }
}
