package dataStructures.search.interpolationSearch.practice;

/**
 * @description: 练习5 - 插值查找
 * @author: Feirouz
 * @date: 2022-03-11 20:34
 */
public class InterpolationSearchTest5 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int num = sort(arr, 0, arr.length - 1, 9);
        System.out.println(0);

    }

    public static int sort(int[] arr, int left, int right, int findVal) {
        if (left > right || arr[left] < findVal || arr[right] > findVal) {      // 这里应该用 || ， 而不是 &&
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        if (findVal < arr[mid]) {
            return sort(arr, left, mid - 1, findVal);
        } else if (arr[mid] < findVal) {
            return sort(arr, mid + 1, right, findVal);
        } else {
            return mid;
        }
    }
}
