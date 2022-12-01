import java.util.*;
public class Main
{
	public static void main(String[] args) {
      char[] txt = "ABACDABCDBACD".toCharArray();
      char[] pat = "BAC".toCharArray();
      
      search(txt, pat);
    }
    static void search(char[] txt, char[] pat){
        int n = txt.length;
        int m = pat.length;
        
        int badChar[] = new int[256];
        badCharacterH(pat, m ,badChar);
        
        int s = 0;
        
        while(s<n-m){
            int j = m-1;
            while(j>=0 && pat[j] == txt[j+s])
                j--;
                
            if(j <0 ){
                System.out.println("Pattern found at index: "+ s);
                
                s += (s+m<n)?m - badChar[txt[s+m]]: 1;
            }
            
            else{
                s += Math.max(1, j- badChar[txt[s+j]]);
            }
        }
    }
    static void badCharacterH(char[] pat, int m, int[] badChar){
        for(int i =0; i< 256; i++){
            badChar[i] = -1;
        }
        for(int i = 0; i<m;i++){
            badChar[(int) pat[i]] = i;
        }
    }
}
