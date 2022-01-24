package dataStructures.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 选择排序
 * @author: Feirouz
 * @date: 2022-01-24 20:19
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};

        System.out.println(Arrays.toString(arr));

        // 拆开每步
//        sortDismantle(arr);

        System.out.println("使用选择排序排序arr");
        sort(arr);
        System.out.println("排序后 - " + Arrays.toString(arr));
    }

    /**
     * 测试选择排序速度
     */
    @Test
    public void test1() {
        // 测试一下选择排序的速度O(n²)，给8w个数据，测试
        // 比冒泡快很多，我这测试大概快了3-5倍（具体原因就是交换的次数减少了）
        // 1. 创建一个80000个随机数的数组
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 8000000);    // 生成[0,8000000)的数
        }

        long starTime = System.currentTimeMillis();

        sort(arr);

        long endTime = System.currentTimeMillis();
        System.out.println("使用时间 - " + (endTime-starTime) + " ms");
    }

    /**
     * 选择排序 - O(n²)
     * @param arr 排序的数组
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            int minValue = arr[minIndex];
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minValue){
                    minIndex = j;
                    minValue = arr[j];
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 为了容易理解，我们把选择排序的演变过程给展示出来
     * @param arr 需要排序的数组
     */
    public static void sortDismantle(int[] arr) {
        // 使用逐步推导的方式来 讲解选择排序
        // 第一轮排序（先把最小的放在第一位）
        int minIndex = 0;
        int minValue = arr[minIndex];
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] < minValue){
                minIndex = i;
                minValue = arr[i];
            }
        }
        swap(arr, 0, minIndex);
        System.out.println("第一轮排序后 - " + Arrays.toString(arr));

        // 第二轮排序
        minIndex = 0 + 1;
        minValue = arr[minIndex];
        for(int i = 1 + 1; i < arr.length; i++) {
            if (arr[i] < minValue){
                minIndex = i;
                minValue = arr[i];
            }
        }
        swap(arr, 0 + 1, minIndex);
        System.out.println("第二轮排序后 - " + Arrays.toString(arr));

        // 第二轮排序
        minIndex = 0 + 1 + 1;
        minValue = arr[minIndex];
        for(int i = 1 + 1 + 1; i < arr.length; i++) {
            if (arr[i] < minValue){
                minIndex = i;
                minValue = arr[i];
            }
        }
        swap(arr, 0 + 1 + 1, minIndex);
        System.out.println("第三轮排序后 - " + Arrays.toString(arr));

        /*
        该方法运行结果如下：
            第一轮排序后 - [1, 34, 119, 101]
            第二轮排序后 - [1, 34, 119, 101]
            第三轮排序后 - [1, 34, 101, 119]
         */
    }

    /**
     * 交换
     * @param arr 需要交换的数组
     * @param y 需要交换的下标1
     * @param x 需要交换的下标2
     */
    public static void swap(int[] arr, int y, int x){
        int temp = arr[y];
        arr[y] = arr[x];
        arr[x] = temp;
    }
}
