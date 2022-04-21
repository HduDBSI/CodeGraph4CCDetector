package googlejam1.p058;
import java.io.*;
import java.util.*;

public class A {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/A-large.in"))));

		String output = "";
		int t = sc.nextInt();
		sc.nextLine();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int[] intervals = new int[n];
			for (int j = 0; j < n; j++) {
				intervals[j] = sc.nextInt();
			}
			int y = 0;
			int minPerInterval = 0;
			for (int j = 1; j < n; j++) {
				if (intervals[j] < intervals[j-1]) {
					y += intervals[j-1]-intervals[j];
					if (intervals[j-1]-intervals[j] > minPerInterval)
						minPerInterval = intervals[j-1]-intervals[j];
				}
			}
			int z = 0;
			for (int j = 0; j < n-1; j++) {
				z += Math.min(minPerInterval, intervals[j]);
			}
			output += "Case #" + i + ": " + y + " " + z + "\n";
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/A-large.out"), "utf-8"));
		bw.write(output);
		bw.close();
	}
}