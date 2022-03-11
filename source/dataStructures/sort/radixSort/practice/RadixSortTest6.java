package dataStructures.sort.radixSort.practice;

import java.util.Arrays;

/**
 * @description: 练习6 - 基数排序
 * @author: Feirouz
 * @date: 2022-03-11 19:11
 */
public class RadixSortTest6 {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
//        sort(arr,0, arr.length - 1);
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 笑死， 你写了个快排，不是基数排序
//    public static void sort(int[] arr, int l, int r) {
//        if (l < r) {
//            int curVal = arr[l];
//            int temp = -1;
//            int i = l;
//            int j = r;
//            while (i < j) {
//                while (i < j && arr[j] >= curVal) {
//                    j--;
//                }
//                while (i < j && arr[i] <= curVal) {
//                    i++;
//                }
//                temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//            temp = arr[i];
//            arr[i] = curVal;
//            arr[l] = temp;
//
//            // 向左
//            sort(arr, l, i - 1);
//            // 向右
//            sort(arr, i + 1, r);
//        }
//    }

    public static void sort(int[] arr) {
        // 找最大值
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        // 取位数
        int maxBin = (maxVal + "").length();

        // 创桶
        int[][] temp = new int[10][arr.length];
        int[] tempSize = new int[10];

        // 遍历
        for (int i = 0; i < maxBin; i++) {
            // 取每一个位数放桶
            for (int j = 0; j < arr.length; j++) {
                int curBin = arr[j] / (int)Math.pow(10, i) % 10;        //!!! 粗心了哈，是用位数（i），不是用你的下标（j）
                temp[curBin][tempSize[curBin]] = arr[j];
                tempSize[curBin]++;
            }

            // 再按照顺序放回
            int index = 0;
            for (int j = 0; j < tempSize.length; j++) {
                for (int n = 0; n < tempSize[j]; n++) {
                    arr[index] = temp[j][n];
                    index++;
                }
                tempSize[j] = 0;
            }
        }
    }
}
