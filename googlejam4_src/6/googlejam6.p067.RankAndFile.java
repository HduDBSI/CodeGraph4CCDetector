package googlejam6.p067;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class RankAndFile {
	public static void main(String[] args) throws IOException{
		Scanner kb = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new FileWriter("rankfile.out"));
		//PrintStream out = System.out;
		int cases = kb.nextInt();
		for(int n=0; n < cases; n++) {
			out.print("Case #" + (n + 1) + ":");
			
			int len = kb.nextInt();
			
			int[] heights = new int[2501];
			
			for(int i=0; i < len * 2 - 1; i++) {
				for (int j=0; j < len; j++) {
					heights[kb.nextInt()]++;
				}
			}
			
			for (int i=0; i <= 2500; i++) {
				if (heights[i] % 2 == 1)
					out.print(" " + i);
			}
			
			out.println();
		}
		out.close();
	}
}
