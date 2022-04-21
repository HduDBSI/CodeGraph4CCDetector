package googlejam3.p089;

import java.io.*;
import java.util.*;

public class A {
	public static void main (String[] args) {
		A r = new A();
		try {
			BufferedReader in = new BufferedReader(new FileReader(args[0]));
		    PrintStream out = new PrintStream(args[0] + ".out");
			int CASES = Integer.parseInt(in.readLine());
			for (int CASE = 1 ; CASE <= CASES ; CASE++) {
				String[] words = in.readLine().split(" ");
				int[] ret = new int[words.length];
				for (int i = 0 ; i < words.length ; i++) ret[i] = Integer.parseInt(words[i]);
				int[] input = ret;
				int R = input[0];
				int C = input[1];
				int W = input[2];
				int val = R * C / W + (C % W == 0 ? 0 : 1) + W - 1;
				out.printf("Case #%d: %d\n", CASE, val);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
