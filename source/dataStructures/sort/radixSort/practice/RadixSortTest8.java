package dataStructures.sort.radixSort.practice;

import java.util.Arrays;

/**
 * @description: 测验8 - 基数排序
 * @author: Feirouz
 * @date: 2022/5/30 23:32
 */
public class RadixSortTest8 {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 找到最大的数
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxVal < arr[i]) {
                maxVal = arr[i];
            }
        }

        // 获取该数位数
        int maxBin = (" " + maxVal).length();

        // 创建桶
        int[][] buck = new int[10][arr.length];
        int[] buckSize = new int[10];

        for (int i = 0; i < maxBin; i++) {
            // 循环取出对应位数 并 存在桶里
            for (int j = 0; j < arr.length; j++) {
                int curNum = (arr[j] / (int)Math.pow(10, i)) % 10;
                buckSize[curNum]++;
                buck[curNum][buckSize[curNum]-1] = arr[j];
            }
            // 10个桶进行排序取出
            int index = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < buckSize[j]; k++) {
                    arr[index] = buck[j][k];
                    index++;
                }
                buckSize[j] = 0;
            }
        }
    }
}
