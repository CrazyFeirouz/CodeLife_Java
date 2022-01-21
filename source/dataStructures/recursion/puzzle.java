package dataStructures.recursion;

/**
 * @description: 迷宫问题 - 使用递归解决
 * @author: Feirouz
 * @date: 2022-01-21 17:29
 */
public class puzzle {
    public static void main(String[] args) {
        // 先创建一个二维数组，模拟迷宫
        // 地图
        int[][] map = new int[8][7];
        // 使用1 表示墙 - 先把四面围起来
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++){
                if (i == 0 || i == 7 || j == 0 || j == 6){
                    map[i][j] = 1;
                }
            }
        }
        // 设置挡板 - 1
        map[3][1] = 1;
        map[3][2] = 1;
        // 增加难度
//        map[5][2] = 1;
//        map[5][3] = 1;
//        map[5][4] = 1;
//        map[5][5] = 1;

        // 打印迷宫
        showPuzzle(map);

        // 开始走迷宫
        setWay(map,1, 1);
        System.out.println();

        // 打印迷宫
        showPuzzle(map);
    }

    // 打印迷宫
    public static void showPuzzle(int[][] map){
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归给小球找路
     * @param map 表示地图
     * @param i 从哪个位置开始出发 x轴
     * @param j 从哪个位置开始出发 y轴
     * @return 如果找到通路，就返回true，否则返回false
     * 当map[i][j]
     *          =1 -> 墙
     *          =2 -> 可以走
     *          =3 -> 走不通
     * 策略 = 下->右->上->左 ， 走不通再回溯
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { // 通路已经找到
            return true;
        } else {
            if (map[i][j] == 0){    // 如果当前这个点还没走过
                // 按照策略 下->右->上->左
                map[i][j] = 2;  // 假定该点可以走
                if (setWay(map, i+1, j)){       // 向下走
                    return true;
                } else if(setWay(map, i, j+1)){ // 向右走
                    return true;
                } else if(setWay(map, i-1, j)){ // 向上走
                    return true;
                } else if(setWay(map, i, j-1)){ // 向左走
                    return true;
                } else {                           // 说明该点是走不通的（死路
                    map[i][j] = 3;
                }
            } else {                // 当前这个点是1,2,3 - 可能是墙，可能走过，可能不通
                return false;
            }
        }
        return false;
    }
}

/*
运行结果
1	1	1	1	1	1	1
1	0	0	0	0	0	1
1	0	0	0	0	0	1
1	1	1	0	0	0	1
1	0	0	0	0	0	1
1	0	0	0	0	0	1
1	0	0	0	0	0	1
1	1	1	1	1	1	1

1	1	1	1	1	1	1
1	2	0	0	0	0	1
1	2	2	2	0	0	1
1	1	1	2	0	0	1
1	0	0	2	0	0	1
1	0	0	2	0	0	1
1	0	0	2	2	2	1
1	1	1	1	1	1	1
 */
