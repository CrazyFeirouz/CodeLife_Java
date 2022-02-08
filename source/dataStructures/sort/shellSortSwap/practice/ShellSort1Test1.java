package dataStructures.sort.shellSortSwap.practice;

import java.util.Arrays;

/**
 * @description: 希尔排序 - 交换法 - 1
 * @author: Feirouz
 * @date: 2022-02-08 12:46
 */
public class ShellSort1Test1 {
    public static void main(String[] args) {
        int[] arr = {-9, 1, 2, 9, 5, -6, -4, 0, 3, 8};  //10
        sortDismantle(arr);
//        sort(arr);
//        System.out.println(Arrays.toString(arr));

        // 尝试优化版本 - 失败告终
        // 尝试方法为 ： 冒泡排序的优化方式
        // 问题 ： 希尔排序是分组排序，若一组中顺序无误中断了，会导致另一组的比较缺失。
        int[] arr2 = {-9, 1, 2, 9, 5, -6, -4, 0, 3, 8};  //10
        sortDismantle2(arr2);
    }

    /**
     * 老师版本
     * @param arr
     */
    public static void sort(int[] arr) {
        int temp = -1;
        for(int gap = arr.length; gap > 0; gap /= 2){
            for(int i = gap; i < arr.length; i++){
                for(int j = i - gap; j >= 0; j-=gap){
                    if(arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
    }

    /**
     * 老师版本 分解
     * @param arr
     */
    public static void sortDismantle(int[] arr) {
        System.out.println("==============老师版本================");
        int temp = -1;
        // 1轮
        int gap = arr.length/2;                         // 5
        for(int i = gap; i < arr.length; i++){          // 5-9:5轮
            for(int j = i-gap; j >= 0; j -= gap){       // 0,1,2,3,4
                if(arr[j] > arr[j+gap]){
                    temp = arr[j+gap];
                    arr[j+gap] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("第一轮结果 - " + Arrays.toString(arr));
        // 2轮
        gap /= 2;                                       // 2
        for(int i = gap; i < arr.length; i++) {         // 2-9:8轮
            for(int j = i-gap; j >= 0; j-=gap) {        // [0],[1],[2,0],[3,1],[4,2,0],[5,3,1],[6,4,2,0],[7,5,3,1]
                if(arr[j] > arr[j+gap]) {
                    temp = arr[j+gap];
                    arr[j+gap] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("第二轮结果 - " + Arrays.toString(arr));
        gap /= 2;                                       // 1
        for(int i = gap; i < arr.length; i++) {         // 1-9:10轮
            for(int j = i-gap; j >= 0; j-=gap) {        // [0],[1,0],[2,1,0],[3,2,1,0]... (纯冒泡)
                if(arr[j] > arr[j+gap]) {
                    temp = arr[j+gap];
                    arr[j+gap] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("第三轮结果 - " + Arrays.toString(arr));
    }

    /**
     * 个人根据之前冒泡排序优化版本 分解（失败）
     * @param arr
     */
    public static void sortDismantle2(int[] arr) {
        // 修改成这种版本后，就可以使用之前冒泡的优化方式
        // 因为原版是从小依次递增比较。 这种修改后的方式是从大递减依次比较。
        // 也就是若整个比较过程都没有触发交换，则说明该序列是有序的。
        // 失败 - 因为整个数组在交换时， 是按照分组交换的， 如果这样中断， 可能会导致另一组并没有被比较到从而导致 排序错误
        boolean flag = false;
        System.out.println("==============修改版本================");
        int temp = -1;
        int gap = arr.length/2;                         // 5
        for(int i = arr.length; i > gap; i--) {         // 10-6: 5轮
            for(int j = i - 1; j >= gap; j -= gap){     // [9],[8],[7],[6],[5]
                if(arr[j] < arr[j-gap]){
                    temp = arr[j-gap];
                    arr[j-gap] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if(flag) {
                flag = false;
                break;
            }
        }
        System.out.println("第一轮结果 - " + Arrays.toString(arr));
        gap /= 2;                                       // 2
        for(int i = arr.length; i > gap; i--) {         // 10-3: 8轮
            for(int j = i - 1; j >= gap; j -= gap){     // [9,7,5,3],[8,6,4,2],[7,5,3],[6,4,2],[5,3],[4,2],[3],[2]
                if(arr[j] < arr[j-gap]){
                    temp = arr[j-gap];
                    arr[j-gap] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if(flag) {
                flag = false;
                break;
            }
        }
        System.out.println("第二轮结果 - " + Arrays.toString(arr));
        gap /= 2;                                       // 1
        for(int i = arr.length; i > gap; i--) {         // 10-2: 9轮
            for(int j = i - 1; j >= gap; j -= gap){     // [9,8,7,6,5,4,3,2,1]
                if(arr[j] < arr[j-gap]){
                    temp = arr[j-gap];
                    arr[j-gap] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if(flag) {
                flag = false;
                break;
            }
        }
        System.out.println("第三轮结果 - " + Arrays.toString(arr));
    }
}
