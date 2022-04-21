package googlejam6.p644;

import java.util.HashMap;
import java.util.Scanner;

public class Soldier {
public static void main(String[] args) {
		
		
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        for(int i = 1;i<=t;i++){
        	int n = s.nextInt();
        			int[][] a = new int[n+n][n];
        			
        					for(int j=0;j<n+n-1;j++){
        						for(int k =0;k<n;k++){
        							a[j][k] = s.nextInt();
        						}
        					}
        					
        					HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        						for(int j =0;j<n+n-1;j++){
        							for(int k=0;k<n;k++){
        								h.put(a[j][k], 0);
        							}
        						}
        						
        						for(int j =0;j<n+n-1;j++){
        							for(int k=0;k<n;k++){
        								h.put(a[j][k], (h.get(a[j][k])+1));
        							}
        						}
        						int[] p = new int[n+n];
        						int g=0;
        						for(int j=0;j<n+n-1;j++){
        							for(int k=0;k<n;k++){
        							if((h.get(a[j][k]))%2!=0){ 
        								
        								p[g]=a[j][k];
        								
        								g++;
        								h.put(a[j][k],2);
        								}
        						}
        							}
        						for(int m=1;m<n;m++){
        			                for(int j=m;j>0;j--){
        			                    if(p[j]<p[j-1]){
        			                        int temp = p[j-1];
        			                        p[j-1] = p[j];
        			                        p[j] =temp;
        			                    }
        			                }
        			           
        			            }
        						
        						System.out.print("Case #" + i + ": "); 
        						for(int k=0;k<n;k++){
        						System.out.print(p[k] + " ");
        						}     
        						System.out.println();
        						}
        }
}
