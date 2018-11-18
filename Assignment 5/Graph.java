/*
Assignment 5 
Submitted By - Romi Padam (rkp170230)
Problem Statement -
Implementation of Bellman-Ford algorithm to find shortest paths from source to all vertices 
in the given graph.
*/

public class Graph {
    
    int V;
    int E;
    boolean cycle = false;
    
    class Edge {
        int u;
        int v;
        int weight;
        Edge() {
            u = 0;
            v = 0;
            weight = 0; 
        }
    };
    
    Edge edge[];
    
    Graph (int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i=0; i<e; i++) 
            edge[i] = new Edge();
    }   
    
    void BellmanFord(Graph graph, int source) {
        int[] dist = new int[V];
        
        //Initialization
        for (int i=0; i<V; i++) {
            if (i == source)
                dist[i] = 0;
            else
                dist[i] = Integer.MAX_VALUE;
        }
        
        //Relax all edges V-1 times.
        for (int i=0; i<(V-1); i++) {
            for (int j=0; j<E; j++) {
                int u = graph.edge[j].u;
                int v = graph.edge[j].v;
                int weight = graph.edge[j].weight;
                //relax edge
                if ((dist[u] != Integer.MAX_VALUE) && (dist[u] + weight < dist[v])) {
                    dist[v] = dist[u] + weight;
                }
            }
        }
       
        //Check graph for negative-weight cycle
        for (int i=0; i<E; i++){
            int u = graph.edge[i].u;
            int v = graph.edge[i].v;
            int weight = graph.edge[i].weight;
            if ((dist[u] != Integer.MAX_VALUE) && (dist[u] + weight < dist[v])) {
                cycle = true;
                System.out.println("Negative-weight cycle Detected!");
                return;
            }
        }

        //Graph has no negative-weight cycle
        if (!cycle) {
            System.out.println("Distance of all vertices from source:");
            for (int i=0; i<V; i++)
                System.out.println(i+"\t\t"+dist[i]);
        }
    }
    
    public static void main(String[] args) {
        int v = 10;
        int e = 17;
        
        //Adjacency Matrix representation of graph with negative weights but no cycle
        
        int[][] graphWeight = {{ 0,  0,  0,  0, 0, 0, 1,  0, 0, 0},
                               { 0,  0,  0, 12, 0, 2, 0,  0, 0, 0},
                               { 0, 22,  0,  0, 0, 0, 1,  0, 0, 6},
                               { 0,  0, -3,  0, 0, 0, 0,  0, 0, 0},
                               { 0,  3,  0,  0, 0, 0, 0,  0, 0, 0},
                               { 0,  0,  0, 18, 0, 0, 0,  0, 0, 0},
                               { 0,  0,  0,  2, 0, 0, 0,  0, 0, 0},
                               {11,  0,  0,  0, 0, 0, 0,  0, 5, 0},
                               { 0,  0, 16,  0, 0, 0, 0, 14, 0, 0},
                               { 0,  9,  0,  0, 5, 0, 0,  0, 3, 0}};
        
        //Adjacency Matrix representation of graph with negative weight cycle
        /*
        int[][] graphWeight = {{ 0,  0,  0,  0, 0, 0, 1,  0, 0, 0},
                               { 0,  0,  0, 12, 0, 2, 0,  0, 0, 0},
                               { 0, 22,  0,  0, 0, 0, -2,  0, 0, 6},
                               { 0,  0, -2,  0, 0, 0, 0,  0, 0, 0},
                               { 0,  3,  0,  0, 0, 0, 0,  0, 0, 0},
                               { 0,  0,  0, 18, 0, 0, 0,  0, 0, 0},
                               { 0,  0,  0,  2, 0, 0, 0,  0, 0, 0},
                               {11,  0,  0,  0, 0, 0, 0,  0, 5, 0},
                               { 0,  0, 16,  0, 0, 0, 0, 14, 0, 0},
                               { 0,  9,  0,  0, 5, 0, 0,  0, 3, 0}}; 
        */
        
        Graph graph = new Graph(v, e);
        
        int k = -1;
        for (int i=0; i<v; i++) {
            for (int j=0; j<v; j++) {
                if (graphWeight[i][j] != 0) {
                    k++;
                    graph.edge[k].u = i;
                    graph.edge[k].v = j;
                    graph.edge[k].weight = graphWeight[i][j];
                }
            }
        }
        graph.BellmanFord(graph, 0); 
    }
}
