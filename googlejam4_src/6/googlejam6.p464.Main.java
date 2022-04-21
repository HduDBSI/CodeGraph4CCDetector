package googlejam6.p464;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = in.nextInt();
		for (int t=1; t<=testCases; t++) {
			int N = in.nextInt();
			
			int [][] a = new int [2*N-1][N];
			
			Set<Integer> marks = new HashSet<Integer>();
			for (int i=0; i<2*N-1; i++) {
				for (int j=0; j<N; j++) {
					int next = in.nextInt();
					if (marks.contains(next)) {
						marks.remove(next);
					} else {
						marks.add(next);
					}
				}
			}

			System.out.print("Case #"+t+": ");
			for (int i=0; i<N; i++) {
				int smallest = -1;
				for (Integer mark : marks) {
					if (smallest == -1) smallest = mark;
					else if (mark<smallest) smallest = mark;
				}
				marks.remove(smallest);
				System.out.print(smallest+(i==N-1 ? "" : " "));
			}
			System.out.println();
		}
		
	}
	
}
