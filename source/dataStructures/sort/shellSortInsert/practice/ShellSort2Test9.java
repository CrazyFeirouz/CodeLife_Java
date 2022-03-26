package dataStructures.sort.shellSortInsert.practice;

import java.util.Arrays;

/**
 * @description: 练习9 - 希尔排序 (可以, 已经到2分钟就写出来的地步了)
 * @author: Feirouz
 * @date: 2022/3/26 11:55
 */
public class ShellSort2Test9 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int curVal = arr[i];        // 让其 = 最后一个属
                int j = i - gap;
                while (j >= 0 && arr[j] > curVal) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = curVal;
            }
        }
    }
}
