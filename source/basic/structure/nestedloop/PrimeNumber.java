package basic.structure.nestedloop;

/**
 * -*- coding: utf-8 -*-
 * @Author Feirouz
 * @Date 2021/4/18 22:55
 * @Des 查找质数 (1-100000) - 利用不同的方法
 */

public class PrimeNumber {
    public static void main(String[] args) {
        // 质数 ： 只能被1和它本身整除的自然数
        long startTime = System.currentTimeMillis();                //开始运行时间

        findPrimeNumber1(100000);   //花费时间：51 - 82 （十次记录范围）
//        findPrimeNumber2(100000);         //花费时间：51 - 83 （十次记录范围）

        long endTime = System.currentTimeMillis();                  //结束运行时间
        System.out.println("花费时间：" + (endTime - startTime));
    }

    /**
     * 查找质数版本一
     * 思路 ： 从2开始，到该数-1结束，都不能被这个数本身整除
     */
    public static void findPrimeNumber1(int maxNum) {
        boolean isFlag = true;                      //判断质数

        for(int i = 2; i <= maxNum; i++) {             //遍历100以内的自然数
            for (int j = 2; j <= Math.sqrt(i); j++) {        //j被i除，优化二->改判断条件，小于根号即可（对是质数有效）
                if(i % j == 0) {                    //i被除尽，非质数
                    isFlag = false;
                    break;                          //优化一->添加break（对非质数有效）
                }
            }
            if (isFlag) {                           //若是质数，打印输出
                System.out.println(i);
            }
            isFlag = true;                          //重置isFlag
        }
    }

    /**
     * 查找质数版本二
     * 思路：在版本一基础上使用continue，减去判断条件，从而降低代码行数
     * 缺点：①可读性变差
     */
    public static void findPrimeNumber2(int maxNum) {
        outside:for(int i = 2; i <= maxNum; i++) {             //遍历100以内的自然数
            for (int j = 2; j <= Math.sqrt(i); j++) {        //j被i除，优化二->改判断条件，小于根号即可（对是质数有效）
                if(i % j == 0) {                    //i被除尽，非质数
                    continue outside;
                }
            }
            System.out.println(i);
        }
    }
}
