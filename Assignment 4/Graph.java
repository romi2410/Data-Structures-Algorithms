/*
Assignment 4
Submitted By - Romi Padam (rkp170230)
Problem Statement -
Perform following operations on a graph with at least 10 nodes and 15 edges -
1. DFS traversal
2. BFS traversal
*/

import java.util.*;

public class Graph {
    
    private final LinkedList<Integer> adjacencyList[];
    
    Graph(int v) {
        adjacencyList = new LinkedList[v];
        for (int i=0; i<v; i++)
            adjacencyList[i] = new LinkedList();
    }
    
    void addEdges(int u, int v) 
    {
        if (!adjacencyList[u].contains(v))
            adjacencyList[u].add(v);
        if (!adjacencyList[v].contains(u))
            adjacencyList[v].add(u);
    }
    
    void dfs(int v) 
    {
        boolean visited[] = new boolean[v];
        
        for (int i=0; i<v; i++) 
        {
            if (!visited[i])
                dfsTraversal(i, visited);
        }
    }
    
    void dfsTraversal(int v, boolean visited[]) 
    {
        visited[v] = true;
        System.out.print(v+" ");
        
        Iterator<Integer> i = adjacencyList[v].listIterator();
       
        while (i.hasNext())
        {   
            int x = i.next();
            if (!visited[x])
                dfsTraversal(x, visited);
        }
    }
    
    void bfs(int v, int start)
    {
        boolean visited[] = new boolean[v];
        visited[start] = true;
        
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        int s;
        
        while (!queue.isEmpty()) 
        {
            s = queue.poll();
            System.out.print(s+ " ");
            
            Iterator<Integer> i = adjacencyList[s].listIterator();
            
            while (i.hasNext())
            {
                int x = i.next();
                if (!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                }
            }
        } 
    }
    
    public static void main(String args[]) 
    {
        int v = 10;
        
        Graph graph = new Graph(v);
        
        graph.addEdges(0, 1);
        graph.addEdges(0, 3);
        graph.addEdges(0, 4);
        graph.addEdges(0, 5);
        graph.addEdges(0, 6);
        graph.addEdges(0, 7);
        graph.addEdges(1, 2);
        graph.addEdges(1, 3);
        graph.addEdges(1, 7);
        graph.addEdges(1, 8);
        graph.addEdges(1, 9);
        graph.addEdges(2, 3);
        graph.addEdges(2, 9);
        graph.addEdges(3, 4);
        graph.addEdges(4, 5);
        graph.addEdges(5, 0);
        graph.addEdges(5, 6);
        graph.addEdges(6, 7);
        graph.addEdges(7, 8);
        graph.addEdges(8, 9);
        
        System.out.println("Adjacenecy list representation of graph before traversal:");
        
        for (int i=0; i<v; i++)
            System.out.println(i + "->" +graph.adjacencyList[i]);
        
        int start = 0;
        System.out.println("\nDepth First Search (DFS) traversal starting at node "+start+" :");
        graph.dfs(v);
        
        System.out.println("\nBreadth First Search (BFS) traversal starting at node " + start+" :");
        graph.bfs(v, start);
    }
}
