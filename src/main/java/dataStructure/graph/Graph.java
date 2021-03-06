package dataStructure.graph;

import lombok.Data;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

/**
 * Assumption : If there are n number of vertices, graph nodes will start from 0 till n-1.
 */
@Data
@Getter
public class Graph {

    int numberOfVertices;
    private LinkedList<Integer> adjacent[];
    private GraphType type;

    enum GraphType {
        UNDIRECTED, DIRECTED
    }


    public Graph(int v, GraphType type) {
        this.numberOfVertices = v;
        this.type = type;
        adjacent = new LinkedList[v];
        //initialize adjacent nodes.
        for (int i = 0; i < v; i++) {
            adjacent[i] = new LinkedList<>();
        }

    }

    /**
     * Linking source and destination nodes with edge
     *
     * @param source
     * @param destination
     */
    public void addEdge(int source, int destination) {
        this.adjacent[source].add(destination);
        if (this.type.equals(GraphType.UNDIRECTED)) {
            this.adjacent[destination].add(source);//for undirected graph
        }
    }

    public List<Integer> getAdjacentNodes(int v){
        return this.adjacent[v];
    }
}
