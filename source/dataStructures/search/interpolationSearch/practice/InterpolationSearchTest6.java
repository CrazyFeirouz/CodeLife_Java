package dataStructures.search.interpolationSearch.practice;

/**
 * @description: 练习6 - 插值查找
 * @author: Feirouz
 * @date: 2022-04-18 23:11
 */
public class InterpolationSearchTest6 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int search = search(arr, 0, arr.length - 1, 0);
        System.out.println(search);

    }

    public static int search(int[] arr, int l, int r, int findVal) {
        if (l > r || arr[l] > findVal || arr[r] < findVal) {
            return -1;
        }
        int mid = l + (findVal - arr[l]) * (r - l) / (arr[r] - arr[l]);
        if (findVal < mid) {
            return search(arr, l, mid - 1, findVal);
        } else if (findVal > mid) {
            return search(arr, mid + 1, r, findVal);
        } else {
            return mid;
        }
    }
}
