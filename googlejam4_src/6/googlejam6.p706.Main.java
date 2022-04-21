package googlejam6.p706;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeSet;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			
			int N = sc.nextInt();
			HashMap<Integer, Integer> map = new HashMap<>();
			
			for(int i=0; i<N*(2*N-1); i++) {
				Integer m = sc.nextInt();
				if(!map.containsKey(m)) {
					map.put(m, 1);
				} else {
					Integer cnt = map.remove(m);
					map.put(m, cnt+1);
				}
			}
			
			TreeSet<Integer> ts = new TreeSet<>();
			for(Entry<Integer, Integer> entry : map.entrySet()) {
				if(entry.getValue() % 2 == 1) {
					ts.add(entry.getKey());
				}
			}
			
			StringBuilder sb = new StringBuilder();
			int ts_size = ts.size();
			for(int i=0; i<ts_size; i++) {
				int value = ts.pollFirst();
				sb.append(value);
				if(i < ts_size-1) {
					sb.append(" ");
				}
			}
		
			
			System.out.println("Case #"+test_case+": " + sb);

		}
	}

}
