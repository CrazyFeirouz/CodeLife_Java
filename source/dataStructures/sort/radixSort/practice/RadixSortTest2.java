package dataStructures.sort.radixSort.practice;

import java.util.Arrays;

/**
 * @description: 练习2 - 基数排序
 * @author: Feirouz
 * @date: 2022-02-12 19:07
 */
public class RadixSortTest2 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,4,8,9,5,10};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 通过最大数判断现在需要的位数
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxVal){
                maxVal = arr[i];
            }
        }
        int bin = (maxVal + "").length();

        // 给十个桶
        int[][] temp = new int[10][arr.length];
        int[] tempCount = new int[10];

        // 开始循环
        for (int i = 0; i < bin; i++) {
            for (int j = 0; j < arr.length; j++) {
                int curBinVal = arr[j] / (int)Math.pow(10,i) % 10;
                temp[curBinVal][tempCount[curBinVal]] = arr[j];
                tempCount[curBinVal]++;
            }
            // 这里摆完一组了，按顺序取回
            int index = 0;
            for (int j = 0; j < temp.length; j++) {
                for (int k = 0; k < tempCount[j]; k++) {
                    arr[index] = temp[j][k];
                    index++;
                }
                tempCount[j] = 0;       // 记得清零
            }
        }
    }
}
