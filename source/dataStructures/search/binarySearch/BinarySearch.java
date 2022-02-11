package dataStructures.search.binarySearch;

/**
 * @description: 二分查找
 * @author: Feirouz
 * @date: 2022-02-11 19:01
 */

// 这种不能查找多位同数值。只能找一个
public class BinarySearch {
    public static void main(String[] args) {
        // 注意： 使用二分查找法的前提是 该数组时有序的。
        int[] arr = {0, 1, 3, 5, 8, 10, 15, 60, 87, 90, 150};

        int searchIndex = search(arr, 0, arr.length - 1, 1);

        System.out.println(searchIndex);
    }

    /**
     * 二分查找算法
     * @param arr 要查找的数组
     * @param left 左边的下标
     * @param right 右边的下标
     * @param findVal 要查找的元素
     * @return
     */
    public static int search(int[] arr, int left, int right, int findVal) {
        if (left > right) {     // 找不到，不能带上“=”，因为确实有将范围缩小到1位数才比较出来的情况
            return -1;
        }

        // 得中间值下标
        int mid = (left+right) / 2;

        if (findVal > arr[mid]) {                           // 要查找的数 大于 中间值
            return search(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {                    // 要查找的数 小于 中间值
            return search(arr, left, mid - 1, findVal);
        } else {                                            // 要查找的数 等于 中间值
            return mid;
        }
    }
}
