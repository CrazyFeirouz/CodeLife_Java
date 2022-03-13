package dataStructures.sort.InsertSort.practice;

import java.util.Arrays;

/**
 * @description: 练习9 - 插入排序
 * @author: Feirouz
 * @date: 2022-03-13 22:34
 * 这次挺特别的，开始反着写了
 */
public class InsertSortTest9 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int curVal = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > curVal){
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = curVal;
        }
    }
}
