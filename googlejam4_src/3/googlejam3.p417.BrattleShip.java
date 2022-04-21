package googlejam3.p417;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class BrattleShip {

	public static void main (String [] args) throws IOException {
		String root = "A-small-attempt0";
		String fileName = "C:\\Users\\Aaron\\Downloads\\" + root + ".in";
		BufferedReader reader = new BufferedReader (new FileReader(new File(fileName)));
		int nTestCases = Integer.parseInt(reader.readLine());
		ArrayList<String> out = new ArrayList<String>();
		for (int t = 0; t < nTestCases; t++) {
			String[] bn = reader.readLine().split(" ");
			
			int r = Integer.parseInt(bn[0]);
			int c = Integer.parseInt(bn[1]);
			int w = Integer.parseInt(bn[2]);
			
			// 0 is unchecked, 1 is miss, 2 is hit
			int[][] board = new int[r][c];
			for (int[] b : board) Arrays.fill(b, 0);
			
			
			// INIITALLY ASSUME R = 1;
			// Stagger the hits
			int ans = (c % w == 0) ? c / w : c / w + 1;
			ans += (w - 1);
			
			
			System.out.println("CASE " + (t + 1) + ": " + ans);
			out.add("Case #" + (t+1) + ": " + ans);
			System.out.println("-----------------");
		}
		
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Aaron\\Downloads\\"+ root + "-SOL.out")));
		for (String s : out) {
			writer.write(s + "\n");
		}
		
		writer.close();
		reader.close();
	}
}
