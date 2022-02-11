package dataStructures.search.binarySearch;

import java.util.ArrayList;

/**
 * @description: 二分查找 - 解决查找多位数
 * @author: Feirouz
 * @date: 2022-02-11 19:30
 */
public class BinarySearch2 {
    /**
     * 课后考题：
     *      有多个相同数值时，如何把所有数值都找到
     * 思路分析：
     *      1. 在找到mid索引值，不要马上返回
     *      2. 向mid索引值的 左边 扫描将所有满足 查找值 的下标，加入 到集合 中。
     *      3. 向mid索引值的 右边 扫描将所有满足 查找值 的下标，加入 到集合 中。
     */
    public static void main(String[] args) {
        // 注意： 使用二分查找法的前提是 该数组时有序的。
        int[] arr = {0, 1, 3, 5, 8, 10, 10, 10, 15, 60, 87, 90, 150};

        ArrayList<Integer> searchList = search(arr, 0, arr.length - 1, 10);

        System.out.println(searchList);
    }

    /**
     * 二分查找算法
     * @param arr 要查找的数组
     * @param left 左边的下标
     * @param right 右边的下标
     * @param findVal 要查找的元素
     * @return
     */
    public static ArrayList search(int[] arr, int left, int right, int findVal) {
        if (left > right) {     // 找不到，不能带上“=”，因为确实有将范围缩小到1位数才比较出来的情况
            return new ArrayList();
        }

        // 得中间值下标
        int mid = (left+right) / 2;

        if (findVal > arr[mid]) {                           // 要查找的数 大于 中间值
            return search(arr, mid + 1, right, findVal);
        } else if (findVal < arr[mid]) {                    // 要查找的数 小于 中间值
            return search(arr, left, mid - 1, findVal);
        } else {                                            // 要查找的数 等于 中间值
            ArrayList<Integer> searchIndex = new ArrayList<>();
            searchIndex.add(mid);

            // 找左边的相同值
            int toL = mid - 1;
            while (toL > 0 && arr[toL] == findVal) {
                searchIndex.add(toL);
                toL--;
            }

            // 找右边的相同值
            int toR = mid + 1;
            while (toR < arr.length && arr[toR] == findVal) {
                searchIndex.add(toR);
                toR++;
            }
            return searchIndex;
        }
    }
}
