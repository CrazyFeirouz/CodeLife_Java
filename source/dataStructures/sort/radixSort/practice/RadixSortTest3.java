package dataStructures.sort.radixSort.practice;

import java.util.Arrays;

/**
 * @description: 练习3 - 基数排序
 * @author: Feirouz
 * @date: 2022-02-13 14:14
 */
public class RadixSortTest3 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,4,8,9,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 找出最大位数
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        int maxBin = (maxVal + "").length();

        // 开始排序
        int buck[][] = new int[10][arr.length];
        int buckCount[] = new int[buck.length];
        for (int i = 0; i < maxBin; i++) {
            // 把arr数值存入buck中
            for (int j = 0; j < arr.length; j++) {
                int curBin = arr[j] / (int)Math.pow(10,i) % 10;
                buck[curBin][buckCount[curBin]] = arr[j];
                buckCount[curBin]++;
            }
            // 存完，放回去
            int index = 0;
            for (int j = 0; j < buck.length; j++) {
                for (int k = 0; k < buckCount[j]; k++) {
                    arr[index] = buck[j][k];
                    index++;
                }
                buckCount[j] = 0;
            }
        }
    }
}
