package dataStructures.sort.radixSort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 基数排序
 * @author: Feirouz
 * @date: 2022-02-09 18:11
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};

//        radixSortDismantle(arr);
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 测试基数排序速度
     */
    @Test
    public void test1() {
        // 使用时间 - 57 ms
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 8000000);    // 生成[0,8000000)的数
        }

        long starTime = System.currentTimeMillis();

        sort(arr);

        long endTime = System.currentTimeMillis();
        System.out.println("使用时间 - " + (endTime-starTime) + " ms");
    }

    public static void sort(int[] arr) {
        // 1. 得到数组中最大的数的位数
        int max = arr[0];   // 假设第一个数就是最大的数
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        // 得到最大数是几位数
        int maxLength = (max + "").length();

        // 定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        int[][] bucket = new int[10][arr.length];

        // 为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录各个桶每次放入的个数
        int[] bucketElementCounts = new int[10];

        for(int i = 0; i < maxLength; i++) {
            // 针对每个元素按照位数放入桶中
            for(int j = 0; j < arr.length; j++){
                // 得到当前元素位数的值
                int digitOfElement = arr[j] / (int)Math.pow(10,i) % 10;
                // 放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            // 按照顺序取出
            int index = 0;
            for(int j = 0; j < bucket.length; j++) {
                if (bucketElementCounts[j] > 0) {
                    for(int k = 0; k < bucketElementCounts[j]; k++) {
                        arr[index] = bucket[j][k];
                        index++;
                    }
                    bucketElementCounts[j] = 0;
                }
            }
        }
    }

    //基数排序方法
    public static void radixSortDismantle(int[] arr) {
        // 定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        // 说明
        // 1. 二维数组包含10个一维数组
        // 2. 为了防止在放入数时数据溢出，每个一维数组大小为arr.length
        // 3. 基数排序时使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        // 为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录各个桶每次放入的个数
        // 比如： bucketElementCounts[0] ， 记录的就是 bucket[0] 桶放入的数据个数
        int[] bucketElementCounts = new int[10];

        // 第一轮（针对每个元素的个位进行排序）
        for (int j = 0; j < arr.length; j++) {
            // 取出每个元素的各位
            int digitOfElement = arr[j] % 10;
            // 放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        // 按照这个桶的顺序（一维数组的下标依次取出数据，放入原来数组）
        int index = 0;
        // 遍历每一个桶，并将桶中的数据放入到原数组
        for (int i = 0; i < bucket.length; i++) {
            // 如果桶中有数据，才放入到原数组中
            if (bucketElementCounts[i] > 0){
                for(int j = 0; j < bucketElementCounts[i]; j++){
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
            bucketElementCounts[i] = 0;
        }
        System.out.println("第一轮排序后：" + Arrays.toString(arr));

        // 第二轮（针对每个元素的十位进行排序）
        for (int j = 0; j < arr.length; j++) {
            // 取出每个元素的各位
            int digitOfElement = arr[j]/10 % 10;
            // 放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        // 按照这个桶的顺序（一维数组的下标依次取出数据，放入原来数组）
        index = 0;
        // 遍历每一个桶，并将桶中的数据放入到原数组
        for (int i = 0; i < bucket.length; i++) {
            // 如果桶中有数据，才放入到原数组中
            if (bucketElementCounts[i] > 0){
                for(int j = 0; j < bucketElementCounts[i]; j++){
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
            bucketElementCounts[i] = 0;
        }
        System.out.println("第二轮排序后：" + Arrays.toString(arr));

        // 第三轮（针对每个元素的百位进行排序）
        for (int j = 0; j < arr.length; j++) {
            // 取出每个元素的各位
            int digitOfElement = arr[j]/100 % 10;
            // 放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }

        // 按照这个桶的顺序（一维数组的下标依次取出数据，放入原来数组）
        index = 0;
        // 遍历每一个桶，并将桶中的数据放入到原数组
        for (int i = 0; i < bucket.length; i++) {
            // 如果桶中有数据，才放入到原数组中
            if (bucketElementCounts[i] > 0){
                for(int j = 0; j < bucketElementCounts[i]; j++){
                    arr[index] = bucket[i][j];
                    index++;
                }
            }
            bucketElementCounts[i] = 0;
        }
        System.out.println("第三轮排序后：" + Arrays.toString(arr));
    }
}
