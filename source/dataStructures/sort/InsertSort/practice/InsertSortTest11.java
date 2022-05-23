package dataStructures.sort.InsertSort.practice;

import java.util.Arrays;

/**
 * @description:
 * @author: Feirouz
 * @date: 2022-05-23 17:20
 */
public class InsertSortTest11 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 1; i <= arr.length -1 ; i++) {
            int curVal = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > curVal) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curVal;
        }
    }
}
