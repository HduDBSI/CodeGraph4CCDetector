package googlejam1.p782;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;

public class Main {
	long gcd(long a,long b){
		return b == 0 ? a : gcd(b,a % b);		
	}
	public static void main(String[] s1) throws Exception {
		Main r = new Main();
		File out = new File("output.txt");
		Scanner in = new Scanner(new File("input.txt"));
		PrintStream ostr = new PrintStream(new FileOutputStream(out));
		int T = in.nextInt();
		int N = 0;
		while(N++<T){
			BigInteger result = new BigInteger("0");
			int n = in.nextInt();
			int m[] = new int[n];
			for (int i=0; i<n; i++){
				m[i] = in.nextInt();
			}
			int res1 = 0;
			for (int i=0; i<n-1; i++)
				if(m[i]>m[i+1])
					res1+=m[i]-m[i+1];
		
			
			int res2 = 0;
			int max =0;
			for (int i=0; i<n-1; i++)
				if(m[i]-m[i+1]>max)
					max = m[i]-m[i+1];
			for (int i=0; i<n-1; i++)
				if(m[i]-max<0)
					res2 += m[i];
				else
					res2+=max;
			ostr.printf("Case #%d: %d %d%n", N, res1, res2);
		}
	}
}