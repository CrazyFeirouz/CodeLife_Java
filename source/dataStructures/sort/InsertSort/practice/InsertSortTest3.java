package dataStructures.sort.InsertSort.practice;

import java.util.Arrays;

/**
 * @description: 练习3 - 插入排序
 * @author: Feirouz
 * @date: 2022-02-11 14:32
 */
public class InsertSortTest3 {
    public static void main(String[] args) {
        int[] arr = {3,5,5,9,0,1,-5,2};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {          // 1-7
            int curVal = arr[i];                        // 先把后面的数取出， 因为后移，所以一定会被覆盖
            int j = i - 1;                              // 0-6
            while (j >= 0 && arr[j] > curVal) {          // 如果前面一个数 大于 后面的数 => 交换
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curVal;
        }
    }
}
