import java.util.*;

public class TspDynamic{
    static int vis = (1<<4) -1;
    
	public static void main(String[] args) {
		int graph[][] ={{0, 10, 15, 20 },
                        { 10, 0, 25, 25 }, 
                        {15, 25, 0, 30 },
                        { 20, 25, 30, 0 }};
        
		int n = graph.length;
		int[][] dp = new int[(1<<4)][n];
		for(int i = 0; i<(1<<4); i++)
			for(int j = 0; j<n; j++)
				dp[i][j] = -1;
		
	    System.out.println(tsp(graph, dp, 1, 0, n));
		
	}
	static int tsp(int[][] graph, int[][] dp, int mask, int pos, int n){
	    int minCost = Integer.MAX_VALUE;
	    
	    if(mask == vis)
            return graph[pos][0];

        if(dp[mask][pos] != -1)
        	return dp[mask][pos];
        
        for(int i = 0; i< n; i++){
            if((mask&(1<<i)) == 0){
                int cost = graph[pos][i] +tsp(graph, dp, mask | (1<< i), i, n);
                minCost = Math.min(minCost, cost);
            }
        }
        
        return dp[mask][pos] = minCost;
	}
}
