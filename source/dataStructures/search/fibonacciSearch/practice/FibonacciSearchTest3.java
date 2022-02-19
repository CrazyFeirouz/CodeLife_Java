package dataStructures.search.fibonacciSearch.practice;

import java.util.Arrays;

/**
 * @description: 练习3 - 斐波那契查找 (10:22)
 * @author: Feirouz
 * @date: 2022-02-19 13:20
 */
public class FibonacciSearchTest3 {
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

    public static int[] fib(int size) {
        if (size > 0) {
            int[] fib = new int[size];
            fib[0] = 1;
            if (size > 1) {
                fib[1] = 1;
                for (int i = 2; i < size; i++) {
                    fib[i] = fib[i-1] +fib[i-2];
                }
            }
            return fib;
        }
        return null;
    }

    public static int search(int[] arr, int findVal) {
        // 用你的数组大小+1 创建斐波那契数列
        int[] fib = fib(arr.length + 2);

        // 找k值
        int k = 0;
        while (arr.length > fib[k] - 1) {
            k++;
        }

        // 找到k值，创建临时数组比较
        int[] temp = Arrays.copyOf(arr, fib[k]);
        // 把后面的数放置为最大值
        for (int i = arr.length - 1; i < temp.length; i++) {
            temp[i] = arr[arr.length - 1];
        }

        // 开始查找
        int i = 0;
        int j = arr.length;
        while (i <= j) {
            k = Math.max(k, 1);
            int mid = i + (fib[k - 1] - 1);
            if (findVal < temp[mid]) {
                j = mid - 1;
                k--;
            } else if (findVal > temp[mid]) {
                i = mid + 1;
                k-=2;
            } else {
                return Math.min(mid, j);
            }
        }

        return -1;

    }
}
