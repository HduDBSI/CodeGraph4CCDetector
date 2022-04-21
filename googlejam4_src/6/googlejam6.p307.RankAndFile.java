package googlejam6.p307;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class RankAndFile {
	
	public RankAndFile(Scanner f) {
		int cases = f.nextInt();
		for(int ii=1; ii <= cases; ii++) {
			
			int n = f.nextInt();
			int numSheets = 2*n-1;
			
			int[][] rows = new int[numSheets][n];
			
			for(int i = 0; i < numSheets; i++)
				for(int j = 0; j < n; j++)
					rows[i][j] = f.nextInt();
			
			int[] peopleMap = new int[2501];
			for(int i = 0; i <= 2500; i++)
				peopleMap[i] = 0;
			
			for(int i = 0; i < numSheets; i++) {
				for(int j = 0; j < n; j++) {
					peopleMap[rows[i][j]]++;
				}
			}
			
			int printCount = 0;
			System.out.printf("Case #%d: ", ii);
			for(int i = 0; i <= 2500; i++) {
				if(peopleMap[i] % 2 != 0) {
					printCount++;
					System.out.printf("%d%s", i, printCount==n ? "\n" : " ");
				}
			}
		}
	}
	
	/*
	void printArray(int[][] rows) {
		for(int i = 0; i < rows.length; i++)
			for(int j = 0; j < rows[0].length; j++)
				System.out.printf("%d%s", rows[i][j], j==rows[0].length-1 ? "\n" : " ");
	}*/
	
	public static void main(String[] args) {
		Scanner f = new Scanner(System.in);
		new RankAndFile(f);
		f.close();
	}

}