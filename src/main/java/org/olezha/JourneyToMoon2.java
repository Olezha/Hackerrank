package org.olezha;

import java.util.*;

public class JourneyToMoon2 {

    public static void main(String[] args) {
        long time = System.nanoTime();
        System.out.println(journeyToMoon(5, new int[][]{{0, 1}, {2, 3}, {0, 4}}) == 6);
        System.out.println(journeyToMoon(4, new int[][]{{0, 2}}) == 5);
        System.out.println(System.nanoTime() - time);
    }

    private static int journeyToMoon(int n, int[][] astronaut) {
        Graph graph = new Graph(n);
        for (int[] pair : astronaut)
            graph.addEdge(pair[0], pair[1]);
        return graph.solve();
    }
}

class Graph {

    private final boolean visited[];

    private final Map<Integer, ArrayList<Integer>> graph;

    Graph(int v) {
        visited = new boolean[v];
        graph = new HashMap<>(v);
        for (int i = 0; i < v; i++)
            graph.put(i, new ArrayList<>());
    }

    void addEdge(int s, int d) {
        graph.get(s).add(d);
        graph.get(d).add(s);
    }

    private int dfs(int s) {
        int count = 1;
        visited[s] = true;
        for (Integer i : graph.get(s))
            if (!visited[i])
                count += dfs(i);
        return count;
    }

    private List<Integer> traversal() {
        List<Integer> countrySizes = new ArrayList<>();
        for (int i = 0; i < visited.length; i++)
            if (!visited[i])
                countrySizes.add(dfs(i));
        return countrySizes;
    }

    int solve() {
        List<Integer> countrySizes = traversal();
        int sum = 0, result = 0;
        for (int size : countrySizes) {
            result += sum * size;
            sum += size;
        }
        return result;
    }
}
