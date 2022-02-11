package dataStructures.sort.radixSort.practice;

import java.util.Arrays;

/**
 * @description: 练习1 - 基数排序
 * @author: Feirouz
 * @date: 2022-02-11 13:59
 */
public class RadixSortTest1 {
    public static void main(String[] args) {
        int[] arr = {1,10,200,1,0,800,1245,3,5};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {

        int maxVal = arr[0];
        // 1. 得到整个数组中最大的数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        // 2. 取得整个数组中最大位数
        int maxBin = (maxVal + "").length();

        // 3. 定义好桶
        int[][] temp = new int[10][arr.length];     // 10个桶
        int[] tempCount = new int[10];              // 10个桶存储的元素个数

        // 4. 循环位数次数，
        for (int i = 0; i <= maxBin; i++) {
            // 针对每个元素按照位数放入桶中
            for (int j = 0; j < arr.length; j++) {
                // 得到当前位数的值
                int dightOfElement = arr[j] / (int)Math.pow(10, i) % 10;
                // 放到对应的桶中
                temp[dightOfElement][tempCount[dightOfElement]] = arr[j];
                tempCount[dightOfElement]++;
            }

            int index = 0;          // 主数组下标
            // 存放完后，按顺序取出 (不要反着取， 要从第一个开始取)
            for (int j = 0; j < 10; j++) {
                // 若桶中存在数据，才放到原数组中
                for (int k = 0; k < tempCount[j]; k++) {
                    arr[index] = temp[j][k];
                    index++;
                }
                tempCount[j] = 0;
            }

        }
    }
}
