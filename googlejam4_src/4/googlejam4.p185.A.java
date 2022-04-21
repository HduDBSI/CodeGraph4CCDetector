package googlejam4.p185;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class A {

	final boolean DEBUG = false;
	final boolean isSmall = false;
	final String PACKAGE = "gcj2015/r2";
	final String PROBLEM = "A";
	
	int[][] d = {{-1, 0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) {
		A r = new A();
		if(!r.DEBUG){
			try {
				if(r.isSmall)System.setIn(new FileInputStream(new File("./src/"+r.PACKAGE+"/"+r.PROBLEM+"-small-attempt1.in")));
				else System.setIn(new FileInputStream(new File("./src/"+r.PACKAGE+"/"+r.PROBLEM+"-large.in")));
				if(r.isSmall)System.setOut(new PrintStream(new File("./src/"+r.PACKAGE+"/"+r.PROBLEM+"-small_out.txt")));
				else System.setOut(new PrintStream(new File("./src/"+r.PACKAGE+"/"+r.PROBLEM+"-large_out.txt")));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int CASE=1;CASE<=T;CASE++){
			int r1 = sc.nextInt(), c = sc.nextInt();
			char[][] map = new char[r1][];
			int[] countR = new int[r1], countC = new int[c];
			for(int i=0;i<r1;i++){
				map[i]=sc.next().toCharArray();
				for(int j=0;j<c;j++)if(map[i][j]!='.'){
					countR[i]++; countC[j]++;
				}
			}
			boolean imp = false;
			for(int i=0;i<r1;i++)for(int j=0;j<c;j++)if(map[i][j]!='.'){
				int rc = 0, rb = 0;
				for(int k=0;k<c;k++)if(map[i][k]!='.')rc++;
				for(int k=0;k<r1;k++)if(map[k][j]!='.')rb++;
				if(rc==1 && rb==1)imp=true;
			}
			if(imp){
				System.out.println("Case #"+CASE+": IMPOSSIBLE"); continue;
			}
			
			int res = 0;
			for(int i=0;i<r1;i++)for(int j=0;j<c;j++)if(map[i][j]!='.'){
				
				int k = 0;
				switch(map[i][j]){
				case '^': k = 0; break;
				case '>': k = 1; break;
				case 'v': k = 2; break;
				case '<': k = 3; break;
				}
				int pi = i+r.d[k][0], pj = j+r.d[k][1];
				boolean out = true;
				
				while(0 <= pi && pi < r1 && 0 <= pj && pj < c){
					if(map[pi][pj]!='.'){
						out = false; break;
					}
					pi+=r.d[k][0]; pj+=r.d[k][1];
				}
				if(out)res++;
			}
			
			System.out.println("Case #"+CASE+": "+res);
		}
	}
}
