package com.learn.datastructure.graph;

import java.util.Scanner;

/**
 * 功能描述：
 *
 * @author zhenghao
 * @email zhenghao@zhiketong.cn
 * @date 2019/8/22 11:10
 */
public class GraphTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v, e;
        int in, out;
        while (true) {
            v = sc.nextInt();
            e = sc.nextInt();
            if (v == 0 && e == 0)
                break;
            Graph g = new Graph(v, e);
            for (int i = 0; i < e; i++) {
                in = sc.nextInt();
                out = sc.nextInt();
                g.insertEdge(in, out);
            }
            for (int i = 0; i < v; i++) {
                if (i != 0)
                    System.out.print(" ");
                System.out.print(g.outDegree(i));
            }
            System.out.print("\n");
            for (int i = 0; i < v; i++) {
                if (i != 0)
                    System.out.print(" ");
                System.out.print(g.inDegree(i));
            }
            System.out.print("\n");
        }
    }

    private static class Graph {
        private int vertex;
        private int edge;
        private int graph[][];

        Graph(int v, int e) {
            vertex = v;
            edge = e;
            graph = new int[v][v];
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    graph[i][j] = 0;
                }
            }
        }

        void insertEdge(int in, int out) {
            graph[in - 1][out - 1] = 1;
        }

        int outDegree(int theVertex) {
            int cnt = 0;
            for (int i = 0; i < vertex; i++) {
                cnt += graph[theVertex][i];
            }
            return cnt;
        }

        int inDegree(int theVertex) {
            int cnt = 0;
            for (int i = 0; i < vertex; i++) {
                cnt += graph[i][theVertex];
            }
            return cnt;
        }
    }

}