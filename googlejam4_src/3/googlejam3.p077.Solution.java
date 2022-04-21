package googlejam3.p077;
import java.io.*;
import java.util.*;


public class Solution {
  BufferedReader reader;

  StreamTokenizer tokenizer;
  Scanner in;

  public static void main(String[] args) throws Exception {
    Solution r = new Solution();
	//    in = new Scanner(System.in);
	//    PrintWriter out = new PrintWriter(System.out);
	    r.in = new Scanner(new File("input.txt"));
	    PrintWriter out = new PrintWriter(new File("output.txt"));
	    r.reader = new BufferedReader(new InputStreamReader(System.in));
	    r.tokenizer = new StreamTokenizer(r.reader);
	    int tcs = r.in.nextInt();
		for (int tc = 1; tc <= tcs; tc++) {
		  int n = r.in.nextInt();
			int m = r.in.nextInt();
			int len = r.in.nextInt();
		int x = m / len * n + len - 1 + ((m%len!=0)?1:0);
		  System.out.println("Case #" + tc + ": " + x);
		}
	
	
	    r.in.close();
	    r.reader.close();
	    out.close();
  }
}

