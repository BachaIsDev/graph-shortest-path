import model.Graph;
import model.GraphService;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args)
    {
        // No of vertices
        int v = 6;

        int source = 0;

        int dest = 5;

        // Matrix list for storing which vertices are connected
        ArrayList<ArrayList<Integer>> matrix =
                new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            matrix.add(new ArrayList<>());
        }

        // Creating graph
        Graph.addEdge(matrix, 0, 1);
        Graph.addEdge(matrix, 1, 2);
        Graph.addEdge(matrix, 1, 3);
        Graph.addEdge(matrix, 1, 5);
        Graph.addEdge(matrix, 2, 3);
        Graph.addEdge(matrix, 2, 4);
        Graph.addEdge(matrix, 3, 5);
        Graph.addEdge(matrix, 4, 5);

        // Calculating shortest distance
        GraphService.shortestDistance(matrix, source, dest, v);
    }
}
