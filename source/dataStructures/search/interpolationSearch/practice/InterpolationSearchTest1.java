package dataStructures.search.interpolationSearch.practice;

import java.util.Arrays;

/**
 * @description: 练习1 - 插值查找
 * @author: Feirouz
 * @date: 2022-02-15 14:57
 */
public class InterpolationSearchTest1 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};

        int num = search(arr, 0, arr.length - 1, 10);
        System.out.println(num);
    }

    public static int search(int[] arr, int left, int right, int findVal) {
        if (left > right || findVal < arr[left] || findVal > arr[right]) {
            return -1;
        }
        // (findVal - arr[left]) 写成了 (findVal - left) ，下次注意
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        if (findVal < arr[mid]) {
            return search(arr, left, mid, findVal);
        } else if (findVal > arr[mid]) {
            return search(arr, mid + 1, right, findVal);
        } else {
            return mid;
        }
    }
}
