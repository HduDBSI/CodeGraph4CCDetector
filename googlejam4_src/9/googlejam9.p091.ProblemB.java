package googlejam9.p091;
import java.io.*;
import java.util.*;

public class ProblemB {
	
	public static void main(String[] agrs) throws FileNotFoundException {
		String FILENAME = "longB";
		
		File FILE = new File(FILENAME);
		
		Scanner fileReader = new Scanner(FILE);
		
		int T =  fileReader.nextInt();
		
		for (int test = 0; test < T; test ++) {
			int B = fileReader.nextInt();
			String M1 = fileReader.next();
			
			long M = Long.parseLong(M1);
			
			int num = B - 2;
			long max = (long) Math.pow((double)2, (double)num);
			int[] x = new int[num];
			
			
			if (M > max) {
				System.out.println("Case #" + (test+1) + ": IMPOSSIBLE");
			} else {
				int[][] matrix = new int[B][B];
				for (int i = 0; i < B; i ++) {
					for (int j = i+1; j < B-1; j ++) {
						matrix[i][j] = 1;
					}
				}
				
				long dec = max / 2;
				long left = M;
				int index = 0;
				for (int i = 0; i < num; i ++) {
					if (left >= dec) {
						left -= dec;
						x[i] = 1;
					}
					dec = dec / 2;
				}
				int indi = 0;
				for (int i = B-2; i > 0; i --) {
					matrix[i][B-1] = x[indi];
					indi ++;
				}
				
				if (left == 1) {
					matrix[0][B-1] = 1;
				}
				
				
				System.out.println("Case #" + (test+1) + ": POSSIBLE");
				for (int i = 0; i < B; i ++) {
					for (int j = 0; j < B; j ++) {
						System.out.print(matrix[i][j]);
					}
					System.out.println("");
				}
			}

			
		}
		fileReader.close();
	}
}