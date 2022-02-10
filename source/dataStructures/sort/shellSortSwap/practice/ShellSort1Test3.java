package dataStructures.sort.shellSortSwap.practice;

import java.util.Arrays;

/**
 * @description:
 * @author: Feirouz
 * @date: 2022-02-10 13:23
 */
public class ShellSort1Test3 {

    public static void main(String[] args) {
        int[] arr = {1,8,6,-5,2,400,-99,25,11,28,};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int temp = -1;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j+gap]) {
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
    }
}
