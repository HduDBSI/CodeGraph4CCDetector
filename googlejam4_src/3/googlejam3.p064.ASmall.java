package googlejam3.p064;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class ASmall {
	
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("A-large.in"));
		PrintWriter out = new PrintWriter(new File("outputALarge.txt"));
		int t = in.nextInt();
		for (int testn = 1; testn <= t; testn++) {
			int R = in.nextInt();
			int C = in.nextInt();
			int W = in.nextInt();
			int ans = (R - 1) * (C / W);
			if (C % W == 0) ans += (C / W) + W - 1; else ans += (C / W) + W;
			out.println("Case #" + testn + ": " + ans);
		}
		in.close();
		out.close();
	}
	
	
}
