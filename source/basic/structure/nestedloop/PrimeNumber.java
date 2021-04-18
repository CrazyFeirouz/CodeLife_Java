package basic.structure.nestedloop;

/**
 * -*- coding: utf-8 -*-
 * @Author Feirouz
 * @Date 2021/4/18 22:55
 * @Des 查找质数(1-100) - 利用不同的方法
 */

public class PrimeNumber {
    public static void main(String[] args) {
        // 质数 ： 只能被1和它本身整除的自然数

        finPrimeNumber1();
    }

    /**
     * 查找质数版本一 - 最暴力版本
     * 思路 ： 从2开始，到该数-1结束，都不能被这个数本身整除
     */
    public static void finPrimeNumber1() {
        boolean isFlag = true;                      //判断质数

        for(int i = 2; i <= 100; i++) {             //遍历100以内的自然数
            for (int j = 2; j <= i-1; j++) {        //j被i除
                if(i % j == 0) {                    //i被除尽，非质数
                    isFlag = false;
                    break;
                }
            }
            if (isFlag) {                           //若是质数，打印输出
                System.out.println(i);
            }
            isFlag = true;                          //重置isFlag
        }
    }
}
