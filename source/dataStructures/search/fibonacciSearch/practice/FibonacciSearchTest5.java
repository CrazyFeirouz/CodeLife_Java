package dataStructures.search.fibonacciSearch.practice;

import java.util.Arrays;

/**
 * @description: 练习5 - 斐波那契查找
 * @author: Feirouz
 * @date: 2022-03-09 18:21
 */
public class FibonacciSearchTest5 {
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

    public static void fib(int[] fib) {
        if (fib.length > 0) {
            fib[0] = 1;
            if (fib.length > 1) {
                fib[1] = 1;
                for (int i = 2; i < fib.length; i++) {
                    fib[i] = fib[i-1] + fib[i-2];
                }
            }
        }
    }

    public static int search(int[] arr, int findVal) {
        // 创建对应数组
        int[] fib = new int[arr.length + 2];
        fib(fib);

        // 找到对应的k
        int k = 0;
        while (fib[k] - 1 <= arr.length - 1) {
            k++;
        }

        // 创建新的数组
        int[] temp = Arrays.copyOf(arr, fib[k]);

        // 开始填充
        for (int i = arr.length; i < temp.length; i++) {
            temp[i] = arr[arr.length - 1];
        }

        int low = 0;
        int high = arr.length - 1;
        int mid = -1;
        // 开始查找
        while (low <= high) {
            k = Math.max(k, 1);
            mid = low + fib[k - 1] - 1;
            if (temp[mid] < findVal) {
                low = mid + 1;
                k-=2;
            } else if (findVal < temp[mid]) {
                high = mid - 1;
                k--;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
