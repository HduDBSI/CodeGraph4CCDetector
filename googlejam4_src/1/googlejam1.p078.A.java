package googlejam1.p078;
import java.io.*;
import java.util.*;

public class A {
	public static boolean DEBUG = true;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int cases = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= cases; t++){
			pw.print("Case #" + t + ": ");
			
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] m = new int[n];
			
			for(int i = 0; i < n; i++){
				m[i] = Integer.parseInt(st.nextToken());
			}
			
			long a = 0;
			long b = 0;
			
			for(int i = 1; i < n; i++){
				a += Math.max(0, m[i-1]-m[i]);
				b = Math.max(b, m[i-1]-m[i]);
			}
			
			long c = 0;
			
			for(int i = 0; i < n-1; i++){
				c += Math.min(b, m[i]);
			}
			
			pw.println(a + " " + c);
		}
		
		br.close();
		pw.close();
	}
}