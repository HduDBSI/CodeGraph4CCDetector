package googlejam3.p525;
import java.util.*;
import java.io.*;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfTests = sc.nextInt();

		for (int i = 1; i < numOfTests + 1; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int w = sc.nextInt();
			int val = 0;

			int div = c / w;
			if (c % w != 0) {
				div++;
			}

			System.out.println("Case #" + i + ": " + (r*(div+w-1)));

		}
	}
}