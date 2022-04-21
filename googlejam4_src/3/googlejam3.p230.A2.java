package googlejam3.p230;
import java.io.*;
import java.util.*;

public class A2 {
	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("A-large.in"));
		BufferedReader br = new BufferedReader(new InputStreamReader(bis));
		PrintWriter out = new PrintWriter(new File("A-large.out"));
		StringTokenizer st;
		int cases = Integer.parseInt(br.readLine().trim()), R, C, W;
		for (int c = 1; c <= cases; c++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			int res = (R-1)*(C/W)+(C/W+W+(C%W==0?-1:0));
			out.println("Case #" + c + ": " + res);
		}
		out.close();
	}
}