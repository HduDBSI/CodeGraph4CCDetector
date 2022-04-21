package googlejam10.p128;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class A {
	
	public static void main(String[] args) throws IOException {
		
//		Scanner qwe = new Scanner(System.in);
		Scanner qwe = new Scanner(new File("A.in"));

		int T = qwe.nextInt();
		
		int p = 0;
		int r = 1;
		int s = 2;
		
		int[][][] am = new int[13][3][3];
		int[][] ordering = new int[13][3];
		String[][] str = new String[13][3];
		
		for(int i =0; i < 3; i++) am[0][i][i] = 1;
		ordering[0][p] = 0;
		ordering[0][r] = 1;
		ordering[0][s] = 2;
		str[0][p] = "P";
		str[0][r] = "R";
		str[0][s] = "S";
		
		for(int lvl =1; lvl < 13; lvl++){
			
			for(int i =0; i < 3; i++){
				for(int j =0; j < 3; j++)
					am[lvl][i][j] = am[lvl-1][(i+1)%3][j]+am[lvl-1][i][j];
			}
			
			for(int i =0; i < 3; i++)
			{
				ordering[lvl][i] = ordering[lvl-1][i]+ordering[lvl-1][(i+1)%3]-1;
				String a = str[lvl-1][i]+str[lvl-1][(i+1)%3];
				String b = str[lvl-1][(i+1)%3]+str[lvl-1][i];
				if(a.compareTo(b) < 0){
					str[lvl][i] = a;
				}
				else str[lvl][i] = b;
			}
			
			//System.out.println(Arrays.toString(ordering[lvl]));
			
		}
		
		
		for(int cse = 1; cse <= T; cse++){
			int N = qwe.nextInt();
			int R = qwe.nextInt();
			int P = qwe.nextInt();
			int S = qwe.nextInt();
			
			boolean pos = false;
			int best = 3;
			String ans = "";
			for(int i =0; i < 3; i++){
				int next = ordering[N][i];
				if(next < best){
					
					if(am[N][i][p] == P && am[N][i][r] == R && am[N][i][s] == S){
						ans = str[N][i];
						best=  next;
						pos = true;
					}
					
				}
				
			}
			
			if(pos) System.out.println("Case #"+cse+": "+ans);
			else{
				System.out.println("Case #"+cse+": IMPOSSIBLE");
			}
			
		}
		
		
		
		qwe.close();
	}

}
