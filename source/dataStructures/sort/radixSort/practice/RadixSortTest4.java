package dataStructures.sort.radixSort.practice;

import java.util.Arrays;

/**
 * @description: 基数排序
 * @author: Feirouz
 * @date: 2022-02-15 13:56
 */
public class RadixSortTest4 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,4,8,9,5,10};

        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right){
        // 获取最大值
        int maxVal = arr[0];
        for (int k = 2; k < arr.length; k++) {
            if (arr[k] > maxVal) {
                maxVal = arr[k];
            }
        }
        // 获取最大值位数
        int maxBin = (maxVal+"").length();

        int i = left;
        int j = right;
        int [][] temp = new int[10][arr.length];
        int [] tempCount = new int[10];

        // 开始循环
        for (int k = 0; k < maxBin; k++) {
            // 挨个挨个按照当前位数存
            for (int n = 0; n < arr.length; n++) {
                int curBin = arr[n] / (int)Math.pow(10,k) % 10;
                temp[curBin][tempCount[curBin]] = arr[n];
                tempCount[curBin]++;
            }
            // 存完再取出来
            int index = 0;
            for (int n = 0; n < temp.length; n++) {
                for (int m = 0; m < tempCount[n]; m++) {
                    arr[index] = temp[n][m];
                    index++;
                }
                // 取完重置
                tempCount[n] = 0;
            }
        }

    }
}
