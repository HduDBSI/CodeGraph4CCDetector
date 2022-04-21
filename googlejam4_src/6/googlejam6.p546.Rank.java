package googlejam6.p546;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rank {
	public static void main(String[] args) throws Exception {
		List<String[]> lines = new ArrayList<String[]>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(
				"round1/B-large.in")))) {
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line.split(" "));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String h = "";
		int testCases = Integer.valueOf(lines.get(0)[0].trim());
		int prevN = 0;
		for (int z = 0; z < testCases; z++) {
			int n = Integer.valueOf(lines.get(z + 1 + prevN)[0].trim());
			int p = n * 2 - 1;
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < p; i++) {
				String[] st = lines.get(z + i + 2 + prevN);
				for (String s : st) {
					Integer a = Integer.valueOf(s);
					if (list.contains(a)) {
						list.remove(a);
					} else {
						list.add(a);
					}
				}
			}
		
			Collections.sort(list);
			StringBuilder sb = new StringBuilder(list.size());
			for (Integer c : list)
				sb.append(c + " ");
			String result1 = sb.toString();
		
			h += "Case #" + (z + 1) + ": " + new String(result1) + "\n";
			prevN += 2 * n - 1;
		}
		String result = h;
		System.out.println(result);
		PrintWriter writer = new PrintWriter("round1/B-large.txt", "UTF-8");
		writer.println(result);
		writer.close();

	}

}
