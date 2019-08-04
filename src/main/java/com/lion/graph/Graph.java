package com.lion.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 无向图
 */
public class Graph {
    private int v; // 定点个数
    private LinkedList<Integer> adj[];//邻接表
    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { //无向图一条边存2次
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * bfs 广度优先搜索
     * @param s 起点
     * @param t 终点
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    ((LinkedList<Integer>) queue).add(q);
                }
            }
        }
    }

    /**
     * 深度优先 3层的节点
     * @param
     * @return
     */
    public boolean find3_bfs(int s, int t, int depth) {
        if (s == t) {
            return true;
        }
        boolean[] visited = new boolean[v];
        int[] prev =  new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        int[] route = new int[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            if (depth <= 0) {
                for (Integer integer : queue) {
                    System.out.println(integer);
                }
                return true;
            }
            int w = queue.poll();

            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    visited[q] = true;
                    ((LinkedList<Integer>) queue).add(q);
                    route[q] = route[w] + 1;
                }
            }
        }
        for (int  i = 0; i < route.length ;i++) {
            if (depth == route[i]) {
                System.out.println(i);
            }
        }
        return true;
    }
    //0  1  2  4
    //      3
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.find3_bfs(0,2,2);
    }

    boolean found = false;

    /**
     * 深度优先搜索
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
    }

    private void recurDfs(int s, int t, boolean[] visited, int[] prev) {
        if (found == true) {
            return;
        }
        visited[s] = true;
        if (s == t) {
            found = true;
            return;
        }
        for (int i = 0;i < adj[s].size(); i++) {
            int q = adj[s].get(i);
            if (!visited[q]) {
                prev[q] = s;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    public static void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + "");
    }
}
