package dataStructures.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 希尔排序 - 插入采用交换法
 * @author: Feirouz
 * @date: 2022-01-25 12:26
 */
public class ShellSort1 {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};

//        shellSortDismantle(arr);
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 测试 交换法 的希尔排序速度
     */
    @Test
    public void test1() {
        // 测试一下插入排序的速度，给8w个数据，测试
        // 由于使用的交换法，效率很低
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
     * 交换法的希尔排序
     * @param arr 要排序的数组
     * 效率不高，最后一次循环相当于一次普通的希尔排序了
     */
    public static void sort(int[] arr) {
        int temp = 0;
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; i++){
                for (int j = i - gap; j >= 0; j -= gap){
                    if(arr[j] > arr[j+gap]) {
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
    }

    // 使用逐步推导的方式来编写希尔排序
    public static void shellSortDismantle(int[] arr) {
        int temp = 0;
        // 第一轮
        // 10个数据分成了5组
        for(int i = 5; i < arr.length; i++) {       // [5],[6],[7],[8],[9]
            // 遍历各组中所有的元素（共5组，每组2个元素），步长5
            for(int j = i - 5; j >= 0; j -= 5) {    // [0],[1],[2],[3],[4]
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if(arr[j] > arr[j+5]) {
                    temp = arr[j];
                    arr[j] = arr[j+5];
                    arr[j+5] = temp;
                }
            }
        }
        System.out.println("希尔排序第一轮后 - " + Arrays.toString(arr));

        // 第二轮
        // 10个数据分成了5/2 = 2组
        for(int i = 2; i < arr.length; i++) {       // [2],[3],[4],[5],[6],[7],[8],[9]
            // 遍历各组中所有的元素（共2组，每组2个元素），步长5
            for(int j = i - 2; j >= 0; j -= 2) {    // [0],[1],[2,0],[3,1],[4,2,0],[5,3,1],[6,4,2,0],[7,5,3,1]
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if(arr[j] > arr[j+2]) {
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }
        System.out.println("希尔排序第二轮后 - " + Arrays.toString(arr));

        // 第三轮
        // 10个数据分成了5/2/2 = 1组
        for(int i = 1; i < arr.length; i++) {       // [1],[2],[3],[4],[5],[6],[7],[8],[9]
            // 遍历各组中所有的元素（共2组，每组2个元素），步长5
            for(int j = i - 1; j >= 0; j -= 1) {    // [0],[1,0],[2,1,0]...
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if(arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("希尔排序第三轮后 - " + Arrays.toString(arr));
    }
}
