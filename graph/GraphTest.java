package graph;

import org.junit.Test;

import java.util.Arrays;

public class GraphTest {

    @Test
    public void addVertex() {
        graph.Vertex v1 = new Vertex("a");
        Vertex v2 = new Vertex("b");
        Vertex v3 = new Vertex("c");
        Vertex v4 = new Vertex("d");
        Vertex v5 = new Vertex("e");

        Graph graph = new Graph(5);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        //增加边
        graph.addEdge("a","c");
        graph.addEdge("b","c");
        graph.addEdge("a","b");
        graph.addEdge("b","d");
        graph.addEdge("b","e");

        for (int[] a:graph.adjMat){
            System.out.println(Arrays.toString(a));
        }

//        Graph graph1 = new Graph();
//        String[] a = new String[]{"a","b","c","d","e"};
//        graph1.createGraph(a);
       graph.dsf();
    }
}