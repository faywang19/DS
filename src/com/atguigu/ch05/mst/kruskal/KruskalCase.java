package com.atguigu.ch05.mst.kruskal;

public class KruskalCase {

    private int edgeNum;//边的个数
    private char[] vertex;//顶点数组
    private int[][] matrix;//邻接矩阵
    private static final int INF = Integer.MAX_VALUE;


    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                {0,  12, INF, INF, INF, 16, 14},
                {12, 0,  10, INF, INF, 7, INF},
                {INF,10,  0,  3,   5,  6, INF},
                {INF,INF, INF, 0, 4, INF, INF},
                {INF,INF, INF, INF, 0, 2, 8},
                {16,  7,  6,   INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        //创建对象实例
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        //输出构建的
        kruskalCase.print();

    }

    //构造器
    public KruskalCase(char[] vertex, int[][] matrix) {
        //初始化顶点和边的个数
        int vlen = vertex.length;
        //初始化顶点
        this.vertex = new char[vlen];
        for (int i = 0; i < vertex.length; i++) {
            this.vertex[i] = vertex[i];
        }
        //this.vertex=vertex;
        //初始化边,使用的是复制拷贝
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        //统计边
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }

    }

    //打印矩阵
    public void print() {
        System.out.println("邻接矩阵为：\n");
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex.length; j++) {
                System.out.printf("%12d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }

    //对边进行排序,冒泡排序

    /**
     * 功能阶段：对边进行排序，冒泡排序
     * @param edges 边的集合
     */
    private void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length-1; i++) {
            for (int j = 0; j < edges.length - i - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData tmp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tmp;
                }
            }
        }
    }

    /**
     *
     * @param ch  顶点的值，比如’A'.'B'
     * @return  返回ch顶点对应的下标，如果找不到，返回-1
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == ch) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 功能：获取图中边，放到EData[]数组中，后面需要遍历该数组
     * 通过matrix邻接矩阵获取
     * EData[]形式  ['A','B',12],['B','F',7]
     * @return
     */
    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertex.length; i++) {
            for (int j = i + 1; j < vertex.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertex[i], vertex[j], matrix[i][j]);

                }
            }
        }
        return edges;
    }
}






//创建一个类EData，它的对象实例表示一条边
class EData {
    char start;//边的起点
    char end;//边的终点
    int weight;//边的权值
    //构造器


    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    //重写toString，便于输出边
    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
