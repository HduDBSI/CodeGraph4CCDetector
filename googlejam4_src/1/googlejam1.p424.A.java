package googlejam1.p424;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				"A-large.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("A_out1.txt"));
		
		int cases = Integer.parseInt(br.readLine());
		
		for(int n = 1; n <= cases; n++) {
			
			int intervals = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] mushrooms = new int[intervals];
			for(int i = 0; i < intervals; i++)
				mushrooms[i] = Integer.parseInt(st.nextToken());
			
			int maxDiff = 0;
			for(int i = 0; i < intervals-1; i++) {
				int diff = mushrooms[i] - mushrooms[i+1];
				maxDiff = maxDiff > diff ? maxDiff : diff;
			}
						
			int sumSecond = 0;
			for(int i = 0; i < intervals-1; i++) {
				if(mushrooms[i] > maxDiff)
					sumSecond += maxDiff;
				else 
					sumSecond += mushrooms[i];
			}
			
			int sumFirst = 0;
			for(int i = 0; i < intervals-1; i++) {
				int diff = mushrooms[i] - mushrooms[i+1];
				if(diff > 0)
					sumFirst += diff;
			}
			
			pw.printf("Case #%d: %d %d\n", n, sumFirst, sumSecond);
		}
		
		pw.close();
	}
}
