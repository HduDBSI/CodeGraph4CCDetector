package googlejam6.p463;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Round1A2 {
	public static void main(String[] args) {
		Round1A2 q1 = new Round1A2();
		Scanner in = new Scanner(System.in).useDelimiter("\\n");
		int numLines = in.nextInt();
		
		
		for (int currLine = 0; currLine < numLines; currLine++) {
			int numRow = in.nextInt();
			TreeMap<Integer, Integer> hmap = new TreeMap<Integer,Integer>();
			
			int[][] array = new int[3][numRow * 2 - 1];
			
			for (int i = 0; i < numRow * 2 - 1; i++) {
				String userInput = in.next();
				String[] tokens = userInput.split("\\s");
				
				for (int j = 0; j < tokens.length; j++) {
					if (hmap.containsKey(Integer.valueOf(tokens[j]))) {
						int value = hmap.get(Integer.valueOf(tokens[j])) + 1;
						hmap.put(Integer.valueOf(tokens[j]), value);
					} else {
						hmap.put(Integer.valueOf(tokens[j]), 1);
					}
				}
				
				/*for (int j = 0; j < tokens.length; j++) {
					array[j][i] = Integer.valueOf(tokens[j]);
				}*/
				
			}
			
			/*for (int j = 0; j < numRow * 2 - 1; j++) {
				for (int i = 0; i < 3; i++) {
					System.out.print(array[i][j]);
				}
				System.out.println();
			}*/

			int tempLine = currLine + 1;
			System.out.print("Case #" + tempLine + ": ");
			
			String result = "";
			for (int k : hmap.keySet()) {
				if (hmap.get(k) % 2 == 1) {
					result += k + " ";
				}
			}
			result = result.substring(0, result.length()-1);
			System.out.println(result);
		}
	}
}
