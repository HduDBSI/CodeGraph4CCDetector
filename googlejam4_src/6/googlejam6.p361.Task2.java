package googlejam6.p361;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Task2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<List<Integer>> testCaseAll = new ArrayList<List<Integer>>();
		try (BufferedReader br = new BufferedReader(new FileReader("D:\\input.txt"))) {
			String line;
			br.readLine();
			while ((line = br.readLine()) != null) {
				List<Integer> base = new ArrayList<Integer>();
				for (int i = 0; i < (Integer.valueOf(line)*2-1); i++) {
					String[] parts = br.readLine().split(" ");
					for (String string : parts) {
						base.add(Integer.valueOf(string));
					}
					
				}
				testCaseAll.add(base);
			}
			List<String> result = new ArrayList<>();

			
			for (List<Integer> numbers : testCaseAll) {
				List<Integer> clone = new ArrayList<Integer>(numbers);
				Collections.sort(clone);
				Integer highest = clone.get(clone.size()-1);
				String resultValue = "";
				for (int i = 0; i <= highest; i++) {
					int amount = Collections.frequency(numbers, Integer.valueOf(i));
					if (amount != 0 && amount%2 != 0)
						resultValue = resultValue + " " + String.valueOf(i);
				}
				System.out.println("done");
				result.add(resultValue);
			}

			PrintWriter pw = new PrintWriter(new FileWriter("D:\\outPut.txt"));

			int i = 1;
			for (String string : result) {
				pw.println("Case #" + i + ": " + string);
				i++;
			}
			pw.close();

		}
	}
}
