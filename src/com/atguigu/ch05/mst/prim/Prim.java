package com.atguigu.ch05.mst.prim;

import java.util.Arrays;

public class Prim {

    public static void main(String[] args) {
        //测试图创建
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertex = data.length;
        //邻接矩阵关系描述
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6,10000},
        };
        //创建MGraph对象
        MGraph mGraph = new MGraph(vertex);
        //创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph, vertex, data, weight);
        //输出
        minTree.showGraph(mGraph);
        minTree.prim(mGraph,1);
    }
}

//邻接矩阵作图
//创建最小生成树

class MinTree {
    //创建图的邻接矩阵

    /**
     *
     * @param graph   图对象
     * @param vertex   图对应的顶点个数
     * @param data     图的各个顶点的值
     * @param weight   图的邻接矩阵
     */
    public void createGraph(MGraph graph, int vertex, char data[], int[][] weight) {
        int i, j;
        for (i= 0; i < vertex; i++) {//遍历顶点
            graph.data[i] = data[i];
            for (j = 0; j < vertex; j++) {
                graph.weight[i][j] = weight[i][j];

            }
        }
    }

    //显示图的方法
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    //编写prim算法

    /**
     *
     * @param graph  图
     * @param v   从图的第几个顶点开始
     */
    public void prim(MGraph graph, int v) {
        //标记顶点是否被访问过，默认为0
        int[] visited = new int[graph.vertex];
        /*for (int i = 0; i < graph.vertex; i++) {
            visited[i] = 0;
        }*/
        visited[v] = 1;
        //h1和h2记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;//将minWeight初始成一个大数，后面在遍历过程中，会被替换
        for (int k = 1; k < graph.vertex; k++) {//因为有graph.vertex顶点，prim算法结束后，有graph.vertex-1边
            //确定每一次生成的子图和哪个节点和此节点的距离最近
            for (int i = 0; i < graph.vertex; i++) {//i节点表示被访问过的结点
                for (int j = 0; j < graph.vertex; j++) {//j结点表示未被访问过的结点
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        //替换minWeight(寻找已访问过的结点和未访问的结点间的权值最小的边)
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条边最小
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + ">权值：" + minWeight);
            //将当前这个节点标记为已访问
            visited[h2] = 1;
            //minWeight重新设置为最大值
            minWeight = 10000;
        }
    }
}


class MGraph {
    int vertex;//表示图的结点个数
    char[] data;//存放结点数据
    int[][] weight;//存放边，邻接矩阵

    public MGraph(int vertex) {
        this.vertex = vertex;
        data = new char[vertex];
        weight = new int[vertex][vertex];
    }


}