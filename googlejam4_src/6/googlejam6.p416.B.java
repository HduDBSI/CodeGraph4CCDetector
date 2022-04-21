package googlejam6.p416;


import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;


public class B {

	public static void main(String args[]) {

		PrintStream printStream = null;
		try {
			printStream = new PrintStream(new BufferedOutputStream(new FileOutputStream("result/B-large.out")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.setOut(printStream);

		Scanner scInput = new Scanner(System.in);
		int T = scInput.nextInt() + 1;
		for(int i = 1 ; i < T ; i++) {
			int N = scInput.nextInt();
			int listSize = N * 2 - 1;
			TreeMap<Integer, Integer> countMap = new TreeMap<Integer, Integer>();
			for (int j = 0 ; j < listSize ; j++) {
				for (int k = 0 ; k < N ; k++) {
					int currentNumber = scInput.nextInt();
					Integer currentNumberCount = countMap.get(currentNumber);
					if (currentNumberCount == null) {
						countMap.put(currentNumber, 1);
					} else {
						countMap.put(currentNumber, ++currentNumberCount);
					}
				}
			}
		
			StringBuilder result = new StringBuilder();
			for(Entry<Integer, Integer> entry : countMap.entrySet()) {
				if (entry.getValue() % 2 == 1) {
					result.append(" ").append(entry.getKey());
				}
			}
			System.out.format("Case #%d: %s\n", i, result.toString().trim());
		}
		scInput.close();

		printStream.close();

	}

}
