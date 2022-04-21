package googlejam1.p121;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class ProblemA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("A-large.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("LargeProblemA.out"));
		int numTestCases = Integer.parseInt(br.readLine());
		for (int i = 1; i <= numTestCases; i++){
			int arrsize = Integer.parseInt(br.readLine());
			String line = br.readLine();
			String[] list = line.split(" ");
			Integer[] result = new Integer[list.length];
			int minEaten = 0;
			int minRate = 0;
			for (int iii = 0; iii < arrsize; iii++) {
				result[iii] = Integer.parseInt(list[iii]);
				if (iii > 0) {
					int rate = Math.max(0, result[iii-1] - result[iii]);
					minEaten += rate;
					minRate = Math.max(minRate, rate);
				}
			}
			int totalEaten = 0;
			for(int jjj = 0; jjj < arrsize-1; jjj++) {
				totalEaten += Math.min(minRate, result[jjj]);
			}
			
			bw.write("Case #" + i + ": " + minEaten + " " + totalEaten + "\n");
		}
		br.close();
		bw.close();
	}
}
