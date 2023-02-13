package model;

import java.util.ArrayList;
import java.util.LinkedList;

// actions on graphs interface
public interface GraphService {
    // print the shortest distance
    static void shortestDistance(
            ArrayList<ArrayList<Integer>> matrix,
            int s, int dest, int v)
    {
        // predecessor[i] array stores previous values of
        // i and distance array stores distance of i
        // from s
        int pred[] = new int[v];
        int dist[] = new int[v];

        if (!BFS(matrix, s, dest, v, pred, dist)) {
            System.out.println("Source and destination are not connected");
            return;
        }

        // LinkedList to store path
        LinkedList<Integer> path = new LinkedList<>();
        int crawl = dest;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }

        // Print distance
        System.out.println("Shortest path: " + dist[dest]);

        // Print path
        System.out.print("Path is :  ");
        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + 1 + " ");
        }
    }

    private static boolean BFS(ArrayList<ArrayList<Integer>> matrix, int src,
                               int dest, int v, int[] pred, int[] dist)
    {
        // a queue to maintain queue of vertices
        LinkedList<Integer> queue = new LinkedList<>();

        // boolean array visited[] which stores the
        // information whether ith vertex is reached
        // at least once in the Bf search
        boolean[] visited = new boolean[v];

        // initially all vertices are unvisited
        // so v[i] for all i is false
        // and as no path is yet constructed
        // dist[i] for all i set to infinity
        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        // now source is first to be visited and
        // distance from source to itself should be 0
        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        // bfs Algorithm
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < matrix.get(u).size(); i++) {
                if (!visited[matrix.get(u).get(i)]) {
                    visited[matrix.get(u).get(i)] = true;
                    dist[matrix.get(u).get(i)] = dist[u] + 1;
                    pred[matrix.get(u).get(i)] = u;
                    queue.add(matrix.get(u).get(i));

                    // stopping condition (when we find
                    // our destination)
                    if (matrix.get(u).get(i) == dest)
                        return true;
                }
            }
        }
        return false;
    }
}
