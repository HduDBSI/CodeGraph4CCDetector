package googlejam9.p126;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

import javafx.util.Pair;


public class Slides {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int cas=1; cas<=t; ++cas) {
			int b = scanner.nextInt();
			long m = scanner.nextLong();
			if(m > Math.pow(2, b-2)){
				System.out.printf("Case #%d: IMPOSSIBLE\n", cas);
			}
			else {
				boolean[][] ans = new boolean[b][b];
				if(m>0) {
					ans[0][b-1] = true;
					m--;
				}
				for(int i=0; i<b-1; ++i) {
					if(m>0) 
						ans[i+1][b-1] = true;
					if(m>=Math.pow(2, i)) {
						for(int j=0; j<=i; ++j)
							ans[j][i+1] = true;
						m-=Math.pow(2,i);
					}
					else {
						int row = 1;
						while(m>0) {
							if(m%2==1) {
								ans[row][i+1] = true;
							}
							m/=2;
							row++;
						}
					}
				}
				System.out.printf("Case #%d: POSSIBLE\n", cas);
				for(int i=0; i<b; ++i){
					for(int j=0; j<b; ++j)
						System.out.printf("%s", ans[i][j]?"1":"0");
					System.out.println();
				}
				
			}
		}
	}
}
