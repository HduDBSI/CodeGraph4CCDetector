package googlejam8.p825;


import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		//FileInputStream fi = new FileInputStream("small.in");
		//FileOutputStream fo = new FileOutputStream("small.out");

		FileInputStream fi = new FileInputStream("large.in");
		FileOutputStream fo = new FileOutputStream("large.out");

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fo));

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(fi)));
		int cases = in.nextInt();
		for (int i = 1; i <= cases; ++i) {
			System.out.print("Case #" + i + ":");
			bw.write("Case #" + i + ":");

			int N = in.nextInt();
			int[]P = new int[N];

			int M = 0;
			for (int j = 0; j < N; ++j) {
		    	P[j] = in.nextInt();
		    	M += P[j];
			}

			while(true) {
				int max = -1;
				int imax = -1;
				for (int j = 0; j < N; ++j) {
					if(P[j] != 0 && P[j] > max) {
						max = P[j];
						imax = j;
					}
				}
				if(max == -1)
					break;
				--P[imax];
				--M;
				char x = (char)('A' + imax);

				for (int j = 0; j < N; ++j)
					if(P[j] > M/2) {
//						System.out.print("XXXX");
					}

				System.out.print(" " + x);
				bw.write(" " + x);

				if(M != 2) {
					max = -1;
					imax = -1;
					for (int j = 0; j < N; ++j) {
						if(P[j] != 0 && P[j] > max) {
							max = P[j];
							imax = j;
						}
					}
					if(max == -1)
						break;
					--P[imax];
					--M;
					char x2 = (char)('A' + imax);
	
					System.out.print(x2);
					bw.write("" + x2);
	
					for (int j = 0; j < N; ++j)
						if(P[j] > M/2)
							System.out.print("YYYY");
				}
			}

			System.out.println("");
			bw.write("\n");
		}
		bw.close();
	}
}