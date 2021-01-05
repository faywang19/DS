package com.atguigu.ch04.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    private ArrayList<String> vertexList;//存储顶点集合

    private int[][] edges;//存储图对应的邻接矩阵

    private int numOfEdges;//表示边的数目

    private boolean[] isVisited;

    public static void main(String[] args) {

        //测试图创建
        int n = 5;//节点的个数
        String Vertexs[] = {"A", "B", "C", "D", "E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for (String vertex : Vertexs) {
            graph.insertVertex(vertex);
        }
        //添加边
        //A-B A-C  B-C B-D B-E
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        //显示
        graph.showGraph();

        //测试dfs
        System.out.println("DFS");
        graph.dfs();
        System.out.println();

        //测试bfs
        System.out.println("BFS");
        graph.bfs();

    }

    //构造器
    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;

    }

    //得到第一个邻接节点的下标w

    /**
     *
     * @param index
     * @return   如果存在就返回对应的下标，否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    //第一次i就是0
    private void dfs(boolean[] isVisited, int i) {
        //首先我们访问该节点，输出
        System.out.print(getValueByIndex(i) + "->");
        //将结点设置为已经访问过
        isVisited[i] = true;
        //查找结点i的第一个邻接节点w
        int w = getFirstNeighbor(i);
        while (w != -1) {//说明有
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w结点已经被访问过
            w = getNextNeighbor(i, w);
        }
    }


    //对dfs进行重载，遍历所有的结点并进行dsf
    public void dfs() {
        isVisited = new boolean[5];
        //遍历所有的结点，进行dfs回溯
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    //对一个节点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited, int i) {
        int u;//表示队列的头结点对应下标
        int w;//邻接点w
        //队列，记录结点访问的顺序
        LinkedList queue = new LinkedList();
        //访问结点，输出结点信息
        System.out.print(getValueByIndex(i) + "=>");
        //标记为已访问
        isVisited[i] = true;
        //将结点加入队列
        queue.addLast(i);
        while (!queue.isEmpty()) {
            //取出队列的头结点下标
            u = (Integer) queue.removeFirst();
            //得到第一个邻接点的下标w
            w = getFirstNeighbor(u);
            while (w != -1) {
                //找到
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "=>");
                    //标记为已访问
                    isVisited[w] = true;
                    //入队列
                    queue.addLast(w);
                }
                //以u为前驱点，找w后面的下一个邻接点
                w = getNextNeighbor(u, w);//体现广度优先
            }
        }
    }

    //遍历所有的结点，都进行广度优先搜索
    public void bfs() {
        isVisited = new boolean[5];
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }



    //图中常用的方法
    //显示图对应的矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }
    //返回节点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回节点i下标对应的数据  0->A 1->B  2->C
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }


    //插入节点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边

    /**
     *
     * @param v1   表示点的下标即第几个顶点 “A”-“B”  A-0  B-1
     * @param v2   表示第二个顶点对应的下标
     * @param weight
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
