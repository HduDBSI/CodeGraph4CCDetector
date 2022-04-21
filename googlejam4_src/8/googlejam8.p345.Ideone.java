package googlejam8.p345;
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Scanner scn = new Scanner(System.in);
		int $ = scn.nextInt();
		for (int cas = 0; cas < $; cas++) {
			StringJoiner sj = new StringJoiner(" ");
		
			int N = scn.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = scn.nextInt();
			}
			
			while (true) {
				String s = "";
				int sum = 0;
				for (int i : arr)
					sum += i;
				
				if (sum == 0)
					break;
				
				int max = 0;
				int ind = -1;
				
				for (int $$ = 2-(sum%2); $$ > 0; $$--) {
					ind = -1;
					for (int i = 0; i < N; i++) {
						if (ind == -1 || arr[i] > max) {
							max = arr[i];
							ind = i;
						}
					}
					s += alphabet.charAt(ind);
					arr[ind]--;
				}
				
				sj.add(s);
				
			}
			System.out.printf("Case #%d: %s\n", cas+1, sj);
		}
	}
}
