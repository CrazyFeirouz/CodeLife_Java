package dataStructures.sort.InsertSort.practice;

import java.util.Arrays;

/**
 * @description: 练习10 - 插入排序
 * @author: Feirouz
 * @date: 2022-04-04 15:48
 */
public class InsertSortTest10 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int temp = -1;
        for (int i = 1; i < arr.length; i++) {
            int curVal = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > curVal) { // !!! 不是 arr[j+1] 那样会在对比的时候出问题， curVal才对
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curVal;
        }
    }
}
