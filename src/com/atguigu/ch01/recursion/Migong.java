package com.atguigu.ch01.recursion;

public class Migong {

    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用1表示值,上下置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板，1表示
        map[3][1] = 1;
        map[3][2] = 1;

        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
//        setWay(map, 1, 1);
        setWay2(map,1, 1);
        //输出新的地图，小球走过并标识过的
        System.out.println("小球走过，并标识过的地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    //使用递归回溯给小球找路

    /**
     *i,j表示从地图的哪个位置开始出发(1,1)
     * (6,5)说明通路走完
     * 约定：map[i][j]为0表示点没有走过，1表示墙，2表示可以走，3表示已走过但是走不通
     * 策略：下>右>上>左,如果走不通，再回溯
     *
     * @param map  表示地图
     * @param i     从哪个位置开始找
     * @param j
     * @return      如果找到返回true，否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }else{
            if (map[i][j]==0) {//如果当前这个点还没有走过
                //按照策略 下->右->上->左
                map[i][j] = 2;//假设该点可以走通
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右
                    return true;
                } else if (setWay(map, i - 1, j)) {//向左
                    return true;
                } else if (setWay(map, i, j - 1)) {//向左走
                    return true;
                }else{
                    //说明此点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else{//1，墙，2 走过，3 死路
                return false;
            }
        }
    }


//修改找路的策略，改成上->右->下->左
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }else{
            if (map[i][j]==0) {//如果当前这个点还没有走过
                //按照策略 下->右->上->左
                map[i][j] = 2;//假设该点可以走通
                if (setWay2(map, i -1, j)) {//向下走
                    return true;
                } else if (setWay2(map, i, j + 1)) {//向右
                    return true;
                } else if (setWay2(map, i + 1, j)) {//向左
                    return true;
                } else if (setWay2(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    //说明此点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else{//1，墙，2 走过，3 死路
                return false;
            }
        }
    }
}
