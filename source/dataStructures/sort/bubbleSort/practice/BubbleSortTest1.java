package dataStructures.sort.bubbleSort.practice;

import java.util.Arrays;

/**
 * @description: 练习1 - 冒泡排序
 * @author: Feirouz
 * @date: 2022-02-25 19:48
 */
public class BubbleSortTest1 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int temp = -1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
