package googlejam2.p214;


import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

// Using the Google Guava library.
public class A {

	public static void main(String [] args) throws IOException {
		String inputFile = "src/A-small-1.in";
		Scanner in = new Scanner(new File(inputFile));
		PrintStream out = new PrintStream(inputFile.substring(0, inputFile.length()-2)+"out");
		int cases = in.nextInt();
		for (int cs = 1; cs <= cases; cs++) {
			long n = in.nextLong();
			A a = new A(n);
			String ans = "Case #"+cs+": "+a.minSteps;
			out.println(ans);
			System.out.println(ans);
		}
		out.close();
		in.close();
	}
	
	TreeMap<Long, Integer> queue = new TreeMap<>();
	HashMap<Long,Integer> seen = new HashMap<>();
	int minSteps = Integer.MAX_VALUE;
	
	public A(long n) {
	    queue.put(n, 1);
	    while(!queue.isEmpty()) {
	        Entry<Long, Integer> e = queue.pollFirstEntry();
	        long v = e.getKey();
	        int s = e.getValue();
	        if (v == 1) {
	            minSteps = Math.min(s, minSteps);
	            continue;
	        }
	        if (s >= minSteps) { continue; }
	        {
	            Integer ps = seen.get(v-1);
	            if (ps == null || ps > s+1) {
	                queue.put(v-1, s+1);
	                seen.put(v-1, s+1);
	            }
            }
	        if (v % 10 != 0) {
	            long vr = Long.parseLong(new StringBuilder(Long.toString(v)).reverse().toString());
	            if (vr < v){
	                Integer ps = seen.get(vr);
	                if (ps == null || ps > s+1) {
	                    queue.put(vr, s+1);
	                    seen.put(vr, s+1);
	                }
	            }
	        }
	    }
	}
}
