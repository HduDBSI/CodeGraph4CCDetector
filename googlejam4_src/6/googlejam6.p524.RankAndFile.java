package googlejam6.p524;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class RankAndFile {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		for (int i = 1; i <= n; i++) {
			int x = input.nextInt();
			List<Integer> numbers = new LinkedList<Integer>();
			
			for (int j = 0; j < (2*x-1)*x; j++) {
				numbers.add(input.nextInt());
			}
			
			Collections.sort(numbers);
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			
			for (Integer i1 : numbers) {
				if (map.containsKey(i1)) {
					map.put(i1, map.get(i1) + 1);
				} else {
					map.put(i1, 1);
				}
			}
			
			List<Integer> result = new LinkedList<Integer>();
			
			for (Integer i2 : map.keySet()) {
				if (map.get(i2) % 2 == 0) continue;
				result.add(i2);
			}
			
			Collections.sort(result);
			
			StringBuilder formatter = new StringBuilder();
			
			for (Integer c : result) {
				formatter.append(c);
				formatter.append(" ");
			}
			
			System.out.println(String.format("Case #%s: %s", i, formatter.toString()));
		}
		
		input.close();
	}

}
