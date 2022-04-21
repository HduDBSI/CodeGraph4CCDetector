package googlejam2.p359;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class ASmall {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("A-small-attempt2.in"));
		PrintWriter out = new PrintWriter(new File("outputASmall.txt"));
		int t = in.nextInt();
		for (int testn = 1; testn <= t; testn++) {
			int [] a  = new int[1000001];
			a[0] = 1;
			int n = in.nextInt();
			int ans = 0;		
			LinkedList<Integer> d = new LinkedList<Integer>();
			d.add(1);
			while (!d.isEmpty())
			
			{
				int k = d.poll();
				//System.out.println(k);
				if (k == n) { /*System.out.println(k);*/ ans = a[n - 1]; break; }
				int k1 = k;
				int cur = 0;
				while (k1 > 0)
				{
					cur = cur * 10 + (k1 % 10);
					k1 = k1 / 10;
				}
				int r = cur;
				if (r <= n && a[r - 1] == 0) { a[r - 1] = a[k - 1] + 1; d.add(r); }
				if (a[k + 1] == 0) { a[k] = a[k - 1] + 1; d.add(k + 1); }
				
			}
			out.println("Case #" + testn + ": " + ans);
			//System.out.println(ans);
		}
		//System.out.println(reverse(11112220));
		in.close();
		out.close();
	}
	
	
}
