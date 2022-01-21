package dataStructures.recursion;

import java.util.Map;

/**
 * @description: 递归-八皇后问题
 * @author: Feirouz
 * @date: 2022-01-21 19:41
 */
public class Queue8 {
    // 定义一个max表示共有多少个皇后
    int max = 8;
    // 定义一个数组array，保存皇后放置位置的结果 比如 arr = {0,4,7,5,2,6,1,3}
    int[] array = new int[max];
    // 记录次数
    int count = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.print();
        System.out.println();
        queue8.check(0);
    }

    // 放置第n个皇后
    // 特别注意： check 是 每一次递归时， 进入到 check 中 都有一层for循环， 因此有回溯
    private void check(int n) {
        if (n == max) { // n=8, 第8个皇后已经放好了
            count++;
            print();
            return;
        }
        // 没有放好
        // 依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前的这个皇后 n 放到该行的第1列
            array[n] = i;
            // 判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) { // 不冲突
                // 接着放n+1个皇后，开始递归
                check(n+1);
            }               // 冲突
            // 继续执行array[n] = i; (第n个皇后往后移1列)
        }
    }

    /**
     * 查看当我们放置的皇后，是否和已经摆放的皇后有冲突
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // array[i] == array[n] -> 相等表示处于同一列
            // Math.abs(n-i) == Math.abs(array[n] - array[i]) -> 处于同一斜线上（y=x）
            // 判断同一行呢？ 不需要了，n一直在递增
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    // 输出皇后的摆放位置
    private void print() {
        System.out.print(count + "\t-\t");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}
