package googlejam1.p326;
import java.util.*;
import java.io.*;

public class Q1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("A-large.in");
		Scanner in = new Scanner(new BufferedReader(new FileReader(file)));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("A-large.out.txt")));
		// number of test cases
		int t = Integer.valueOf(in.nextLine());
		for(int round = 1; round <= t; round++) {
			int N = Integer.valueOf(in.nextLine());
			String delim = "[ ]";
			String[] tokens = in.nextLine().split(delim);
			int[] input = new int[N];
			for(int i = 0; i < N; i++) {
				input[i] = Integer.valueOf(tokens[i]);
			}
			for(int i: input) System.out.println(i);
			// TODO Auto-generated method stub
			int[] result1 = new int[2];
			int total = 0;
			for(int i1 = 0; i1 < N-1; i1++) {
				total += Math.max(0, input[i1] - input[i1+1]);
			}
			result1[0] = total;
			total = 0;
			// find min rate first
			int maxGap = 0;
			for(int i2 = 0; i2 < N-1; i2++) {
				maxGap = Math.max(maxGap, input[i2] - input[i2+1]);
			}
			if(maxGap == 0) result1[1] = 0;
			else {
				double rate = maxGap / 10.0;
				for(int i3 = 1; i3 < N; i3++) {
					total += Math.min(maxGap, input[i3-1]);
				}
				result1[1] = total;
			}
			
			int[] result = result1;
			out.println("Case #" + round + ": " + result[0] + " " + result[1]);
		}
		
		out.flush();
		out.close();
		in.close();
	}

}
