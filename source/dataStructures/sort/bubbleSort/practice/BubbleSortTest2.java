package dataStructures.sort.bubbleSort.practice;

import java.util.Arrays;

/**
 * @description: 练习2 - 冒泡排序
 * @author: Feirouz
 * @date: 2022-03-02 14:53
 */
public class BubbleSortTest2 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
