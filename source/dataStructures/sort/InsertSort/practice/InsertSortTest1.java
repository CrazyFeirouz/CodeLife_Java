package dataStructures.sort.InsertSort.practice;

import java.util.Arrays;

/**
 * @description: 练习： 插入排序
 * @author: Feirouz
 * @date: 2022-02-09 14:06
 */
public class InsertSortTest1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,0,2,5,7,8,-4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 写完希尔排序回来写的 插入排序，这个插入排序就非常像希尔那边中间那段。思路一致没问题
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int minVal = arr[j-1];
            while(j > 0 && arr[j] < minVal){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j+1] = minVal;
        }
    }
}
