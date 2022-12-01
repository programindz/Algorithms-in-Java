
public class Main
{
    public static void main(String[] args) {
        int wt[]={1,2,5,6};
        int pt[]={2,3,4,5};
        int W=8;
        int[][] dp = new int[5][9];
        
        for(int p =0 ; p<= wt.length; p++){
            for(int w = 0; w <= W ; w++){
                if(p == 0 || w == 0)
                    dp[p][w] = 0;
                else if(wt[p-1] <= w)
                    dp[p][w] = Math.max(pt[p-1] + dp[p-1][w-wt[p-1]], dp[p-1][w]);
                else
                    dp[p][w] = dp[p-1][w];
            }
        }
        
        System.out.println(dp[4][W]);
    }
}
