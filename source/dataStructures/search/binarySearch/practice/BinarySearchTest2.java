package dataStructures.search.binarySearch.practice;

/**
 * @description: 练习2 - 二分查找
 * @author: Feirouz
 * @date: 2022-02-15 16:04
 */
public class BinarySearchTest2 {
    public static void main(String[] args) {
        int[] arr = {-1,1,2,3,4,6,8,10,17,18};

        int num = search(arr, 0, arr.length - 1, 17);
        System.out.println(num);

    }

    public static int search(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (findVal < arr[mid]) {
            return search(arr, left, mid - 1, findVal);
        } else if (findVal > arr[mid]) {
            return search(arr, mid + 1, right, findVal);
        } else {
            return mid;
        }
    }
}
