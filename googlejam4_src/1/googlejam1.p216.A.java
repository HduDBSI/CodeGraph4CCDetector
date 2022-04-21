package googlejam1.p216;
import java.util.*;
import java.io.*;

public class A {

    public static void main(String[] args) throws FileNotFoundException {
        A r = new A();
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("al.in"));
		PrintWriter out = new PrintWriter("al.out");
		int t = in.nextInt();
		for (int test = 1; test <= t; test++) {
		    int n = in.nextInt();
		    int[] a = new int[n];
		    for (int i = 0; i < n; i++)
		        a[i] = in.nextInt();
		    int cnt1 = 0;
		    for (int i = 0; i < n - 1; i++)
		        if (a[i + 1] < a[i])
		            cnt1 += a[i] - a[i + 1];
		
		    int max = 0;
		    for (int i = 0; i < n - 1; i++)
		        if (a[i] > a[i + 1])
		            max = Math.max(max, a[i] - a[i + 1]);
		    int cnt2 = 0;
		    for (int i = 0; i < n - 1; i++)
		        cnt2 += Math.min(max, a[i]);
		    //System.out.println("Case #" + test+ ": " + cnt1 + " " + cnt2);
		    out.println("Case #" + test+ ": " + cnt1 + " " + cnt2);
		}
		
		out.close();
    }
}