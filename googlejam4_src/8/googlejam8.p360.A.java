package googlejam8.p360;


import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {
	static Scanner scan;
	static PrintWriter writer;

	public static void main(String[] args) {
		File file = new File("D://A-large.in");
		File out = new File("D://outA.txt");
		try {
			scan = new Scanner(file);
			writer = new PrintWriter(out);
			int t = scan.nextInt();
			for (int i = 1; i <= t; i++) {
				writer.print("Case #" + i + ": ");
				// input go here
				int P = scan.nextInt();
				List<Integer> list = new ArrayList<Integer>();

				for (int j = 0; j < P; j++) {
					list.add(scan.nextInt());
				}

				if (list.size() == 2) {
					int min = 0;
					if (list.get(0) > list.get(1)) {
						min = list.get(1);
						for (int i3 = 0; i3 < list.get(0) - list.get(1); i3++) {
							writer.print("A ");
						}
					} else {
						min = list.get(0);
						for (int i4 = 0; i4 < list.get(1) - list.get(0); i4++) {
							writer.print("B ");
						}
					}
					for (int i1 = 0; i1 < min; i1++) {
						writer.print("AB ");
					}
					writer.println();
				} else {
				
					while (true) {
						int max = -1, imax = -1;
						int sum = 0;
						for (int i5 = 0; i5 < list.size(); i5++) {
							sum += list.get(i5);
							if (list.get(i5) > max) {
								max = list.get(i5);
								imax = i5;
							}
						}
				
						if (sum > 2) {
							writer.print((char) ('A' + imax) + " ");
							list.set(imax, list.get(imax) - 1);
						} else {
							for (int i2 = 0; i2 < list.size(); i2++) {
								if (list.get(i2) > 0) {
									writer.print((char) ('A' + i2));
								}
							}
							writer.println("");
							break;
						}
					}
				}
			}
		} catch (Exception ex) {

		} finally {
			writer.close();
		}
	}

}
