package googlejam8.p471;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Senate{

	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter out = new PrintWriter(new File("Senate.out"));
		//Scanner s = new Scanner(System.in);
		Scanner s = new Scanner(new File("A-large.in"));
		int t = s.nextInt();
		for(int tests = 0; tests < t; ++tests) {
			out.print("Case #" + (tests + 1) + ": ");
			int n = s.nextInt();
			int total = 0;
			int senate[] = new int[n];
			for(int i = 0; i < n; ++i) {
				senate[i] = s.nextInt();
				total += senate[i];
			}
			boolean formatstarted = false;
			while(total != 0) {
				if(formatstarted)
					out.print(" ");
				int total1 = total;
				int highest = -1;
				int next = -1;
				int temp = 0;
				boolean onlyone = false;
				boolean usenext = true;
				int check = -1;
				// find highest, remove from array
				// find next, remove
				for(int i = 0; i < n; ++i) {
					if(senate[i] > temp) {
						highest = i;
						temp = senate[i];
					}
				}
				--senate[highest];
				--total1;
				temp = 0;
				for(int i = 0; i < n; ++i) {
					if(senate[i] > temp) {
						next = i;
						temp = senate[i];
					}
				}
				
				out.print((char) (highest + 'A'));
				
				if(next >= 0) {
					--senate[next];
					--total1;
					temp = 0;
					for(int i = 0; i < n; ++i) {
						if(senate[i] > 0 && !onlyone) {
							temp = 1;
							onlyone = true;
							usenext = false;
						}
						else if(senate[i] > 0 && onlyone) {
							usenext = true;
							break;
						}
					}
					if(usenext && next >= 0) {
						out.print((char) (next + 'A'));
					}
					else if (!usenext && next >= 0) {
						++senate[next];
						++total1;
					}
				}
				total = total1;
				formatstarted = true;
			}
			out.println();
		}
		out.close();
	}
}