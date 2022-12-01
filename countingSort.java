import java.util.*;
public class Main
{
	public static void main(String[] args) {
        int[] arr = {9 , 8 , 3 , 6 , 5 , 4 , 3};
        int n = arr.length;
        countingSort(arr, n);
        
        System.out.println(Arrays.toString(arr));
    }
    static void countingSort( int[] arr, int n){
        int max = arr[0];
        
        for(int i = 1; i< n;i++){
            if(max <= arr[i])
                max = arr[i];
        }
        
        int[] count = new int[max+1];
        Arrays.fill(count, 0);
        
        int output[] = new int[n+1];
        
        for(int i = 0; i<n; i++){
            count[arr[i]]++;
        }
        for(int i = 1; i<= max; i++){
            count[i]+= count[i-1];
        }
        
        for(int i = n-1; i>=0; i--){
            output[count[arr[i]] -1] = arr[i];//get index
            count[arr[i]]-= 1;
        }
        
        for(int i = 0; i< n;i++){
            arr[i] = output[i];
        }
    }
}
