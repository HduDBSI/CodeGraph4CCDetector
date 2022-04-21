package googlejam3.p445;
import java.util.*;

public class R1C_A {
	int r, c, w;
	int[][] map;
	/*
	int[][] ans = new int[][]{
		                             {1},
		                          {2, 2},
		                       {3, 3, 3},
		                    {4, 4, 3, 4},
		                 {5, 5, 4, 4, 5},
		              {6, 6, 5, 4, 4, 6},
		           {7, 7, 6, 5, 5, 5, 7},
		        {8, 8, 7, 6, 5, 5, 5, 8},
		     {9, 9, 8, 7, 6, 5, 5, 6, 9},
		{10, 10, 9, 8, 7, 6, 6, 5, 6, 10},
	};
	*/
	
	public static void main(String[] args) {
		R1C_A r = new R1C_A();
		Scanner sc = new Scanner(System.in);
		
		r.map = new int[11][11];
		for(int i=1;i<11;i++){ //c 
			for(int j=1;j<=i;j++){ //w
				if(j==1 || j==i) r.map[i][j] = i;
				else if(j>=i/2+i%2) r.map[i][j] = j+1;
				else r.map[i][j] = r.map[i-j][j] + 1;
				//System.out.print(map[i][j] + " ");
			}
			//System.out.println();
		}
		
				
		int t = sc.nextInt();
		for(int test=1;test<=t;test++){
			r.r = sc.nextInt();
			r.c = sc.nextInt();
			r.w = sc.nextInt();
			
			
			System.out.println("case #" + test + ": " + r.map[r.c][r.w]);
		}
		sc.close();
	}

}
