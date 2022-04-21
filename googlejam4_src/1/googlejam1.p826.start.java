package googlejam1.p826;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class start {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("A-large.in"));
		FileWriter fw = new FileWriter(new File("outputLarge.txt"));
		int numTestCases = sc.nextInt();
		for (int testCaseNum = 0; testCaseNum < numTestCases; testCaseNum++) {

			// Parse test case
			int numStates = sc.nextInt();
			
			int diff = 0;
			int maxEatPerState = 0;
			
			int[] states = new int[numStates];
			for (int state = 0; state < numStates; state++) {
				int numMushrooms = sc.nextInt();
				states[state] = numMushrooms;
			}
			
			int sumEat = 0;
			for (int state = 1; state < numStates; state++) {
				diff = states[state] - states[state - 1];
				if (diff < 0) {
					int d = -1 * diff;
					if (maxEatPerState < d) {
						maxEatPerState = d;
					}
					sumEat += d;
				}		
			}
			
			int m2Eat = 0;
			for (int state = 0; state < numStates-1; state++) {
				int numMushrooms = states[state];
				if (numMushrooms < maxEatPerState) {
					m2Eat += numMushrooms;
				}else{
					m2Eat += maxEatPerState;
				}
				System.out.println(m2Eat);
			}
			System.out.printf("Case #%d: %d %d %d%n", testCaseNum+1, sumEat, m2Eat, maxEatPerState);
			fw.write(String.format("Case #%d: %d %d%n", testCaseNum+1, sumEat, m2Eat));
			
		}
		
		fw.close();
		
	}

}
