package googlejam6.p033;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;

public class ProblemB {	
	public static void main(String[] args) throws Exception {
		String fileName = "fileB";
		PrintWriter writer = new PrintWriter(fileName + ".out", "UTF-8");
		Scanner scanner = new Scanner(new File(fileName + ".in"));
		int t = scanner.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			
			Hashtable<Integer, Integer> heights = new Hashtable<Integer, Integer>();
			
			for (int i1 = 0; i1 < n * (n*2-1); i1++) {
				int height = scanner.nextInt();
				
				if (heights.containsKey(height)) {
					heights.put(height, 1 + heights.get(height));
				} else {
					heights.put(height, 1);
				}
			}
			
			ArrayList<Integer> missing = new ArrayList<Integer>();
			
			for (Integer height : heights.keySet()) {
				if (heights.get(height) % 2 == 1) {
					missing.add(height);
				}
			}
			
			Collections.sort(missing);
			
			String ans = missing.toString().replace(",", "");
			ans = ans.substring(1, ans.length() - 1);
			
			writer.print("Case #" + (long) (i+1) + ": " + ans);
			
			if (i < t - 1) {
				writer.println("");
			}
		}
		
		writer.close();
		scanner.close();
	}
}
