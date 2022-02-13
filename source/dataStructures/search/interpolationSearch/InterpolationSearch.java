package dataStructures.search.interpolationSearch;

/**
 * @description: 插值查找
 * @author: Feirouz
 * @date: 2022-02-13 22:32
 */
public class InterpolationSearch {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};

        int index = search(arr, 0, arr.length - 1, 9);

        System.out.println(index);

    }

    // 要求：数组也是有序的
    public static int search(int[] arr, int left, int right, int key) {
        // 注意： key < arr[left] || key > arr[right] 必须需要
        // 否则我们得到 mid 可能越界
        if (left > right || key < arr[left] || key > arr[right] || arr == null ||arr.length <= 0) {
            return -1;
        }
        int mid = left + (right - left) * (key - arr[left]) / (arr[right] - arr[left]);

        if (key < arr[mid]) {               // 向左
            return search(arr, left, mid, key);
        }else if (key > arr[mid]) {         // 向右
            return search(arr, mid + 1, right, key);
        }else {                             // 相等
            return mid;
        }
    }

}
