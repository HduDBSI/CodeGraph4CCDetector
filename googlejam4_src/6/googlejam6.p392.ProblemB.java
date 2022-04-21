package googlejam6.p392;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class ProblemB {
	
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		
		// Get the number of test cases
		int totalCases = inputScanner.nextInt();
		for (int caseId = 1; caseId <= totalCases; caseId++) {
			// Read the word set
			int n = inputScanner.nextInt();
			Integer[] numbers = new Integer[n * (2 * n - 1)];
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = inputScanner.nextInt();
			}
			HashMap<Integer, Integer> timesMap = new HashMap<Integer, Integer>();
			
			for (Integer num : numbers) {
				Integer times = timesMap.get(num);
				if (times == null)
					times = 1;
				else
					times++;
				timesMap.put(num, times);
			}
			
			Integer[] oddTimesNums = new Integer[n];
			int count = 0;
			for (Entry<Integer, Integer> entry : timesMap.entrySet()) {
				Integer num = entry.getKey();
				Integer times = entry.getValue();
				
				if (times % 2 != 0) {
					oddTimesNums[count] = num;
					count++;
				}
			}
			
			Arrays.sort(oddTimesNums);
			Integer[] result = oddTimesNums;
			
			StringBuilder sb = new StringBuilder();
			sb.append(result[0]);
			for (int i = 1; i < n; i++) {
				sb.append(' ');
				sb.append(result[i]);
			}
			
			// Print the result
			System.out.println("Case #" + caseId + ": " + sb.toString());
		}
		
		inputScanner.close();
	}
}
