
public class Main
{
	public static void main(String[] args) {
		int keys[] = { 10, 12, 20 };
        int freq[] = { 34, 8, 50 };
		
		int n = freq.length;
		
		System.out.println(optimalS(keys, freq, n));
	}
	static int optimalS(int[] keys, int[] freq, int n){
	    int[][] cost = new int[n+1][n+1];
	    
	    for(int i= 0; i< n; i++){
	        cost[i][i] = freq[i];
	    }
	    
	    for(int l = 2; l <= n;l++){
	        for(int i = 0; i<= n-l + 1; i++){
	            int j = i + l - 1;
	            cost[i][j] = Integer.MAX_VALUE;
	            for(int r = i; r<= j; r++){
	                int c = ((r>i)?cost[i][r-1]:0) + ((r<j)?cost[r+1][j]:0)+ sum(freq, i, j);
	                cost[i][j] =Math.min(cost[i][j], c);
	            }
	        }
	    }
	    return cost[0][n-1];
	}
	
	static int sum(int[] freq, int i, int j){
	    int s =0;
	    for(int k = i; k<= j; k++){
	        if(k>= freq.length)
	            continue;
	        s+=freq[k];
	    }
	    return s;
	}
	
}
