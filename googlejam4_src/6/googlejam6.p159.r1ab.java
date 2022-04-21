package googlejam6.p159;
import java.io.*;
import java.util.*;
import java.math.BigInteger;

/*
Problem B. Rank and File
1
3
1 2 3
2 3 5
3 5 6
2 3 4
1 2 3

 */

public class r1ab {
	
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		// For STDIN, put two stars below.
		// For File In, put one star below.
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/sample.in"))));
		/**/
		int t,n,i,j,k;
		t=sc.nextInt();
		for(i=1;i<=t;i++){
			if(i!=1)
				System.out.println();
			System.out.print("Case #"+i+": ");
			n=sc.nextInt();
			int[] g = new int[2510];
			Arrays.fill(g, 0);
			int tot=2*n*n-n;
			int tmp;
			for(j=0;j<tot;j++){
				tmp=sc.nextInt();
				g[tmp]++;
			}
			for(j=0;j<=2500;j++)
				if(g[j]%2==1)
					System.out.print(" "+j);
		}
		
	}

}
