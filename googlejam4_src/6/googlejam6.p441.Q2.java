package googlejam6.p441;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2 {

	// passed: small, large - 15 points
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader fileReader = new FileReader("/Users/joy/Documents/workspace/GCJ2016R1/B-large.in");
		FileWriter fileWriter = new FileWriter("/Users/joy/Documents/workspace/GCJ2016R1/B-large.out");
		BufferedReader in = new BufferedReader(fileReader);
		BufferedWriter out = new BufferedWriter(fileWriter);
		
		int t = Integer.parseInt(in.readLine());
		
		// per testcase
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(in.readLine());
			
			//per line
			int[] missing = new int[n];
			BitSet b = new BitSet(2500);
			for(int j=0; j<2*n-1; j++) {
				String[] input = in.readLine().split(" ");
				for(int k=0; k<n; k++) {
					b.flip(Integer.parseInt(input[k]));
				}
			}
			int idx = 0;
			for(int j=1; j<=2500; j++) {
				if(b.get(j)) {
					missing[idx] = j;
					idx++;
				}
			}
			Arrays.sort(missing);
			
			String output = "";
			for(int j: missing) {
				output+=(j+" ");
			}
			System.out.println(output);
			out.write(String.format("Case #%d: %s",i+1, output.substring(0,output.length()-1)));
			if(i<t-1) 
				out.write("\n");
		}
		in.close();
		out.close();
	}
}
