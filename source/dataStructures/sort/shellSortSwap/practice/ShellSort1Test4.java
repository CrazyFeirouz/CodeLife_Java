package dataStructures.sort.shellSortSwap.practice;

import java.util.Arrays;

/**
 * @description: 练习4 - 希尔排序（交换法）
 * @author: Feirouz
 * @date: 2022-02-13 13:55
 */
public class ShellSort1Test4 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = -1;
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j+gap] < arr[j]) {
                        temp = arr[j+gap];
                        arr[j+gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }
}
