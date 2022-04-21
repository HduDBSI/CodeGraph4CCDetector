package googlejam3.p143;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Throwable {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		int tn = Integer.parseInt(tokenizer.nextToken());
		for (int test = 1; test <= tn; test++) {
			
			tokenizer = new StringTokenizer(in.readLine());

			/* start sol */



			int r = Integer.parseInt(tokenizer.nextToken());
			int c = Integer.parseInt(tokenizer.nextToken());
			int w = Integer.parseInt(tokenizer.nextToken());

			int res = c/w;
			res*=r;
			if(c%w !=0) {
				res++;
			}
			res+=w-1;

			out.print("Case #" + test + ": " + res);
			/* end sol */




			if(test < tn) {
				out.println();
			}


		}
		in.close();
		out.close();
	}
}