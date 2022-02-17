package dataStructures.sort.quickSort.practice;

import java.util.Arrays;

/**
 * @description: 练习4 - 快速排序 （18:40）
 * @author: Feirouz
 * @date: 2022-02-17 14:10
 */
public class QuickSort2Test4 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int temp = -1;              // 临时交换值
        while (i < j) {             // 注意不要 = ，有=的时候，就一直卡着了。因为相等的时候都是同一个数，不会造成递增递减，一直维持同一个值疯狂循环
            while (i < j && arr[j] > arr[left]) {
                j--;
            }
            while (i < j && arr[i] <= arr[left]) {
                i++;
            }
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        temp = arr[left];
        arr[left] = arr[i];
        arr[i] = temp;
        // 向左递归
        sort(arr, left, i - 1);
        // 向右递归
        sort(arr, i + 1, right);
    }
}
