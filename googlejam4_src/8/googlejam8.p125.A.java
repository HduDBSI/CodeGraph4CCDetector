package googlejam8.p125;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class A {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		String filename = "A-large";
		Scanner sc = new Scanner(new File(filename + ".in"));
//		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(filename + ".out", "UTF-8");
		while(sc.hasNext()) {
			int T = sc.nextInt();
			for(int i = 1; i <= T; i++) {
				int N = sc.nextInt();
				int[] P = new int[N];
				for(int j = 0; j < N; j++) {
					P[j] = sc.nextInt();
				}
				System.out.print("Case #" + i + ":");
				pw.print("Case #" + i + ":");
				int[] PS = Arrays.copyOf(P,P.length);
				Arrays.sort(PS);
				int max = PS[N-1];
				int maxes;
				while(max > 0) {
//					System.out.println(Arrays.toString(P));
					maxes = 0;
					for(int j = 0; j < N; j++) {
						if(PS[j] == PS[N-1]) maxes++;
					}
					if(maxes==2) {
						int j = 0;
						int a = -1, b = -1;
						for(j = 0; j < N; j++) {
							if(P[j] == max) {
								if(a == -1) a = j;
								else b = j;
							}
						}
						P[a]--;
						P[b]--;
						System.out.print(" " + (char)('A' + a));
						System.out.print((char)('A' + b));
						pw.print(" " + (char)('A' + a));
						pw.print((char)('A' + b));
					} else {
						for(int j = 0; j < N; j++) {
							if(P[j] == max) {
								P[j]--;
								System.out.print(" " + (char)('A' + j));
								pw.print(" " + (char)('A' + j));
								break;
							}
						}
					}
					PS = Arrays.copyOf(P,P.length);
					Arrays.sort(PS);
					max = PS[N-1];
				}
				

				System.out.println();
				pw.println();
				
				
				
//				while(nonzero > 0) {
//					System.out.println(Arrays.toString(P));
//					if(nonzero == 2) {
//						int a = -1, b = -1;
//						int j = 0;
//						for(j = 0; j < N; j++) {
//							if(P[j] > 0) {
//								a = j;
//								break;
//							}
//						}
//						for(j++; j < N; j++) {
//							if(P[j] > 0) {
//								b = j;
//								break;
//							}
//						}
//						int c = Math.min(P[a], P[b]);
//						str = new StringBuilder(str).reverse().toString();
//						for(j = 0; j < c; j++) {
//							str += " " + (char)('A' + a);
//							str += (char)('A' + b);
//						}
//						str = new StringBuilder(str).reverse().toString();
//						P[a] -= c;
//						P[b] -= c;
//						if(P[a] == 0) nonzero--;
//						if(P[b] == 0) nonzero--;
//					} else {
//						for(int j = 0; j < N; j++) {
//							if(P[j] > 0) {
//								str += (char)('A' + j) + " ";
//								if(P[j] == 1) nonzero--;
//								P[j]--;
//							}
//						}
//					}
//				}
			}
			pw.close();
		}
	}

}
