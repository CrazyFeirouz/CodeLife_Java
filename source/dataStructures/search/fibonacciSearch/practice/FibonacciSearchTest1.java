package dataStructures.search.fibonacciSearch.practice;

import java.util.Arrays;

/**
 * @description:
 * @author: Feirouz
 * @date: 2022-02-15 15:09
 */
public class FibonacciSearchTest1 {
    public static void main(String[] args) {
        int[] arr = {0, 8, 9, 10, 89, 1000, 1234};
        int[] arr2 = {0,1234};
        int[] arr3 = {1234};

        int num = search(arr, 1234);
        System.out.println(num);

        int num2 = search(arr2, 1234);
        System.out.println(num2);

        int num3 = search(arr3, 1234);
        System.out.println(num3);
    }

    // 将一个数组转成斐波那契数列
    public static void tofib(int[] temp) {
        temp[0] = 1;
        if (temp.length > 1) {      // 解决数组长度为1的情况
            temp[1] = 1;
            for (int i = 2; i < temp.length; i++) {
                temp[i] = temp[i-1] + temp[i-2];
            }
        }
    }

    public static int search(int[] arr, int findVal) {
        // 1. 获取对应的斐波那契数列
        int[] fib = new int[arr.length+1];
        tofib(fib);
        // 2. 获取对应的k值
        int k = 0;
        while (arr.length - 1 >= fib[k]) {
            k++;
        }
        // 创建k值长度的数组，并把值赋过去
        int[] temp = Arrays.copyOf(arr, fib[k]);
        for (int i = arr.length - 1; i < temp.length; i++) {
            temp[i] = arr[arr.length - 1];
        }
        // 3. 获取对应mid值
        int left = 0;
        int right = temp.length -1;
        while (left <= right) {
            k = Math.max(k,1);
            int mid = left + fib[k - 1] - 1;
            if (findVal > temp[mid]) {   // 往后
                left = mid+1;
                k-=2;
            } else if (findVal < temp[mid]) {    // 往前
                right = mid-1;
                k--;
            } else {    // 找到了
                return Math.min(mid, right);
            }
        }
        return -1;
    }
}
