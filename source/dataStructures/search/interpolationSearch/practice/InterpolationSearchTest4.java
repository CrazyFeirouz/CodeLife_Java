package dataStructures.search.interpolationSearch.practice;

/**
 * @description:  练习4 - 插值查找
 * @author: Feirouz
 * @date: 2022-02-24 15:48
 */
public class InterpolationSearchTest4 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int num = search(arr, 0, arr.length - 1, 0);
        System.out.println(num);
    }

    public static int search(int[] arr, int left, int right, int findVal) {
        if (left > right || findVal < arr[left] || findVal > arr[right]) {
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        if (findVal < arr[mid]) {
            return search(arr, left, mid, findVal);
        } else if (findVal > arr[mid]) {
            return search(arr, mid, right, findVal);
        } else {
            return mid;
        }
    }
}
