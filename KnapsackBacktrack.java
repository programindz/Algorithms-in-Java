import java.util.*;
// 0/1 knapsack problem
public class KnapsackBacktrack{
	public static void main(String[] args){
		int weights[] = {3, 5, 4, 6, 7, 4, 2};
		int profits[] = {3,6, 7, 1, 2, 5, 4};

		int W = 15;

		System.out.println(knapsack(weights, profits, weights.length, W));
	}

	static int knapsack(int weights[], int profits[], int n, int W){
		if(n ==0 || W == 0)
			return 0;

		if(W>= weights[n-1])
			return Math.max(profits[n-1] + knapsack(weights, profits, n-1, W - weights[n-1]), knapsack(weights, profits, n-1, W));
		else
			return knapsack(weights, profits, n-1, W);
	}
}