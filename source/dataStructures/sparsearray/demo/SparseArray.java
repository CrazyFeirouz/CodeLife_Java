package dataStructures.sparsearray.demo;

import java.io.*;

/**
 * @description:
 * @author: Feirouz
 * @date: 2021-08-17 15:42
 */
public class SparseArray {
    // 将 普通二维数组 转换为 稀疏数组
    public static int[][] toSparseArr(int[][] arr) {
        // 1. 先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int[] ints : arr) {
            for (int i = 0; i < arr[0].length; i++) {
                if (ints[i] != 0) {
                    sum++;
                }
            }
        }
        // 2. 创建对应的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        // 2.1 给稀疏数组赋值
        sparseArray[0][0] = arr.length;
        sparseArray[0][1] = arr[0].length;
        sparseArray[0][2] = sum;

        // 2.2 遍历二维数组，将非0值存到稀疏数组中
        int count = 0;  // 用于记录是第几个非0数据
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = arr[i][j];
                }
            }
        }

        return sparseArray;
    }

    // 将 稀疏数组 转换为 普通二维数组
    public static int[][] parseArray(int[][] sparseArr) {
        // 1. 先读取稀疏数组的第一行，根据第一行数据，创建原始的二维数组
        int[][] arr = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 2. 在读取稀疏数组后几行的数组，并赋给原始的二维数组
        for (int i = 1; i < sparseArr.length; i++){   // sparseArray[0][2] + 1 和 sparseArray.length 同理
            arr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        return arr;
    }

    // 打印 数组
    public static void showArr(int[][] sparseArr) {
        System.out.println("====================打印数组====================");
        for(int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println("====================打印完毕====================");
    }

    // 保存 稀疏数组
    public static void save(int[][] sparseArr) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("source/dataStructures/sparsearray/demo/save/dat"));
            oos.writeObject(sparseArr);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 读取 稀疏数组 - 若不存在，读取到的数组为null
    public static int[][] read() {
        ObjectInputStream ois = null;
        Object o = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("source/dataStructures/sparsearray/demo/save/dat"));
            o = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return (int[][]) o;
    }

    public static void main(String[] args) {
        int[][] chessArr1 = new int[10][12];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

//        int[][] sparseArr = toSparseArr(chessArr1);
//        showArr(sparseArr);

//        int[][] ints = parseArray(sparseArr);
//        showArr(ints);

        int[][] readArr = read();
        showArr(readArr);


    }
}
