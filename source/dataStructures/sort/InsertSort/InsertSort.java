package dataStructures.sort.InsertSort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 插入排序
 * @author: Feirouz
 * @date: 2022-01-24 21:21
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};

        // 拆开每步
//        sortDismantle(arr);

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 测试插入排序速度
     */
    @Test
    public void test1() {
        // 测试一下插入排序的速度，给8w个数据，测试 -- 548ms
        // 正常的版本应该是两层for，且每次都是交换。有点像反向的冒泡
        // 比之前的选择排序又快了2-4倍左右（看了下弹幕大部分和我一致，但老师是和选择同速，也有少部分选择更快）
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
     * 插入排序 - O(n²)
     * @param arr 排序的数组
     * {101, 34, 119, 1} => [1, 34, 101, 119]
     */
    public static void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i-1;
            while(insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertVal;
        }
    }

    /**
     * 为了容易理解，我们把插入排序的演变过程给展示出来
     * @param arr 需要排序的数组
     */
    public static void sortDismantle(int[] arr){
        // 使用逐步推导的方式来讲解，便于理解
        // 第一轮 {101, 34, 119, 1} => {34, 101, 119, 1}
        // 定义待插入的数
        int insertVal = arr[1]; // 34
        int insertIndex = 1 - 1;    // 即 arr[1] 的前面这个数的下标

        // 给insertVal找到插入的位置
        // 说明
        // 1. insertIndex >= 0 保证在给 insertVal 找插入位置，不越界
        // 2. insertVal < arr[insertIndex] 待插入的数，还没找到插入的位置 - 34 < 101
        // 3. 需要将 arr[insertIndex] 后移
        while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];    // arr[1] = 101
            insertIndex--;                              // -1
        }
        // 当退出while循环时，说明插入的位置找到，insertIndex + 1
        arr[insertIndex + 1] = insertVal;

        System.out.println("第一趟排序后的数组 - " + Arrays.toString(arr));

        // 第二轮
        // 定义待插入的数
        insertVal = arr[2]; // 34
        insertIndex = 2 - 1;    // 即 arr[1] 的前面这个数的下标

        while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];    // arr[1] = 101
            insertIndex--;                              // -1
        }
        arr[insertIndex + 1] = insertVal;

        System.out.println("第二趟排序后的数组 - " + Arrays.toString(arr));

        // 第三轮
        // 定义待插入的数
        insertVal = arr[3]; // 34
        insertIndex = 3 - 1;    // 即 arr[1] 的前面这个数的下标

        while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];    // arr[1] = 101
            insertIndex--;                              // -1
        }
        arr[insertIndex + 1] = insertVal;

        System.out.println("第三趟排序后的数组 - " + Arrays.toString(arr));

        /*
        运行结果：
            第一趟排序后的数组 - [34, 101, 119, 1]
            第二趟排序后的数组 - [34, 101, 119, 1]
            第三趟排序后的数组 - [1, 34, 101, 119]
         */
    }
}
