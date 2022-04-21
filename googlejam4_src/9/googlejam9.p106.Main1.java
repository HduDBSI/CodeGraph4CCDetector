package googlejam9.p106;
/**
 * File Name: Main.java
 * Package Name: com.ncfxy.MyAlgorithm
 * Description： TODO 
 *
 *   ver					date			author
 * ──────────────────────────────────
 *   1.0-SNAPSHOT			2016年4月9日			Administrator
 *
 * Copyright (c) 2016, ncfxy All Rights Reserved.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * ClassName: Main<br/>
 * Description: TODO ADD Description
 *
 * @author Administrator
 * @version 1.0-SNAPSHOT
 * @Date 2016 2016年4月9日 上午9:45:38
 */

public class Main1 {

	public static void main(String[] args) {

		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int t = cin.nextInt();
			for (int i = 0; i < t; i++) {
				int index = i + 1;
				long b = cin.nextLong();
				long m = cin.nextLong();
				long temp = 1;
				temp = temp << (b-2);
				if (m > temp) {
					System.out.println("Case #" + index + ": IMPOSSIBLE");
				} else {
					System.out.println("Case #" + index + ": POSSIBLE");
					long tmpM = m - 1;
					long index1 = 2;
					List<Long> list = new ArrayList<Long>();
					while (tmpM > 0) {
						if ((tmpM & 1) > 0) {
							list.add(index1);
						}
						tmpM = tmpM >> 1;
						index1++;
					}
					int matrix[][] = new int[60][60];
					for (int i3 = 1; i3 <= b; i3++) {
						for (int j = 1; j < b; j++) {
							if (i3 < j) {
								matrix[i3][j] = 1;
							} else {
								matrix[i3][j] = 0;
							}
						}
					}
					for (int i1 = 1; i1 <= b; i1++) {
						matrix[i1][(int) b] = 0;
					}
					for (int i2 = 0; i2 < list.size(); i2++) {
						long tmp = list.get(i2);
						matrix[(int) tmp][(int) b] = 1;
					}
					matrix[1][(int)b] = 1;
					for (int i4 = 1; i4 <= b; i4++) {
						for (int j = 1; j <= b; j++) {
							if (j == b) {
								System.out.println(matrix[i4][j]);
							} else {
								System.out.print(matrix[i4][j]);
							}
						}
					}
				}
			}
		}

	}

}
