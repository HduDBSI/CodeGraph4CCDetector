package googlejam6.p064;
import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nt = in.nextInt();
		for(int t = 1; t <= nt; t++)
		{
			int n = in.nextInt();
			int[] c = new int[2500];
			for(int i = 0; i < (2*n-1)*n; i++)
				c[in.nextInt() - 1]++;
			System.out.print("Case #"+t+":");
			int j = 0;
			for(int i = 0; i < c.length; i++)
				if(c[i] % 2 != 0) {
					System.out.print(" " + (i+1));
					j++;
				}
			System.out.println();
			if(j != n)
				throw new AssertionError();
		}
	}
}
