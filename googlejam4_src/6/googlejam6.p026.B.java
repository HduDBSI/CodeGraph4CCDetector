package googlejam6.p026;
import java.io.*;
import java.util.*;
import java.math.*;

public class B {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();//always 1
		for(int k=0; k<t; k++){
			int n = in.nextInt();
			int[] heights = new int[2501];
			for(int i=0; i<(2*n)-1; i++){
				for(int j=0; j<n; j++){
					heights[in.nextInt()]++;
				}
			}
			
			System.out.print("Case #"+(k+1)+":");
			for(int i=1; i<=2500; i++){
				if(heights[i]%2 == 1)
					System.out.print(" "+i);
			}
			System.out.println();
		}
		
	}
}