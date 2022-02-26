package dataStructures.search.fibonacciSearch.practice;

import java.util.Arrays;

/**
 * @description: 练习4 - 斐波那契查找
 * @author: Feirouz
 * @date: 2022-02-24 16:20
 */
public class FibonacciSearchTest4 {
    public static void main(String[] args) {
        int[] arr = {0, 8, 9, 10, 89, 1000, 1234};
        int[] arr2 = {0,1234};
        int[] arr3 = {1234};

        int num = search(arr, 1000);
        System.out.println(num);

        int num2 = search(arr2, 1234);
        System.out.println(num2);

        int num3 = search(arr3, 1234);
        System.out.println(num3);
    }

    // 获取斐波那契数列
    public static int[] fib(int length) {
        if (length <= 0) {
            return null;
        } else {
            int[] fib = new int[length];
            fib[0] = 1;
            fib[1] = 1;
            for (int i = 2; i < fib.length; i++) {
                fib[i] = fib[i-1] + fib[i-2];
            }
            return fib;
        }
    }

    public static int search(int[] arr, int findVal) {
        // 创建对应数组
        int[] fib = fib(arr.length + 2);

        // 获取当前k值
        int k = 0;
        while (fib[k] <= arr.length - 1) {
            k++;
        }

        // 创建新的临时数组
        int[] temp = Arrays.copyOf(arr, fib[k]);
        for (int i = arr.length - 1; i < temp.length; i++) {
            temp[i] = arr[arr.length - 1];
        }

        // 开始循环
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            k = Math.max(1, k);
            int mid = left + fib[k-1] - 1;
            if (findVal < temp[mid]) {
                right = mid - 1;
                k--;
            } else if (findVal > temp[mid]) {
                left = mid + 1;
                k-=2;
            } else {
                return mid;
            }
        }

        // 出来了，没找到
        return -1;
    }

}
