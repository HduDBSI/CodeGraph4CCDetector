package googlejam6.p597;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RankFile {

	public static StringBuilder builder = new StringBuilder();

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("./input.txt"))) {
			String line;
			int cases = Integer.parseInt(br.readLine());

			int i = 0;
			while ((line = br.readLine()) != null && i < cases) {
				int N = Integer.parseInt(line);
				int count = 2 * N - 1;
				ArrayList<String> list = new ArrayList<String>();
				for (int j = 0; j < count; j++) {
					list.add(br.readLine());
				}
				int caseNumber = i + 1;

				if (caseNumber != 1)
					builder.append(System.getProperty("line.separator"));
				builder.append("Case #" + caseNumber + ": ");
				
				HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
				
				for (int i1 = 0; i1 < list.size(); i1++) {
					String[] characters = list.get(i1).split(" ");
					for (String str : characters) {
						Integer val = Integer.parseInt(str);
						if (counts.containsKey(val)) {
							counts.put(val, counts.get(val) + 1);
						} else {
							counts.put(val, 1);
						}
					}
				}
				
				ArrayList<Integer> odds = new ArrayList<Integer>();
				for (Map.Entry<Integer, Integer> set : counts.entrySet()) {
					if (set.getValue() % 2 != 0) {
						odds.add(set.getKey());
					}
				}
				Collections.sort(odds);
				
				StringBuilder aa = new StringBuilder();
				for (Integer str : odds) {
					aa.append(str+" ");
				}
				builder.append(aa.toString().trim());
				i++;
			}

			try {
				File file = new File("./output.txt");
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(builder.toString());
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
