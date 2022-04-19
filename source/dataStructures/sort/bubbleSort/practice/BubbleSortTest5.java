package dataStructures.sort.bubbleSort.practice;

import java.util.Arrays;

/**
 * @description: 练习5 - 冒泡排序
 * @author: Feirouz
 * @date: 2022-04-19 20:52
 */
public class BubbleSortTest5 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - i - 1; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
