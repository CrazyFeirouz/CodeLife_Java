package dataStructures.sort.shellSortInsert.practice;

import java.util.Arrays;

/**
 * @description: 练习7 - 希尔排序(插入法)
 * @author: Feirouz
 * @date: 2022/3/22 21:14
 */
public class ShellSort2Test7 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int temp = -1;
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i - gap;
                int curVal = arr[i];                             // !!! 这才是插入
                // !!! 这次判断条件 "j>=0" 才对, 而不是 "j<gap"
                // !!! "arr[j] > arr[j + gap]" 应该换成 "arr[j] > curVal" - 写着写着变交换法可还行兄弟
                while (j >= 0 && arr[j] > curVal) {
                    // 你这是个锤子插入法, 写成交换了...
//                    temp = arr[j];
//                    arr[j] = arr[j + gap];
//                    arr[j + gap] = temp;
                    arr[j + gap] = arr[j];                      // !!! 这才是插入
                    j -= gap;                                   // !!! 这次判断条件 "j-=gap" 才对, 而不是 "j+=gap"
                }
                arr[j + gap] = curVal;                           // !!! 这才是插入
            }
        }
    }
}
