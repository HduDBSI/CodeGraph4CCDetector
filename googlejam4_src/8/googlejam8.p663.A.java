package googlejam8.p663;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Locale;
import java.util.Scanner;

public class A {
	static final String INPUT_FILE = "1C/A/large.in";
	static final String OUTPUT_FILE = "1C/A/large-output.txt";

	
	public static void main(String args[]) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(new File(INPUT_FILE));
		BufferedWriter out = new BufferedWriter(new FileWriter(new File(OUTPUT_FILE)));
		

		int T = in.nextInt();
		
		in.nextLine();
		
		for (int t = 1; t <= T; t++) {
			String result = "";
			
			int N = in.nextInt();
			
			int[] P = new int[N];
			
			for (int i = 0; i < N; i++) {
				P[i] = in.nextInt();
			}
			
			int num = 0;
			for (int i = 0; i < N; i++) {
				num += P[i];
			}
			

			int max1 = 0;
			for (int i = 0; i < N; i++) {
				if (P[max1] < P[i]) {
					max1 = i;
				}
			}
			
			int max2 = 0;
			for (int i = 0; i < N; i++) {
				if (i != max1 && (max1 == max2 || P[max2] < P[i])) {
					max2 = i;
				}
			}
				
			while (P[max1] > P[max2]) {
				result += (char) ('A' + max1);
				P[max1]--;
				num--;
				if (P[max1] > P[max2]) {
					result += (char) ('A' + max1);
					P[max1]--;
					num--;
				}
				result += " ";
			}

			for (int i = 0; i < N; i++) {
				if (i != max1 && i != max2) {
					while (P[i] > 0) {
						result += (char) ('A' + i);
						P[i]--;
						num--;
						if (P[i] > 0) {
							result += (char) ('A' + i);
							P[i]--;
							num--;
						}
						result += " ";
					}
				}
			}

			while (P[max1] > 0) {
				result += (char) ('A' + max1);
				P[max1]--;
				num--;
				if (P[max2] > 0) {
					result += (char) ('A' + max2);
					P[max2]--;
					num--;
				}
				result += " ";
			}
			
			System.out.println("Case #" + t + ": " + result);
			out.append("Case #" + t + ": " + result);
			out.newLine();
		}
		
		
		in.close();
		out.close();
	}
	
	
}
