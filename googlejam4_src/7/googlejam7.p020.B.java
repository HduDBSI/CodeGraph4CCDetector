package googlejam7.p020;


import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class B
{

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		//PrintWriter out = new PrintWriter(System.out);
		PrintWriter out = new PrintWriter(new File("B.out"));
		
		for (int t = Integer.valueOf(in.nextLine()), cs = 1; t > 0; t--, cs++) {
			out.print("Case #" + cs + ": ");
			
			String[] s = in.nextLine().split(" +");
			char[] a = s[0].toCharArray();
			char[] b = s[1].toCharArray();
			int n = a.length;
			
			int p = -1;
			for (int i = 0; i < n && p == -1; i++) {
				if (a[i] != '?' && b[i] != '?' && a[i] != b[i]) {
					p = i;
				}
			}
			
			if (p == -1) {
				for (int i = 0; i < n; i++) {
					if (a[i] == '?' && b[i] == '?') {
						a[i] = b[i] = '0';
					} else if (a[i] == '?') {
						a[i] = b[i];
					} else if (b[i] == '?') {
						b[i] = a[i];
					}
				}
				out.println(String.valueOf(a) + " " + String.valueOf(b));
				continue;
			}
			
			int q = -1;
			for (int i = p-1; i >= 0 && q == -1; i--) {
				if (a[i] == '?' || b[i] == '?') {
					q = i;
				}
			}
			
			if (q == -1) {
				boolean gr = a[p] > b[p];
				for (int i = 0; i < n; i++) {
					if (a[i] == '?') {
						a[i] = gr ? '0' : '9';
					}
					if (b[i] == '?') {
						b[i] = gr ? '9' : '0';
					}
				}
				out.println(String.valueOf(a) + " " + String.valueOf(b));
				continue;
			}
			
			boolean gr = a[p] > b[p];
			
			char[] c1 = Arrays.copyOf(a, n);
			char[] d1 = Arrays.copyOf(b, n);
			for (int i1 = 0; i1 < p; i1++) {
				if (c1[i1] == '?' && d1[i1] == '?') {
					c1[i1] = d1[i1] = '0';
				} else if (c1[i1] == '?') {
					c1[i1] = d1[i1];
				} else if (d1[i1] == '?') {
					d1[i1] = c1[i1];
				}
			}
			for (int i2 = p+1; i2 < c1.length; i2++) {
				if (c1[i2] == '?') {
					c1[i2] = gr ? '0' : '9';
				}
				if (d1[i2] == '?') {
					d1[i2] = gr ? '9' : '0';
				}
			}
			long ans1 = Math.abs(Long.valueOf(String.valueOf(c1)) - Long.valueOf(String.valueOf(d1)));
			
			for (int i = q; i >= 0; i--) {
				if (a[i] != '?' && b[i] != '?') {
					continue;
				}
				char[] c2 = Arrays.copyOf(a, n);
				char[] d2 = Arrays.copyOf(b, n);
				if (gr) {
					if (c2[i] == '9' || d2[i] == '0') {
						continue;
					}
					if (c2[i] == '?' && d2[i] == '?') {
						c2[i] = '0';
						d2[i] = '1';
					} else if (c2[i] == '?') {
						c2[i] = (char)(d2[i] - 1);
					} else if (d2[i] == '?') {
						d2[i] = (char)(c2[i] + 1);
					}
				} else {
					if (c2[i] == '0' || d2[i] == '9') {
						continue;
					}
					if (c2[i] == '?' && d2[i] == '?') {
						c2[i] = '1';
						d2[i] = '0';
					} else if (c2[i] == '?') {
						c2[i] = (char)(d2[i] + 1);
					} else if (d2[i] == '?') {
						d2[i] = (char)(c2[i] - 1);
					}
				}
				boolean gr1 = !gr;
				for (int i3 = 0; i3 < i; i3++) {
					if (c2[i3] == '?' && d2[i3] == '?') {
						c2[i3] = d2[i3] = '0';
					} else if (c2[i3] == '?') {
						c2[i3] = d2[i3];
					} else if (d2[i3] == '?') {
						d2[i3] = c2[i3];
					}
				}
				for (int i4 = i+1; i4 < c2.length; i4++) {
					if (c2[i4] == '?') {
						c2[i4] = gr1 ? '0' : '9';
					}
					if (d2[i4] == '?') {
						d2[i4] = gr1 ? '9' : '0';
					}
				}
				long ans2 = Math.abs(Long.valueOf(String.valueOf(c2)) - Long.valueOf(String.valueOf(d2)));
				if (ans2 < ans1) {
					c1 = c2;
					d1 = d2;
					ans1 = ans2;
				} else if (ans2 == ans1) {
					if (Long.valueOf(String.valueOf(c2)) < Long.valueOf(String.valueOf(c1))) {
						c1 = c2;
						d1 = d2;
						ans1 = ans2;
					} else if (Long.valueOf(String.valueOf(c2)) == Long.valueOf(String.valueOf(c1))) {
						if (Long.valueOf(String.valueOf(d2)) < Long.valueOf(String.valueOf(d1))) {
							c1 = c2;
							d1 = d2;
							ans1 = ans2;
						}
					}
				}
			}
			
			out.println(String.valueOf(c1) + " " + String.valueOf(d1));
		}

		out.flush();
	}
}
