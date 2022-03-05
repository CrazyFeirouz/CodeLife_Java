package dataStructures.sort.shellSortInsert.practice;

import java.util.Arrays;

/**
 * @description:
 * @author: Feirouz
 * @date: 2022-03-05 16:06
 */
public class ShellSort2Test6 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int curVal = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > curVal) {     // 注意： 插入排序的条件 是 同时判断
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = curVal;
            }
        }
    }
}
