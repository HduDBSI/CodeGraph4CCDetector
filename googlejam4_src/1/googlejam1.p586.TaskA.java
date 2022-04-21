package googlejam1.p586;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA {
	
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("C:\\Users\\Grzegorz\\workspace_juno\\CodeJam2015\\src\\pl\\gg\\codejam2015\\round1\\taskA\\A-large.in"));
		//System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\Grzegorz\\workspace_juno\\CodeJam2015\\src\\pl\\gg\\codejam2015\\round1\\taskA\\A-large.out")));
		
		try (Scanner in = new Scanner(System.in)) {
			
			int cases = in.nextInt();
			for (int i = 0; i < cases; i++) {
				int nSeconds = in.nextInt();
				List<Integer> seconds = new ArrayList<>(nSeconds);
				
				for (int j = 0; j < nSeconds; j++) {
					int second = in.nextInt();
					seconds.add(second);
				}
				int res = 0;
				
				for (int i1 = 1; i1 < seconds.size(); i1++) {
					if (seconds.get(i1 - 1) > seconds.get(i1)) {
						res += seconds.get(i1 - 1) - seconds.get(i1);
					}
				}
				
				int res1 = res;
				int maxD = 0;
				
				for (int i1 = 1; i1 < seconds.size(); i1++) {
					if (seconds.get(i1 - 1) - seconds.get(i1) > maxD) {
						maxD = seconds.get(i1 - 1) - seconds.get(i1);
					}
				}
				
				int res3 = 0;
				
				for (int i2 = 0; i2 < seconds.size() - 1; i2++) {
					if (seconds.get(i2) > maxD) {
						res3 += maxD;
					} else {
						res3 += seconds.get(i2);
					}
				}
				int res2 = res3;
				
				System.out.println("Case #" + (i + 1) + ": " + res1 + " " + res2);
			}
		}
	}
}
