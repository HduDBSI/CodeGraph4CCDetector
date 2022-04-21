package googlejam6.p224;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException{
		// Scanner s = new Scanner(System.in);
		InputStream is = new FileInputStream(".\\input_and_output\\1A2016\\B-large-1A2016.in");
		FileWriter fr = new FileWriter(".\\input_and_output\\1A2016\\B-large-1A2016.out");
		Scanner s = new Scanner(is);
		
		int n = s.nextInt();
		for (int i = 1; i <= n; ++i){			
			int N = s.nextInt();

			Map<Integer, Integer> map = new HashMap<>();
			
			for (int j = 0; j < (2 * N - 1) * N; ++j){
				int num = s.nextInt();
				if (!map.containsKey(num)){
					map.put(num, 1);
				} else {
					map.put(num, map.get(num) + 1);
				}
			}
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			for (int key : map.keySet()){
				if (map.get(key) % 2 != 0) pq.add(key);
			}
			
			fr.write(String.format("Case #%d:", i));
			while (!pq.isEmpty()){
				fr.write(String.format(" %d", pq.poll()));
			}
			
			fr.write(String.format("\n"));
			// System.out.print(String.format("Case #%d: %s\n", i, dp[l-1]));
		}
		
		fr.close();
		s.close();
	}
}




