package googlejam1.p749;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Mushrooms {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("in"));
		PrintWriter out = new PrintWriter("out");
		int T = in.nextInt();
		
		for (int r = 1; r <= T;r++) {
			int n = in.nextInt();
			int prev = 0;
			int curr = 0;
			int f = 0;
			int s = 0;
			int[] arr = new int[n];
			int maxDiff = 0;
			for (int i = 0;i < n;i++) {
				prev = curr;
				curr = in.nextInt();

				int diff = prev - curr;
				if (maxDiff < diff)
					maxDiff = diff;
				
				if (prev > curr) {
					f += diff;
				}
				
				arr[i] = curr;
				
				prev = curr;
			}
			
			for (int i = 0; i < arr.length-1;i++) {
//				System.out.println(s);
				s += maxDiff > arr[i] ? arr[i] : maxDiff;
			}
			System.out.println("Case #" + r + ": " + f + " " + s);
			out.println("Case #" + r + ": " + f + " " + s);
		}
		
		out.close();
		in.close();
	}

}
