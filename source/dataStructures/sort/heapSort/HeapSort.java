package dataStructures.sort.heapSort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description:
 * @author: Feirouz
 * @date: 2022-03-03 23:32
 */
public class HeapSort {
    public static void main(String[] args) {
        // 要求：将数组进行升序排序
        int[] arr = {4, 6, 8, 5, 9};

        heapSortDismantle(arr);

//        sort(arr);
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 测试插入排序速度
     */
    @Test
    public void test1() {
        // 测试一下堆排序的速度，给8w个数据，测试 -- 12 ms
        // 测试800w -- 1646 ms
        // 正常的版本应该是两层for，且每次都是交换。有点像反向的冒泡
        // 比之前的选择排序又快了2-4倍左右（看了下弹幕大部分和我一致，但老师是和选择同速，也有少部分选择更快）
        // 1. 创建一个80000个随机数的数组
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 8000000);    // 生成[0,8000000)的数
        }

        long starTime = System.currentTimeMillis();

        sort(arr);

        long endTime = System.currentTimeMillis();
        System.out.println("使用时间 - " + (endTime-starTime) + " ms");
    }

    // 编写一个堆排序的方法 - 为了容易理解，我们把堆排序的演变过程给展示出来
    public static void heapSortDismantle(int[] arr) {
        System.out.println("堆排序");

        // 分步完成
        adjustHeap(arr, 1, arr.length);
        System.out.println("第一次调整后： " + Arrays.toString(arr));      // [4, 9, 8, 5, 6]

        adjustHeap(arr, 0, arr.length);
        System.out.println("第二次调整后： " + Arrays.toString(arr));      // [9, 6, 8, 5, 4]
    }

    public static void sort(int[] arr) {
        // 上面步骤的合成版
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 2. 将堆顶元素与末尾元素交换，将最大元素“沉”到数组末端
        // 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复 执行调整 + 交换 步骤，直到整个序列有序
        int temp = -1;
        for (int i = arr.length - 1; i > 0; i--) {
            // 交换
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }

    }

    /**
     * 将一个数组（二叉树）调整成一个大顶堆
     * 功能： 完成 将i对应的非叶子节点为根的树调整成大顶堆
     * 举例： [4,6,8,5,9] => i=1 => adjustHeap => [4,9,8,5,6]...
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 对多少个元素进行调整 & 逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];  // 先取出当前元素的值，保存在临时变量
        // 开始调整 - 向左子节点递归
        // 说明
        // 1. i*2+1 ： i 节点的 左子节点
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            // 1. j + 1 < length : 限制，防止越界和过多判断
            // 2. arr[j] < arr[j+1] : 说明左子节点的值 小于 右子节点的值
            if (j + 1 < length && arr[j] < arr[j+1]) {
                j++;                    // j 指向右子节点
            }
            if (arr[j] > temp) {        // 如果子节点 大于 父节点
                arr[i] = arr[j];        // 把较大的值赋给当前的节点
                i = j;                  // !!! i指向j，继续循环比较
            } else {                    // 子节点没有 大于 父节点
                // 为啥敢break？
                // 因为是从左至右，从下到上。
                break;
            }
        }
        // 当for循环结束后，我们已经将以i为父节点的树（局部）的最大值，放在了最顶上
        arr[i] = temp;                  // 将temp值放到调整后的位置
    }
}
