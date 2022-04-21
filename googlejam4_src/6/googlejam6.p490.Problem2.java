package googlejam6.p490;


import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Problem2 {
	
	public static SortedMap<Integer, Integer> map;
	
	
	public static void main (String... args) {
		Scanner scanner = new Scanner(System.in);
		Integer cnt = scanner.nextInt();
		for (int c = 1; c <= cnt; c++) {
			map = new TreeMap<Integer, Integer>();
			int n = scanner.nextInt();
			
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					Integer key = scanner.nextInt();
					//System.out.println(">" + key);
					if (!map.containsKey(key)) {
						map.put(key, 1);
					} else {
						map.put(key, map.get(key)+1);
					};
				}				
			}

			for (int j = 0; j < n - 1; j++) {
				for (int k = 0; k < n; k++) {
					Integer key = scanner.nextInt();
					//System.out.println(">" + key);
					if (!map.containsKey(key)) {
						map.put(key, 1);
					} else {
						map.put(key, map.get(key)+1);
					};
				}				
			}

			System.out.print("Case #"+c + ":");
			for (Integer key : map.keySet()) {
				if (map.get(key) % 2 == 1) {
					System.out.print(" "+ key);
				}
			}
			System.out.println("\n");
			
			//System.out.println("Case #" + c + ": " + process(str));
		}
		scanner.close();
	}

}
