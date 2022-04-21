package googlejam1.p084;
import java.util.*;
import java.io.*;

public class A {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int cas = 1; cas <=T; cas++) {
			int N = Integer.parseInt(in.readLine());
			long[] a = new long[N];
			String[] spl = in.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(spl[i]);
			}
			long sum =0;
			long maxD = 0;
			for (int i = 0; i < N-1; i++) {
				sum += Math.max(0, a[i]-a[i+1]);
				maxD = Math.max(maxD, a[i]-a[i+1]);
			}
			long s2=0;
			for (int i = 0; i < N-1; i++) {
				s2 += Math.min(maxD, a[i]);
			}
			String ans = sum+" "+s2;
			System.out.println("Case #"+cas+": "+ans);
		}
	}

}
