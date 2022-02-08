package dataStructures.sort.ShellSortInsert;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 希尔排序 - 插入采用移位法
 * @author: Feirouz
 * @date: 2022-01-26 12:21
 */
public class ShellSort2 {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 测试 插入法 的希尔排序速度
     */
    @Test
    public void test1() {
        // 测试一下插入排序的速度，给8w个数据，测试 -- 15ms
        // 快的有点起飞，比插入快了50倍左右
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
     * 移位法的希尔排序
     * @param arr 要排序的数组
     */
    public static void sort(int[] arr){
        int minVal = -1;
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {      // [5]... [2], [1]
            // 从第gap个元素开始逐个对其所在的组进行直接插入
            for(int i = gap; i < arr.length; i++) {             // [5]... [2], [3], [4]
                int j = i - gap;                                // [0]... [0], [1], [2,0]
                minVal = arr[j + gap];
                while (j >= 0 && minVal < arr[j]) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = minVal;
            }
        }
    }
}
