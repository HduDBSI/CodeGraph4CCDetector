package googlejam9.p068;
import java.util.*;
import java.io.*;

public class q2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int i=1; i<=t; i++) {
			System.out.print("Case #" + i + ": ");
			int b = in.nextInt();
			long m = in.nextLong();
			if (Math.pow(2, b-2)<m) {
				System.out.println("IMPOSSIBLE");
			}
			else {
				System.out.println("POSSIBLE");
				for (int j=1; j<=b; j++) {
					if (j==1) {
						String first="0";
						for (int a=0; a<b; a++) {
							if (((long)Math.pow(2, b-2)==m)) {
								if (a>0)
									first +='1';
							}
							else  if (a==0){
								first += Long.toBinaryString(m);
								first = first + "0";
								while (first.length()<b) {
									first = "0" + first;
								}
							}
						}
						System.out.println(first);
					}
					else {
						for (int k=1; k<=b; k++) {
							if (k>j) {
								System.out.print("1");
							}
							else {
								System.out.print("0");
							}
						}
						System.out.println();
					}
				}
			}
		}
	}
}