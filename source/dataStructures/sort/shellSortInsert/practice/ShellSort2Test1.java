package dataStructures.sort.shellSortInsert.practice;

import java.util.Arrays;

/**
 * @description: 练习 - 希尔排序 - 插入法
 * @author: Feirouz
 * @date: 2022-02-09 13:30
 */
public class ShellSort2Test1 {
    public static void main(String[] args) {
        int[] arr = {-5,1,0,2,5,4,6,3,-12,15};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        int minVal = -1;
        // 前面部分是和希尔排序（交换法一致的）
        for(int gap = arr.length / 2; gap > 0; gap /= 2) {      //[5],[2],[1]
            for(int i = gap; i < arr.length; i++) {             //[5,6,7,8,9],[2,3,4,5,6,7,8,9],[1,2,3,4,5,6,7,8,9]
                // 在这里开始，就要用插入法了
                int j = i - gap;                                //[0,1,2,3,4],[0,(3,1),(4,2,0)...],[(1,0),(2,1,0)...]
                minVal = arr[j+gap];                // 让后面一个数的值为最小值
                while (j >= 0 && minVal < arr[j]) { // 判断 当前的数是否 小于最小值
                    arr[j+gap] = arr[j];            // 满足，则后移
                    j-=gap;                         // j--
                }
                arr[j+gap] = minVal;                // 让前面的数为最小值
            }
        }
    }
}
