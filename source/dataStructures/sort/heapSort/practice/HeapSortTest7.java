package dataStructures.sort.heapSort.practice;

import java.util.Arrays;

/**
 * @description: 练习7 - 堆排序
 * @author: Feirouz
 * @date: 2022-04-21 23:01
 */
public class HeapSortTest7 {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, 10, 7, 3, 1, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    // 笑死， 你怎么在堆排序里写基数排序？
//    public static void sort(int[] arr) {
//        int maxVal = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] > maxVal) {
//                maxVal = arr[i];
//            }
//        }
//        int maxValBin = (maxVal + "").length();
//
//        int[][] temp = new int[10][arr.length];
//        int[] tempCount = new int[10];
//        for (int i = 0; i < maxValBin; i++) {
//            // 先存进桶
//            for (int j = 0; j < arr.length; j++) {
//                int curBinVal = arr[j] / (int)Math.pow(10, i) % 10;
//                temp[curBinVal][tempCount[curBinVal]] = arr[j];
//                tempCount[curBinVal]++;
//            }
//            // 按顺序取出
//            int index = 0;
//            for (int j = 0; j < tempCount.length; j++) {
//                for (int k = 0; k < tempCount[j]; k++) {
//                    arr[index] = temp[j][k];
//                    index++;
//                }
//                tempCount[j] = 0;
//            }
//        }
//    }

    public static void sort(int[] arr) {
        // 先总体转大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            toBigTopHeap(arr, i, arr.length);
        }
        // 开始沉，局部调整
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            toBigTopHeap(arr, 0, i);
        }
    }

    public static void toBigTopHeap(int[] arr, int i, int len) {
        int temp = -1;
        int curVal = arr[i];
        for (int j = i * 2 + 1; j < len; j = j * 2 + 1) {
            if (j + 1 < len && arr[j + 1] > arr[j]) {
                j++;
            }
            if (arr[j] > curVal) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = curVal;
    }
}
