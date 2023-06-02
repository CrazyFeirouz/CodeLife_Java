package dataStructures.sort.quickSort.practice;

import java.util.Arrays;

/**
 * @description: 测试他人版本
 * @author: Feirouz
 * @date: 2023-05-12 20:23
 */
public class QuickSort2Test10 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        QuickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void QuickSort2(int[] dateArray,int left,int right) {
        if (left - right < 1)
            return;

        int x = dateArray[left];
        int l = left, r = right;

        while (l < r)
        {
            while (l < r && dateArray[l]<x)
                l++;
            while (l < r && dateArray[r] >= x)
                r--;

            int temp = dateArray[l];
            dateArray[l] = dateArray[r];
            dateArray[r] = temp;
        }

        dateArray[l] = x;

        QuickSort2(dateArray, left, l - 1);
        QuickSort2(dateArray, l+1, right);

    }
}
