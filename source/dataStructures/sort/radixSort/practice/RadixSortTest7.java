package dataStructures.sort.radixSort.practice;

import java.util.Arrays;

/**
 * @description: 练习7 - 基数排序
 * @author: Feirouz
 * @date: 2022-04-18 23:20
 */
public class RadixSortTest7 {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[][] temp = new int[10][arr.length];
        int[] tempCount = new int[10];

        // 找到最大位数
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        int maxBin = (maxVal + "").length();

        // 记录当前位数
        for (int i = 0; i < maxBin; i++) {
            // 遍历，挨个取出
            for (int j = 0; j < arr.length; j++) {
                int curBinVal = arr[j] / (int)Math.pow(10, i) % 10;
                temp[curBinVal][tempCount[curBinVal]] = arr[j];
                tempCount[curBinVal]++;
            }

            // 按顺序取出桶
            int index = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < tempCount[j]; k++) {
                    arr[index] = temp[j][k];
                    index++;
                }
                tempCount[j] = 0;
            }
        }
    }
}
