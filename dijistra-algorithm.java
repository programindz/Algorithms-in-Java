import java.util.*;

public class Main{
    public static void main(String[] args){
        int[][] graph = { { 0, 0, 1, 2, 0, 0, 0 },
                        { 0, 0, 2, 0, 0, 3, 0 }, 
                        { 1, 2, 0, 1, 3, 0, 0 },
                        { 2, 0, 1, 0, 0, 0, 1 }, 
                        { 0, 0, 3, 0, 0, 2, 0 }, 
                        { 0, 3, 0, 0, 2, 0, 1 }, 
                        { 0, 0, 0, 1, 0, 1, 0 } };
                        
       
        dijkstra(graph, 0);
    }
    
    static void dijkstra(int[][] G, int src){
        int V = G.length;
        boolean vis[] = new boolean[V];
        int[] distance = new int[V];
        for(int i = 0; i< V;i++){
            vis[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        
        for(int i = 0 ; i< V; i++){
            int u = minDistance(distance, vis);
            vis[u] = true;
            
            for(int v = 0; v< V; v++){
                if(!vis[v] && G[u][v] > 0 && distance[v] > distance[u] + G[u][v])
                    distance[v] = distance[u] + G[u][v];
            }
            
        }
        
        for(int i = 0; i< distance.length; i++){
            System.out.println("Distance from: "+ src + " to: "+ i + " is "+ distance[i]);
        }
        
    }
    
    static int minDistance(int[] distance , boolean[] vis){
        int mindistance = Integer.MAX_VALUE;
        int minIndex = -1;
        for( int i = 0; i < distance.length;i++){
            if(!vis[i] && distance[i] < mindistance){
                mindistance = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    
}