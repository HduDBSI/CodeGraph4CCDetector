package googlejam3.p443;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new  BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(in.readLine());
		
		for (int i = 1; i <= t; i++) {
			int res = 0;
			// body of the program
			
			String[] next = in.readLine().split(" ");
			int r = Integer.parseInt(next[0]);
			int c = Integer.parseInt(next[1]);
			int w = Integer.parseInt(next[2]);
			
			int row = (c - w) / w;
			if (c % w == 0) row += w;
			else row += w + 1;
			
			res = r*row;
			
			System.out.format("Case #%d: %d\n", i, res);
		}
	}
}
