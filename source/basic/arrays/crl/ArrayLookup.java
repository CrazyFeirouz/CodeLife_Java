package basic.arrays.crl;

/**
 * -*- coding: utf-8 -*-
 * @Author Feirouz
 * @Date 2021/4/19 21:57
 * @Des 数组查找
 */

public class ArrayLookup {
    public static void main(String[] args) {
        // 注意点：若用二分法，那数组要求为有序数组，并且为数值类型
        int[] array = new int[]{-10, -1, 2, 13, 24, 25, 36, 57, 88, 91, 105};

        //线性查找
//        int result = linearSearch(array, 25);

        //二分法查找
        int result = binarySearch(array, 25);

        if (result != -1){
            System.out.println("索引为：" + result + "，值为：" + array[result]);
        }else {
            System.out.println("查找无结果");
        }
    }

    /**
     * 二分法查找
     * @param array 查找数组 - 前提要求；查找数组为有序数值数组
     * @param findNum 需要查找的数
     * @return 查找出:返回索引，未查找出：返回-1
     */
    private static int binarySearch(int[] array, int findNum) {
        int head = 0;       //初始的首索引
        int end = array.length-1;   //初始的尾索引
        int middle;

        while(head <= end){
            middle = (head = end) / 2;
            if (array[middle] == findNum) {
                return middle;
            }else if(array[middle] > findNum) {     //搜索数较小，范围缩减到 head----middle-1
                end = middle - 1;
            }else {
                head = middle + 1;                  //搜索数较大，范围缩减到 middle+1----end
            }
        }
        return -1;
    }

    /**
     * 线性查找
     * @param array 需要查找的数组
     * @param findNum 需要查找的数
     * @return 查找出:返回索引，未查找出：返回-1
     */
    private static int linearSearch(int[] array, int findNum) {
        for (int i = 0; i < array.length; i++) {    //遍历查找即可
            if (array[i] == findNum){
                return i;
            }
        }
        return -1;
    }
}
