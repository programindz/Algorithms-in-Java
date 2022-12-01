import java.util.*;

public class Main{
    public static void main(String[] args){
        int[][] G =  {
			{ 0, 1, 1, 0, 0, 1 },
			{ 1, 0, 1, 0, 1, 1 },
			{ 1, 1, 0, 1, 0, 0 },
			{ 0, 0, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1 },
			{ 1, 1, 0, 0, 1, 0 },
		};
		
	    ham(G);
    }
    static void ham(int[][] G){
        boolean[] vis = new boolean[G.length];
	    Arrays.fill(vis, false);
	    
	    int[] path = new int[G.length];
	    Arrays.fill(path, -1);
	    
	    vis[0] = true;
	    path[0] = 0;
	   
	    solve(G, 1, vis, path);
    }
    static void solve(int[][] G, int vtx, boolean[] vis, int path[]){
        if(vtx == G.length){
            if(G[path[G.length-1]][path[0]] > 0){
                for(int i = 0; i< G.length; i++){
                    System.out.print(path[i]+" - ");
                }
                System.out.print(path[0]);
                System.out.println();
            }
            return;
        }
        for(int i = 0; i< G.length; i++){
            if(isSafe(G, vis, path,vtx, i)){
                path[vtx] = i;
                vis[i] = true;
                solve(G, vtx +1, vis, path);
                vis[i] = false;
                path[vtx]= -1;
            }
        }
    }
    static boolean isSafe(int[][] G, boolean[] vis, int[] path, int vtx, int p){
        if(G[path[vtx-1]][p] == 0)
            return false;
            
        for(int i = 0; i< vtx; i++){
            if(path[i] == p)
                return false;
        }
        return true;
    }
    
   
}