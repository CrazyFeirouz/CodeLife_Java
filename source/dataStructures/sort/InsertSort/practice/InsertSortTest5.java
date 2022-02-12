package dataStructures.sort.InsertSort.practice;

import java.util.Arrays;

/**
 * @description: 练习5 - 插入排序
 * @author: Feirouz
 * @date: 2022-02-12 19:00
 */
public class InsertSortTest5 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int curVal = arr[i + 1];     // 比较为第二个数，因为后移，所以后面那个数先取出来
            int j = i;              // 从第一个数开始比
            while (j >= 0 && arr[j] > curVal) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curVal;
        }
    }
}
