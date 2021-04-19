package basic.arrays.assignment;

/**
 * -*- coding: utf-8 -*-
 * @Author Feirouz
 * @Date 2021/4/19 20:12
 * @Des 打印杨辉三角
 */

public class PascalTriangle {
    public static void main(String[] args) {
        /*
         * 【Tip】
         * 1.第一行有1个元素，第n行有n个元素
         * 2.每一行第一个和最后一个元素都是1
         * 3.从第三行开始，对于非第一个元素和最后一个元素，都有：yh[i][j] = yh[i-1][j-1] + yh[i-1][j]
         */

        int[][] yangHui = new int[10][];        //声明

        for(int i = 0; i < 10; i++) {
            yangHui[i] = new int[i+1];          //初始化
            yangHui[i][0] = yangHui[i][i] = 1;  //首元素末元素=1
            for (int j = 1; j < yangHui[i].length-1; j++) {     //非首末元素赋值
                yangHui[i][j] = yangHui[i-1][j-1] + yangHui[i-1][j];
            }
        }

        for(int i = 0; i < yangHui.length; i++) {           //遍历
            for (int j = 0; j < yangHui[i].length; j++) {
                System.out.print(yangHui[i][j] + "\t");
            }
            System.out.println();
        }


    }
}
