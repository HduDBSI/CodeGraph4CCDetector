package googlejam6.p203;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
public class RankAndFile {
	public static void main(String[] args) {
		Scanner inputFile = null;

		PrintWriter fileWriter = null;
		try {
			fileWriter = new PrintWriter("B-large-1.out");
			inputFile = new Scanner(new FileReader("B-large-1.in"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int numberCases = inputFile.nextInt();
		inputFile.nextLine();
		
		for (int i = 0; i < numberCases; i++) {
			int number = inputFile.nextInt();
			inputFile.nextLine();

			HashMap<Integer, Integer> map = new HashMap<>();
			
			for (int j = 0; j < number * 2 - 1; j++) {
				String line = inputFile.nextLine();
				Scanner lineScanner = new Scanner(line);
				while(lineScanner.hasNext()) {
					int value = lineScanner.nextInt();
					if (map.containsKey(value)) {
						int freq = map.get(value);
						map.put(value, freq+1);
					} else {
						map.put(value, 1);
					}
				}
				lineScanner.close();
			}
			
			Set<Entry<Integer, Integer>> setOfValues = map.entrySet();
			Iterator<Entry<Integer, Integer>> iterator = setOfValues.iterator();
			
			ArrayList<Integer> resultList = new ArrayList<>();
			
			while(iterator.hasNext()) {
				Entry<Integer, Integer> tempEntry = iterator.next();
				if (tempEntry.getValue() % 2 != 0) {
					resultList.add(tempEntry.getKey());
				}
			}
			
			Collections.sort(resultList);
			String resultString = "";
			for (int j = 0; j < resultList.size() - 1; j++) {
				resultString += resultList.get(j) + " ";
			}
			
			resultString += resultList.get(resultList.size() - 1);
			
			fileWriter.println("Case #" + (i+1) + ": " + resultString);
		}
		fileWriter.close();
		inputFile.close();
	}
}
