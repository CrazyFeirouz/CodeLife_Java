package dataStructures.sort.mergeSort.practice;

import java.util.Arrays;

/**
 * @description: 练习10 - 归并排序
 * @author: Feirouz
 * @date: 2022/3/19 13:58
 */
public class MergeSortTest10 {
    public static void main(String[] args) {
        int[] arr = {6,8,1,2,3,-4,8,-9,5,10};
        sort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(arr, left, mid, temp);
        sort(arr, mid + 1, right, temp);

        // 并
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
//            if (arr[i] >= arr[j]) {           上面的 else 换成这串你就错了
//                temp[index] = arr[j];         因为 经过i的肯定index是要++的, 但是你没有,然后你j又操作了,那肯定会覆盖原值
//                j++;
//            }
            index++;
        }
        for (int k = i; k <= mid; k++) {
            temp[index] = arr[k];
            index++;
        }
        for (int k = j; k <= right; k++) {
            temp[index] = arr[k];
            index++;
        }

        for (int k = 0; k < index; k++) {
            arr[left + k] = temp[k];
        }


    }
}
