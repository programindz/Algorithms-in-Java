import java.util.*;

public class Main{
    public static void main(String[] args){
       int[] weights = { 10, 40, 20, 30 };
       int[] profits = { 60, 40, 100, 120 };
       double W = 50;
       
       System.out.println("Total profit : "+ knapfrac(weights, profits, W));
    }
    
    static double knapfrac(int[] weights, int[] profits, double W){
        double temp;
        double[] pw= new double[weights.length];
        for(int i=0; i< weights.length; i++){
           pw[i] = profits[i] / weights[i];
        }
        
        for(int i =0; i< weights.length -1 ; i++){
            for(int j = 0; j< weights.length - i -1; j++){
                if(pw[j] < pw[j+1]){
                    temp = pw[j];
                    pw[j] = pw[j+1];
                    pw[j+1] = temp;
                    
                    int temp1 = profits[j];
                    profits[j] = profits[j+1];
                    profits[j+1] = temp1;
                    
                    temp1 = weights[j];
                    weights[j] = weights[j+1];
                    weights[j+1] = temp1;
                }
            }
        }
        double totalProfit = 0.00;
        for(int i = 0; i< weights.length; i++){
            if(W== 0)
                break;
                
            if(weights[i] <= W){
                totalProfit += profits[i];
                W -= weights[i];
            }
            else{
                double temp1 = (pw[i]) * W;
                totalProfit += temp1;
                W = 0;
            }
        }
        
        return totalProfit;
    }
    
}