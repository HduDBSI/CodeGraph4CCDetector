package googlejam2.p207;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;


public class CounterCulture {
	CounterCulture(Scanner in, PrintWriter out){
		int tests = in.nextInt();
		
		
		
		int[] ans = new int[2000000];
		Arrays.fill(ans, Integer.MAX_VALUE);
		ArrayDeque<Integer> q = new ArrayDeque<>();
		boolean[] seen = new boolean[ans.length];
		seen[1] = true;
		q.add(1);
		int steps = 0;
		while(!q.isEmpty()){
			steps++;
			int size = q.size();
			for(int i= 0; i<size; i++){
				int v = q.remove();
				ans[v] = Math.min(ans[v], steps);
				int rev = Integer.parseInt(new StringBuilder(""+v).reverse().toString());
				v++;
				if(v<ans.length && !seen[v]){
					seen[v] = true;
					q.add(v);
				}
				if(rev<ans.length && !seen[rev]){
					seen[rev] = true;
					q.add(rev);
				}
			}
		}
		
//		System.out.println(tests);
		
		for(int t = 1; t<=tests; t++){
			int n = in.nextInt();
			out.printf("Case #%d: %d\n", t, ans[n]);
		}
		out.close();
	}
	public static void main(String[] args) throws FileNotFoundException {
		String name = "A-small-attempt1";
//		new CounterCulture(new Scanner(System.in), new PrintWriter(System.out));
		new CounterCulture(new Scanner(new File(name+".in")), new PrintWriter(new File(name+".out")));
	}
}
