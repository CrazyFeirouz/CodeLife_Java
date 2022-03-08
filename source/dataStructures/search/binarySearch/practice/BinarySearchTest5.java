package dataStructures.search.binarySearch.practice;

/**
 * @description: 练习5 - 二分查找法
 * @author: Feirouz
 * @date: 2022-03-08 19:40
 */
public class BinarySearchTest5 {
    public static void main(String[] args) {
        int[] arr = {-1,1,2,3,4,6,8,10,17,18};
        int search = search(arr, 0, arr.length - 1, 18);
        System.out.println(search);
    }

    public static int search(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] < findVal) {
            return search(arr, mid + 1, right, findVal);
        }else if (findVal < arr[mid]){
            return search(arr, left, mid - 1, findVal);
        }else {
            return mid;
        }
    }
}
