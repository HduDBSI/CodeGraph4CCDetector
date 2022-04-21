package googlejam4.p007;
import static java.lang.Math.*;
import static java.util.Arrays.*;

import java.io.*;
import java.util.*;

public class A {
	
	PrintWriter out;
	
	int R, C;
	char[][] cs;
	
	char[] D = {'^', '<', 'v', '>'};
	int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	
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
			r.R = sc.nextInt();
			r.C = sc.nextInt();
			r.cs = new char[r.R][];
			for (int i1 = 0; i1 < r.R; i1++) r.cs[i1] = sc.next().toCharArray();
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
							boolean[][][] dame = new boolean[r.R][r.C][4];
							for (int d = 0; d < 4; d++) {
								for (int i = 0; i < r.R; i++) {
									for (int j = 0; j < r.C; j++) {
										int i1 = i - r.dx[d];
										int i2 = j - r.dy[d];
										if ((i == 0 || i == r.R - 1 || j == 0 || j == r.C - 1) && (!(0 <= i1 && i1 <= r.R - 1) || !(0 <= i2 && i2 <= r.C - 1))) {
											int x = i, y = j;
											while (0 <= x && x <= r.R - 1 && 0 <= y && y <= r.C - 1) {
												if (r.cs[x][y] != '.') {
													dame[x][y][d] = true;
													break;
												}
												x += r.dx[d];
												y += r.dy[d];
											}
										}
									}
								}
							}
							int res = 0;
							boolean impossible = false;
							for (int i = 0; i < r.R; i++) {
								for (int j = 0; j < r.C; j++) if (r.cs[i][j] != '.') {
									boolean ok = true, can = false;
									for (int k = 0; k < 4; k++) {
										if (r.cs[i][j] == r.D[k] && dame[i][j][k]) ok = false;
										if (!dame[i][j][k]) can = true;
									}
									if (!ok) res++;
									if (!can) impossible = true;
								}
							}
							if (impossible) r.out.println("IMPOSSIBLE");
							else r.out.println(res);
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
