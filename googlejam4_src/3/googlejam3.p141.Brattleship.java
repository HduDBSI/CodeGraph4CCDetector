package googlejam3.p141;


import java.io.*;
import java.util.*;

public class Brattleship {
	public static Scanner in = new Scanner(System.in);
	public static PrintWriter PW = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException {
		int cases = in.nextInt();

		for (int c = 1; c <= cases; c++) {
			int result=0;
			int R = in.nextInt(), C = in.nextInt(), W=in.nextInt();
			
			result = R*((C+W-1)/W)+W-1;
			
			PW.println("Case #" + c + ": " + result);
		}

		PW.close();
	}
}