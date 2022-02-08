package dataStructures.sort.QuickSort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 快速排序
 * @author: Feirouz
 * @date: 2022-02-07 17:29
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70};

        sort(arr, 0 , arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 测试快速排序速度
     */
    @Test
    public void test1() {
        // 测试一下插入排序的速度，给8w个数据，测试 -- 26ms
        // 1. 创建一个80000个随机数的数组
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 8000000);    // 生成[0,8000000)的数
        }

        long starTime = System.currentTimeMillis();

        sort(arr,0, arr.length-1);

        long endTime = System.currentTimeMillis();
        System.out.println("使用时间 - " + (endTime-starTime) + " ms");
    }

    public static void sort(int[] arr, int left, int right){
        int l = left;                   // 左下标
        int r = right;                  // 右下标
        int pivot = arr[(l+r)/2];       // 中轴值

        int temp = -1;                  // 交换值

        // while 目的： 比pivot小的值放在他的左边，比他大的值放在右边。
        while(l < r) {
            // 在pivot的左边一直找，找到一个大于等于pivot的值，才退出
            while(arr[l] < pivot){
                l++;
            }

            // 在pivot的右边一直找，找到一个小于等于pivot的值，才退出
            while(arr[r] > pivot){
                r--;
            }

            // 若成立，说明pivot左右两边的值已经按照，左小右大排布好
            if(l >= r){
                break;
            }

            // 交换
            temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;

            // 如果交换完后，发现arr[l] = pivot值， 则 r前移
            if(arr[l] == pivot){
                r--;
            }
            // 如果交换完后，发现arr[l] = pivot值， 则 l后移
            if(arr[r] == pivot){
                l++;
            }
        }

        // 如果 l==r，必须l++，r--，否则会出现栈溢出
        // 通过该操作可以使 下面两个递归的判断为false
        if(l == r){
            l++;
            r--;
        }

        // 向左递归
        if(left < r){
            sort(arr, left, r);
        }

        // 向右递归
        if(right > l){
            sort(arr, l, right);
        }
    }
}
