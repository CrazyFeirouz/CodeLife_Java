package dataStructures.sort;

import org.junit.Test;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * @description: 冒泡排序
 * @author: Feirouz
 * @date: 2022-01-24 16:30
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};
        int arr2[] = {3, -1, 6, 6, 8};

        // 拆开每步
//        sortDismantle(arr);

        System.out.println("使用冒泡排序排序arr");
        sort(arr);
        System.out.println("排序后 - " + Arrays.toString(arr));

        System.out.println("使用优化后的冒泡排序排序arr2");
        sortOptimize(arr2);
        System.out.println("排序后 - " + Arrays.toString(arr2));
    }

    /**
     * 测试冒泡排序速度
     */
    @Test
    public void test1() {
        // 测试一下冒泡排序的速度O(n²)，给8w个数据，测试
        // 1. 创建一个80000个随机数的数组
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 8000000);    // 生成[0,8000000)的数
        }

        long starTime = System.currentTimeMillis();

//        sort(arr);
        sortOptimize(arr);

        long endTime = System.currentTimeMillis();
        System.out.println("使用时间 - " + (endTime-starTime) + " ms");
    }

    /**
     * 冒泡排序优化
     * @param arr 排序的数组
     * 当一趟排序中，一次交换都没有发生过 => 已经排序完毕，可以提前结束
     */
    public static void sortOptimize(int[] arr){
        boolean flag = false;       // 标识变量，标识是否进行过交换
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - i - 1; j++){
                if (arr[j] > arr[j+1]){
                    swap(arr, j);
                    flag = true;
                }
            }

//            System.out.println("第" + (i+1) + "趟排序后的数组 - " + Arrays.toString(arr));

            if (!flag){ // 在一趟排序中，一次交换都没有发生过
                break;
            }else { // 发生过交换，重置, 进行下次判断
                flag = false;
            }
        }
    }

    /**
     * 冒泡排序 - O(n²)
     * @param arr 排序的数组
     */
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - i - 1; j++){
                if (arr[j] > arr[j+1]){
                    swap(arr, j);
                }
            }
        }
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
