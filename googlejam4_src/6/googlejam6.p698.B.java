package googlejam6.p698;
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class B {
    
    public static void main(String[] args) throws FileNotFoundException {
	try (Scanner sc =
	     new Scanner(new BufferedReader(new FileReader(new File(args[0]))))
	     ) {
		int iterations = sc.nextInt();
		for (int i = 0; i < iterations; i++) {
		    int N = sc.nextInt();
		    Map<Integer, Integer> m = new HashMap<>(); // height, count
		    int max = N * N * 2 - N;
		    for (int j = 0; j < max; j++) {
			int nxt = sc.nextInt();
			if (!m.containsKey(nxt)) {
			    m.put(nxt, 1);
			} else {
			    m.put(nxt, m.get(nxt) + 1);
			}
		    }
		    Set<Integer> anws = new TreeSet<>();
		    String ans = "";
		    for (Integer k : m.keySet()) {
			if (m.get(k) % 2 != 0)
			    anws.add(k);
		    }
		    
		    Integer[] is = new Integer[N];
		    Arrays.sort(anws.toArray(is));

		    for (int iis : is) {
			ans += " " + iis;
		    }
		    System.out.printf("Case #%d:%s\n", i + 1, ans);
		}
	    }
    }

}