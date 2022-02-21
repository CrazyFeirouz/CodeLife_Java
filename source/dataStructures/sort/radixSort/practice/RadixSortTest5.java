package dataStructures.sort.radixSort.practice;

import java.util.Arrays;

/**
 * @description: 练习5 - 基数排序 (9:39.86)
 * @author: Feirouz
 * @date: 2022-02-21 10:35
 */
public class RadixSortTest5 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,4,8,9,5,10};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 1. 获取最大数
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxVal < arr[i]) {
                maxVal = arr[i];
            }
        }
        // 2. 获取最大数的位数
        int maxValBin = (maxVal + "").length();
        // 3. 开始循环
        int[][] temp = new int[10][arr.length];
        int[] tempSize = new int[10];
        for (int i = 0; i < maxValBin; i++) {
            // 4. 循环存储
            for (int j = 0; j < arr.length; j++) {
                int curValBin = arr[j] / (int)Math.pow(10,i) % 10;
                temp[curValBin][tempSize[curValBin]] = arr[j];
                tempSize[curValBin]++;
            }
            // 5. 循环取出
            int index = 0;
            for (int j = 0; j < temp.length; j++) {
                for (int k = 0; k < tempSize[j]; k++) {
                    arr[index] = temp[j][k];
                    index++;
                }
                tempSize[j] = 0;    // 记得重置
            }

        }
    }

}
