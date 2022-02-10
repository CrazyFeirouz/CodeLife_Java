package dataStructures.search;

/**
 * @description: 线性查找
 * @author: Feirouz
 * @date: 2022-02-10 15:57
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};     // 没有顺序的数组

        int result = seqSearch(arr, 89);
        int result2 = seqSearch(arr, -1);
        int result3 = seqSearch(arr, -9);

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }

    /**
     * 这里实现的线性查找 是找到 一个满足条件 就返回！
     * @param arr 要查找的数组
     * @param value 要查找的值
     * @return 返回找到的下标，若没找到，返回-1
     */
    public static int seqSearch(int[] arr, int value) {
        // 线性查找是逐一比对，发现有相同值，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
