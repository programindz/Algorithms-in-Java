import java.util.*;
public class Main
{
	public static void main(String[] args) {
        int[] arr = {912 , 83 , 113 , 76 , 556 ,904 , 343};
        int n = arr.length;
        radixSort(arr, n);
        
        System.out.println(Arrays.toString(arr));
    }
    static void radixSort(int[] arr, int n){
        int max = getMax(arr, n);
        
        for(int place = 1; max/place > 1; place*=10){
            countingSort(arr, n, place);
        }
    }
    
    static int getMax(int[] arr, int n){
        int max = arr[0];
        for(int i = 1; i < n;i++){
            if(max < arr[i])
                max = arr[i];
        }
        return max;
    }
    
    static void countingSort( int[] arr, int n, int place){
        int max = getMax(arr);
        
        int[] count = new int[max+1];
        Arrays.fill(count, 0);
        
        int output[] = new int[n+1];
        
        for(int i = 0; i<n; i++){
            count[(arr[i] / place) % 10]++;
        }
        for(int i = 1; i< 10; i++){
            count[i]+= count[i-1];
        }
        
        for(int i = n-1; i>=0; i--){
            output[count[(arr[i] / place) % 10] -1] = arr[i];//get index
            count[(arr[i]/ place)% 10]-= 1;
        }
        
        for(int i = 0; i< n;i++){
            arr[i] = output[i];
        }
    }
}
