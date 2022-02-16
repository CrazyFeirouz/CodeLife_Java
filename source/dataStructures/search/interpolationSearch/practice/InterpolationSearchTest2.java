package dataStructures.search.interpolationSearch.practice;

/**
 * @description: 练习2 - 插值查找
 * @author: Feirouz
 * @date: 2022-02-16 15:59
 */
public class InterpolationSearchTest2 {
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

        if (findVal < arr[mid]) {                   // 向左 , (mid)比老师示范的多了个“-1”=>(mid - 1)，个人觉得这样更好
            return search(arr, left, mid - 1, findVal);
        } else if (findVal > arr[mid]) {            // 向右
            return search(arr, mid +  1, right, findVal);
        } else {
            return mid;
        }
    }
}
