package dataStructures.sort.shellSortInsert.practice;

import java.util.Arrays;

/**
 * @description: 练习4 - 希尔排序(插入法)
 * @author: Feirouz
 * @date: 2022-02-14 18:49
 */
public class ShellSort2Test4 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int curVal = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > curVal) {
                    arr[j+gap] = arr[j];
                    j -= gap;
                }
                arr[j+gap] = curVal;
            }
        }
    }

}
