package dataStructures.search.fibonacciSearch.practice;

import java.util.Arrays;

/**
 * @description:
 * @author: Feirouz
 * @date: 2022-02-16 16:09
 */
public class FibonacciSearchTest2 {
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

    public static void fib(int[] temp) {
        if (temp.length > 0) {
            temp[0] = 1;
            if (temp.length > 1) {
                temp[1] = 1;
                for (int i = 2; i < temp.length; i++) {
                    temp[i] = temp[i-1] + temp[i-2];
                }
            }
        }
    }

    public static int search(int[] arr, int findVal) {
        // 1. 创建一个大小比数组大1的斐波那契数列
        int[] fib = new int[arr.length+1];
        fib(fib);

        int k  = 0;
        // 2. 计算当前的k值
        while (arr.length - 1 > fib[k] - 1) {
            k++;
        }

        // 3. 创建一个临时数组，大小要满足 fib[k+1]
        int[] temp = Arrays.copyOf(arr, fib[k]);
        for (int i = arr.length - 1; i < temp.length; i++) {
            temp[i] = arr[arr.length - 1];
        }

        // 4. 循环查找
        int left = 0;
        int right = temp.length - 1;
        while (left <= right) {
            k = Math.max(k, 1);
            int mid = left + fib[k-1] - 1;
            if (findVal < temp[mid]) {
                right = mid - 1;
                k--;
            } else if (findVal > temp[mid]) {
                left = mid + 1;
                k-=2;
            } else {
                return Math.min(mid,right);
            }
        }

        // 找不到
        return -1;



    }
}
