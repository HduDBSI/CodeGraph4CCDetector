package googlejam5.p005;
import static java.lang.Math.*;
import static java.util.Arrays.*;

import java.io.*;
import java.util.*;

public class A {
	
	PrintWriter out;
	
	int N, D;
	long S0, As, Cs, Rs;
	long M0, Am, Cm, Rm;
	
	int[] S;
	int[] M;
	
	public static int __ID = 0;
	public static boolean __ERROR = false;
	
	public static void main(String[] args) {
		int pN = 1;
		if (args.length == 0) {
			try {
				System.setIn(new BufferedInputStream(new FileInputStream(A.class.getName() + ".in")));
			} catch (Exception e) {
			}
		} else {
			pN = Integer.parseInt(args[0]);
		}
		PrintStream out = System.out;
		System.setOut(null);
		Scanner sc = new Scanner(System.in);
		final int caseN = sc.nextInt();
		final A[] solvers = new A[caseN];
		StringWriter[] outs = new StringWriter[caseN];
		for (int i = 0; i < caseN; i++) {
			solvers[i] = new A();
			outs[i] = new StringWriter();
			solvers[i].out = new PrintWriter(outs[i]);
			solvers[i].out.printf("Case #%d: ", i + 1);
			A r = solvers[i];
			r.N = sc.nextInt();
			r.D = sc.nextInt();
			r.S0 = sc.nextLong();
			r.As = sc.nextLong();
			r.Cs = sc.nextLong();
			r.Rs = sc.nextLong();
			r.M0 = sc.nextLong();
			r.Am = sc.nextLong();
			r.Cm = sc.nextLong();
			r.Rm = sc.nextLong();
		}
		Thread[] ts = new Thread[pN];
		for (int i = 0; i < pN; i++) {
			ts[i] = new Thread() {
				@Override
				public void run() {
					for (;;) {
						int id;
						synchronized (A.class) {
							if (__ID == caseN) return;
							id = __ID++;
						}
						try {
							A r = solvers[id];
							r.S = new int[r.N];
							r.M = new int[r.N];
							r.S[0] = (int)r.S0;
							r.M[0] = (int)r.M0;
							for (int i1 = 1; i1 < r.N; i1++) {
								r.S[i1] = (int)((r.S[i1 - 1] * r.As + r.Cs) % r.Rs);
								r.M[i1] = (int)((r.M[i1 - 1] * r.Am + r.Cm) % r.Rm);
							}
							r.M[0] = 0;
							for (int i2 = 1; i2 < r.N; i2++) r.M[i2] %= i2;
							int[] min = new int[r.N], max = new int[r.N];
							min[0] = max[0] = r.S[0];
							for (int i = 1; i < r.N; i++) {
								min[i] = max[i] = r.S[i];
								min[i] = min(min[i], min[r.M[i]]);
								max[i] = max(max[i], max[r.M[i]]);
							}
							int[] sum = new int[1000010];
							for (int i = 0; i < r.N; i++) if (min[i] + r.D >= max[i]) {
								sum[max(0, max[i] - r.D)]++;
								sum[min[i] + 1]--;
							}
							for (int i = 0; i < sum.length - 1; i++) {
								sum[i + 1] += sum[i];
							}
							int res = 0;
							for (int i = 0; i < sum.length; i++) res = max(res, sum[i]);
							r.out.println(res);
						} catch (RuntimeException e) {
							__ERROR = true;
							System.err.printf("Error in case %d:%n", id + 1);
							e.printStackTrace();
						}
						solvers[id].out.flush();
						solvers[id] = null;
					}
				}
			};
			ts[i].start();
		}
		for (int i = 0; i < pN; i++) {
			try {
				ts[i].join();
			} catch (InterruptedException e) {
				i--;
				continue;
			}
		}
		for (int i = 0; i < caseN; i++) {
			out.print(outs[i].toString());
		}
		if (__ERROR) out.printf("%nError occured!!!%n");
	}
	
}
