package dataStructures.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description: 冒泡排序
 * @author: Feirouz
 * @date: 2022-01-24 16:30
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};

        // 拆开每步
//        sortDismantle(arr);

        sort(arr);
    }

    /**
     * 冒泡排序 - O(n²)
     * @param arr
     */
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - i - 1; j++){
                if (arr[j] > arr[j+1]){
                    swap(arr, j);
                }
            }
        }
        System.out.println("排序后的数组 - " + Arrays.toString(arr));
    }

    /**
     * 为了容易理解，我们把冒泡排序的演变过程给展示出来
     * @param arr 需要排序的数组
     */
    public static void sortDismantle(int[] arr){
        // 第一趟排序（将最大的书排在最后）
        for(int j = 0; j < arr.length - 1; j++) {
            // 如果前面的数比后面的数大，就交换
            if(arr[j] > arr[j+1]){
                swap(arr, j);
            }
        }
        System.out.println("第一趟排序后的数组 - " + Arrays.toString(arr));

        // 第二趟排序
        for(int j = 0; j < arr.length - 1 - 1; j++) {
            // 如果前面的数比后面的数大，就交换
            if(arr[j] > arr[j+1]){
                swap(arr, j);
            }
        }
        System.out.println("第二趟排序后的数组 - " + Arrays.toString(arr));

        // 第三趟排序
        for(int j = 0; j < arr.length - 1 - 1 - 1; j++) {
            // 如果前面的数比后面的数大，就交换
            if(arr[j] > arr[j+1]){
                swap(arr, j);
            }
        }
        System.out.println("第三趟排序后的数组 - " + Arrays.toString(arr));

        // 第四趟排序
        for(int j = 0; j < arr.length - 1 - 1 - 1 - 1; j++) {
            // 如果前面的数比后面的数大，就交换
            if(arr[j] > arr[j+1]){
                swap(arr, j);
            }
        }
        System.out.println("第四趟排序后的数组 - " + Arrays.toString(arr));

        /*
        该方法 运行结果
            第一趟排序后的数组 - [3, -1, 9, -2, 10]
            第二趟排序后的数组 - [-1, 3, -2, 9, 10]
            第三趟排序后的数组 - [-1, -2, 3, 9, 10]
            第四趟排序后的数组 - [-2, -1, 3, 9, 10]
         */
    }

    /**
     * 交换
     * @param arr 需要交换的数组
     * @param j 交换的下标
     */
    public static void swap(int[] arr, int j){
        int temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
    }

}
