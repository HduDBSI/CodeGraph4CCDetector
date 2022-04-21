package googlejam2.p062;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		int n1 = 1000000;
		m[1] = 1;
		for(int i = 2; i < n1 + 1; i++)
		{
			int rev = Integer.parseInt(new StringBuilder(String.valueOf(i)).reverse().toString());
			if(i % 10 !=0 &&rev < i)
				m[i] = Math.min(m[rev], m[i-1]) + 1;
			else
				m[i] = m[i-1]+1;
		}
		Scanner in = new Scanner(System.in);
		int ntests = in.nextInt();
		
		for (int test = 1; test <= ntests; test++) {
			int n = in.nextInt();
			System.out.println("Case #" + test + ": " + m[n]);
		}
	}
	static int[] m = new int[1000001];
}
