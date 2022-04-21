package googlejam6.p510;
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs,
								// strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			
	        int count[] = new int[2501] ;
	        for (int j=0; j<2*n-1; j++) {
	            for(int k=0; k< n; k++) {
	                int temp = in.nextInt();
	                count[temp]++;

	            }
	        }
	        
	        System.out.print("Case #"+ i + ": ");
	        int missing[] = new int[n];
	        int c =0;
	        for(int j=0; j<2501; j++) {
	        	if(count[j]%2 != 0) {
	        		missing[c++] = j;
	        		System.out.print(j + " ");
	        	}
	        }
	        System.out.println("");
		}
	}
}