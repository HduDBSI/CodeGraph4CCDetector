package googlejam8.p826;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class A {
	public static void main(String args[]) throws Exception {
//	    File file = new File("C:\\Users\\oleksii\\workspace\\GCodeJam\\src\\small.in");
//	    File outFile = new File("C:\\Users\\oleksii\\workspace\\GCodeJam\\src\\small.out");
//	    File file = new File("C:\\Users\\oleksii\\workspace\\GCodeJam\\src\\A-small-attempt1.in");
//	    File outFile = new File("C:\\Users\\oleksii\\workspace\\GCodeJam\\src\\A-small-attempt1.out");
	    File file = new File("C:\\Users\\oleksii\\workspace\\GCodeJam\\src\\A-large.in");
	    File outFile = new File("C:\\Users\\oleksii\\workspace\\GCodeJam\\src\\A-large.out");
	    BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
    	Scanner scanner = new Scanner(file);
		int T = Integer.parseInt(scanner.nextLine()), count = 0, N = 0, max = 0, prevMax = 0, idx = 0;
		int[] parties;
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder output;
		char one, two;
		boolean stop = false;
		for(int t = 1; t <= T; t++) {
			output = new StringBuilder();
			stop = false;
			N = Integer.parseInt(scanner.nextLine());
			parties = new int[N];
			for(int n = 0; n < N; n++) {
				parties[n] = scanner.nextInt();
			}
			while(!stop) {
				max = 0;
				count = 0;
				prevMax = -1;
				idx = -1;
				for (int i = 0; i < N; i++) {
					if (max < parties[i]) {
						prevMax = idx;
						max = parties[i];
						idx = i;
						count = 1;
					} else if (max == parties[i]) {
						prevMax = i;
						count++;
					}
				}
				if (max == 0) {
					stop = true;
					break;
				} else if (max == 1 && prevMax >= 0 && parties[prevMax] == 1) {
					output.append(alphabet.charAt(idx));
					parties[idx]--;
					if (count != 3) {
						output.append(alphabet.charAt(prevMax));
						parties[prevMax]--;
					}
					output.append(" ");
				} else if (max <= 2) {
					output.append(alphabet.charAt(idx));
					parties[idx]--;
					if (prevMax >= 0 && parties[prevMax] > 1) {
						output.append(alphabet.charAt(prevMax));
						parties[prevMax]--;
					}
					output.append(" ");
				} else if (prevMax >= 0 && max == parties[prevMax]) {
					output.append(alphabet.charAt(idx));
					parties[idx]--;
					output.append(alphabet.charAt(prevMax));
					parties[prevMax]--;
					output.append(" ");
				} else {
					output.append(alphabet.charAt(idx));
					output.append(alphabet.charAt(idx));
					parties[idx] -= 2;
					output.append(" ");
				}
			}
			System.out.println(output);
		    bw.write("Case #"+t+": "+output.toString());
		    if (t != T) {
		    	bw.write("\n");
				scanner.nextLine();
			}
		}
		bw.close();
		System.out.println("Done!");
	}
}
