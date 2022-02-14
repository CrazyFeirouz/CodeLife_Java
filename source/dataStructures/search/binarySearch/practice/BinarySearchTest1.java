package dataStructures.search.binarySearch.practice;

/**
 * @description: 练习1 - 二分查找
 * @author: Feirouz
 * @date: 2022-02-14 19:01
 */
public class BinarySearchTest1 {
    public static void main(String[] args) {
        int[] arr = {-1,1,2,3,4,6,8,10,17,18};
        int num = search(arr, 0, arr.length - 1, 18);
        System.out.println(num);
    }

    public static int search(int[] arr, int left, int right, int searchVal) {
        if (left > right ||  searchVal < arr[left] || searchVal > arr[right]) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (searchVal < arr[mid]) {
            return search(arr, left, mid, searchVal);
        } else if (searchVal > arr[mid]) {
            return search(arr, mid + 1, right, searchVal);
        } else {            //找到
            return mid;
        }
    }
}
