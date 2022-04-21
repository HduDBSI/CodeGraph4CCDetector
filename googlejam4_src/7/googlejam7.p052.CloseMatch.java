package googlejam7.p052;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class CloseMatch {
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new BufferedReader(new FileReader(new File("B-large.in")), 256 << 10));
			BufferedWriter out = new BufferedWriter(new FileWriter(new File("output.txt")), 256 << 10);

			int testsNumber = in.nextInt();
			for (int testId = 1; testId <= testsNumber; testId++) {
				String s1 = in.next();
				String s2 = in.next();
				int n = s1.length();
				String br1 = "", br2 = "";
				long bestDiff = Long.MAX_VALUE;
				long min1 = Long.MAX_VALUE;
				long min2 = Long.MAX_VALUE;
				out.append("Case #" + testId + ": ");
				for (int fd = -1; fd <= 1; fd++) 
					for (int fdp = 0; fdp < n; fdp++) {
						String r1 = "", r2 = "";
						int d = 0;
						for (int i = 0; i < n; i++) {
							char ch1 = s1.charAt(i);
							char ch2 = s2.charAt(i);
							if (ch1 == '?') {
								if (ch2 == '?') {
									if (d == 0) {
										if (i == fdp) {
											if (fd < 0) {
												ch1 = '0';
												ch2 = '1';
											}
											if (fd == 0) {
												ch1 = '0';
												ch2 = '0';
											}
											if (fd > 0) {
												ch1 = '1';
												ch2 = '0';
											}
											d = ch1-ch2;
										}
										else {
											ch1 = '0';
											ch2 = '0';
										}
									}
									else if (d < 0) {
										ch1 = '9';
										ch2 = '0';
									}
									else if (d > 0) {
										ch1 = '0';
										ch2 = '9';
									}
								}
								else {
									if (d == 0) {
										if (i == fdp) {
											if (fd < 0) {
												ch1 = (char) Math.max('0', ch2-1);
											}
											if (fd == 0) {
												ch1 = ch2;												
											}
											if (fd > 0) {
												ch1 = (char) Math.min('9', ch2+1);
											}
											d = ch1-ch2;
										}
										else {
											ch1 = ch2;
										}
									}
									else if (d < 0) {
										ch1 = '9';
									}
									else if (d > 0) {
										ch1 = '0';
									}							
								}
							}
							else {
								if (ch2 == '?') {
									if (d == 0) {
										if (i == fdp) {
											if (fd < 0) {
												ch2 = (char) Math.min('9', ch1+1);
											}
											if (fd == 0) {
												ch2 = ch1;												
											}
											if (fd > 0) {
												ch2 = (char) Math.max('0', ch1-1);
											}
											d = ch1-ch2;
										}
										else {
											ch2 = ch1;
										}
									}
									else if (d < 0) {
										ch2 = '0';
									}
									else if (d > 0) {
										ch2 = '9';
									}
								}
								else {
									if (d == 0) {
										if (ch1 < ch2)
											d = -1;
										if (ch1 == ch2)
											d = 0;
										if (ch1 > ch2)
											d = 1;
									}
								}
							}
							r1 += ch1;
							r2 += ch2;
						}
					long v1 = Long.valueOf(r1);
					long v2 = Long.valueOf(r2);
					if (Math.abs(v1-v2) < bestDiff || (Math.abs(v1-v2) == bestDiff && v1 < min1)
							|| (Math.abs(v1-v2) == bestDiff && v1 == min1 && v2 < min2)) {
						bestDiff = Math.abs(v1-v2);
						min1 = v1;
						min2 = v2;
						br1 = r1;
						br2 = r2;
					}
				}
				out.append(br1 + " " + br2);
				out.append("\n");
			}
			in.close();
			out.close();
		}
		catch (RuntimeException rte) {
			throw rte;
		}
		catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
		}
	}
}
