import java.util.*;

public class TopoSort{
	public static void main(String[] args){
		int[][] graph = {{0,1,0,1},
						{0,0,0,0},
						{1,1,0,1},
						{0,0,0,0}};

		int len = graph.length;

		TopoSort tp =new TopoSort();

		tp.topoSort(graph, 0, len);
	}
	void topoSort(int[][] graph, int idx, int len){
		Stack<Integer> stack = new Stack<>();
		TopoSort tp = new TopoSort();
		boolean vis[] = new boolean[len];
		Arrays.fill(vis, false);

		for(int i= 0; i<len;i++){
			if(!vis[i])
				tp.dfs(graph, i, vis, stack);
		}

		while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}

	void dfs(int[][] graph, int idx, boolean[] vis, Stack<Integer> stack){
		vis[idx] = true;
		TopoSort tp = new TopoSort();

		for(int i = 0; i< graph.length; i++){
			if(!vis[i] && graph[idx][i] > 0)
				tp.dfs(graph, i, vis, stack);
		}
		stack.push(idx);
	}
}