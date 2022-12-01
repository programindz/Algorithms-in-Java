public class TSP{
	public static void main(String[] args){
		int[][] graph = {{0, 10, 15, 20},
                         {10, 0, 35, 25},
                         {15, 35, 0, 30},
                         {20, 25, 30, 0}};

		int len = graph.length;

		boolean vis[] = new boolean[len];
		vis[0] = true;

		int minCost = Integer.MAX_VALUE;

		System.out.println(tsp(graph, vis,0, len, 1, 0, minCost));

	}

	static int tsp(int[][] graph, boolean[] vis, int src, int len, int count, int currCost, int minCost){
		if(count == len && graph[src][0] > 0)
			minCost = Math.min(minCost, currCost+graph[src][0]);

		for(int i =0; i< len; i++){
			if(!vis[i] && graph[src][i] >0){
				vis[i] = true;
				minCost = tsp(graph, vis, i, len, count+1, currCost+graph[src][i], minCost);
				vis[i] = false;
			}
		}

		return minCost;
	}
}