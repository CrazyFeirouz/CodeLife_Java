package dataStructures.sparsearray;

/**
 * @description: 稀疏数组应用实例
 * @author: Feirouz
 * @date: 2021-08-16 19:59
 *
 * 模拟五子棋数据 压缩 存储
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11*11（个人想强调行和列的区别，所以改为10*12）
        // 0：表示没有棋子，1表示黑子，2表示白子
        int[][] chessArr1 = new int[10][12];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
//        chessArr1[4][5] = 2;
        // 输出原始的二维数组
        System.out.println("====================原始的二维数组====================");
        for(int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 将二维数组 转 稀疏数组
        // 1. 先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for(int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2. 创建对应的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        // 2.1 给稀疏数组赋值
        sparseArray[0][0] = chessArr1.length;
        sparseArray[0][1] = chessArr1[0].length;
        sparseArray[0][2] = sum;

        // 2.2 遍历二维数组，将非0值存到稀疏数组中
        int count = 0;  // 用于记录是第几个非0数据
        for(int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println("====================转换的稀疏数组====================");
        for (int[] row : sparseArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 将稀疏数组 转为 二维数组
        // 1. 先读取稀疏数组的第一行，根据第一行数据，创建原始的二维数组
        int[][] chessArr2 = new int[sparseArray[0][0]][sparseArray[0][1]];

        // 2. 在读取稀疏数组后几行的数组，并赋给原始的二维数组
        for (int i = 1; i < sparseArray.length; i++){   // sparseArray[0][2] + 1 和 sparseArray.length 同理
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("====================转换的二维数组====================");
        for(int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
