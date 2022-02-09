package dataStructures.sort.shellSortSwap.practice;

import java.util.Arrays;

/**
 * @description: 练习 - 希尔排序 - 交换法 - 2
 * @author: Feirouz
 * @date: 2022-02-09 12:59
 */
public class ShellSort1Test2 {
    public static void main(String[] args) {
        int[] arr = {-9,-2,1,0,3,8,12,78,-51,3};

        sort(arr);
//        sort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 按照老师思路的希尔排序 交换法
     * @param arr
     */
    public static void sort(int[] arr) {
        int temp = -1;
        for(int gap = arr.length/2; gap > 0; gap /= 2) {
            for(int i = gap; i < arr.length; i++)  {
                for(int j = i - gap; j >= 0; j -= gap){
                    if(arr[j] > arr[j+gap]) {
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * 将上述方法第二层逆序得出的希尔排序-交换法
     * @param arr
     */
    public static void sort2(int[] arr) {
        int temp = -1;
        for(int gap = arr.length/2; gap > 0; gap /= 2) {
            for (int i = arr.length; i > gap; i--) {
                for (int j = i - 1; j >= gap; j -= gap) {
                    if(arr[j-gap] > arr[j]){
                        temp = arr[j-gap];
                        arr[j-gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }



}
