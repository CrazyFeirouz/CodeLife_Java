package dataStructures.sort.mergeSort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 归并排序
 * @author: Feirouz
 * @date: 2022-02-08 15:29
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];           // 归并排序需要一个额外的空间
        sort(arr, 0, arr.length-1, temp);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 测试 交换法 的归并排序速度
     */
    @Test
    public void test1() {
        // 使用时间 - 14 ms
        // 合并（交换）次数 为 n-1 次， 若有8w个数据，则交换次数为 8w-1 次
        int[] arr = new int[80000];
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 8000000);    // 生成[0,8000000)的数
        }

        long starTime = System.currentTimeMillis();

        sort(arr, 0, arr.length-1, temp);

        long endTime = System.currentTimeMillis();
        System.out.println("使用时间 - " + (endTime-starTime) + " ms");
    }

    // 使用逐步推导的方式来编写归并排序
    public static void sort(int[] arr, int left, int right, int[] temp) {
        if(left < right) {
            int mid = (left + right)/2;         // 中间索引
            // 向左递归进行分解
            sort(arr, left, mid, temp);
            // 向右递归进行分解
            sort(arr, mid + 1, right, temp);
            // 到合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并的方法
     * @param arr 排序的数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;       // 初始化i， 左边有序序列的初始索引
        int j = mid + 1;    // 初始化j， 右边有序序列的初试索引
        int t = 0;          // 指向temp数组的当前索引

        // ---------------- 一 --------------------
        // 先把左右两边的数据（有序）按照规则填充到temp数组中
        // 直到左右两边的有序序列有一边处理完毕为止
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {  // 如果 左边序列的元素值 < 右边序列的元素值
                temp[t] = arr[i];
                i++;                // 左边序列数组索引++
            } else {                // 反之，将右边序列的元素添加到临时数组
                temp[t] = arr[j];
                j++;
            }
            t++;                    // 临时temp数组索引++
        }

        // ---------------- 二 --------------------
        // 把有剩余数据的一边的数据依次全部填充到temp
        while(i <= mid) {   // 说明： 左边的有序序列还有剩余的元素 => 全部填充到temp
            temp[t] = arr[i];
            t++;
            i++;
        }
        while(j <= right) {   // 说明： 右边的有序序列还有剩余的元素 => 全部填充到temp
            temp[t] = arr[j];
            t++;
            j++;
        }

        // ---------------- 三 --------------------
        // 将temp数组的元素拷贝到arr
        // 注意： 并不是每次都拷贝所有
        t = 0;
        int tempLeft = left;        // [(0-1),(2-3),(4-5),(6-7)],[(0-3),(4-7)],[(0-7)] = 总计7次
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }
}
