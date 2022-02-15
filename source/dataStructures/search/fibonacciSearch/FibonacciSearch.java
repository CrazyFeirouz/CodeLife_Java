package dataStructures.search.fibonacciSearch;

import java.util.Arrays;

/**
 * @description: 斐波那契查找
 * @author: Feirouz
 * @date: 2022-02-14 20:03
 */

// 解决了老师长度为1时越界的情况
// 但是说实话，这个算法说实话，嘶，太少见了...好像没见人用过，你练个大概了解的程度就行。
public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {0, 8, 9, 10, 89, 1000, 1234};
        int[] arr2 = {0,1234};
        int[] arr3 = {1234};

        int num = search(arr, 1234);
        int num2 = search(arr2, 1234);
        int num3 = search(arr3, 1234);

        System.out.println(num);
        System.out.println(num2);
        System.out.println(num3);
    }

    // 因为后面我们 mid = low + F(k-1) - 1，需要使用到斐波那契数列，因此我们需要先获取到一个斐波那契数列
    // 非递归方式 得到 一个 斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    /**
     * 编写斐波那契查找算法 - 非递归
     * @param arr 数组
     * @param key 查找的值
     * @return 下标；若没有，反回-1
     */
    public static int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;                  // 表示斐波那契分割数值的下标
        int mid = 0;                // 存放mid值
        int[] f = fib();            // 获取到斐波那契数列

        // 获取到 斐波那契分割数值 的 下标
        while (high > f[k] - 1) {
            k++;
        }
        // 因为 f[k] 值 可能大于 数组长度，因此我们需要使用 Arrays类， 构造一个 新的数组，temp[]
        // 不足的部分会使用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        // 实际上需求使用a数组最后的数填充temp
        // 比如： temp = {1, 8, 10, 89, 1000, 1234, 0, 0, 0} => {1, 8, 10, 89, 1000, 1234, 1234, 1234, 1234}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        // 使用while来循环处理，找到我们的数
        while (low <= high) {       // 只要这个条件满足，就可以找
            k = Math.max(k, 1);
            mid = low + f[k-1] - 1;
            if (key < temp[mid]) {  // 我们应该向数组的 左边 部分查找
                high = mid - 1;
                // 为什么是 k--;
                // 说明
                // 1. 全部元素 = 前面的元素 + 后边的元素
                // 2. f[k] = f[k-1] + f[k-2]
                // 因为 前面有 f[k-1] 个元素， 所以可以继续拆分 f[k-1] = f[k-2] + f[k-3]
                // 即 在 f[k-1] 的前面 继续查找 k--
                // 即下次循环 mid = low + f[(k-1)-1] - 1;
                k--;
            } else if (key > temp[mid]) {     // 我们应该向数组的 右边 部分查找
                low = mid + 1;
                // 为什么是 k-=2
                // 说明
                // 1. 全部元素 = 前面的元素 + 后边的元素
                // 2. f[k] = f[k-1] + f[k-2]
                // 3. 因为后面我们有 f[k-2] ，所以可以继续拆分，f[k-2] = f[k-3] + f[k-4]
                // 即 在 f[k-2] 的前面 继续查找 k-=2
                // 即下次循环 mid = low + f[(k-2)-1] - 1
                k -= 2;
            } else {    // 找到
                // 需要确定，返回的是哪个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        // 没找到
        return -1;
    }
}
