package model;

import java.util.ArrayList;

// Create graphs interface
public interface Graph {

    // function to form edge between two vertices
    // source and dest
    static void addEdge(ArrayList<ArrayList<Integer>> matrix, int i, int j)
    {
        matrix.get(i).add(j);
        matrix.get(j).add(i);
    }
}
