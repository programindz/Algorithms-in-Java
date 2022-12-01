import java.util.*;

public class Main
{
	public static void main(String[] args) {
    	int[][] G ={{0,1, 1,0},
    	            {1, 0, 1, 0},
    	            {1, 1, 0 ,1},
    	            {0 , 0 ,0, 0}};
    	
    	Queue<Integer> queue = new LinkedList<>();
    	boolean vis[] = new boolean[G.length];
    	
    	bfs(G, vis, queue, 0);
    	
    	System.out.println("Nodes accessible from 3 : ");
    	for(int i = 0 ; i< G.length; i++){
    	    if(vis[i])
    	        System.out.print(i+ " , ");
    	}
    	
	}
	static void bfs(int[][] G, boolean[] vis,Queue<Integer> queue,  int vtx){
	    vis[vtx] = true;
	    for(int i = 0; i< G.length; i++){
	        if(G[vtx][i]> 0 & !vis[i]){
	            queue.add(i);
	        }
	    }
	    if(!queue.isEmpty()){
            vis[queue.peek()] = true;
            bfs(G, vis, queue, queue.poll());
	    }
	    
	}
}
