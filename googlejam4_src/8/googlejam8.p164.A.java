package googlejam8.p164;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Map.Entry;

import static java.lang.Math.*;

public class A extends PrintWriter {

    private static final String input = "A-large.in";
    private static final String output = "A-output.txt";

    String next() {
        while (!tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(nextLine());
        return tokenizer.nextToken();
    }

    String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException err) {
            return null;
        }
    }

    public A(OutputStream outputStream) {
        super(outputStream);
    }

    static BufferedReader reader;
    static StringTokenizer tokenizer = new StringTokenizer("");
    static Random rnd = new Random();
    static boolean OJ;

    public static void main(String[] args) throws IOException {
        A solution = new A(new FileOutputStream(output));
        reader = new BufferedReader(new FileReader(new File(input)));
        int tests = Integer.parseInt(solution.next());
		
		for (int test = 1; test <= tests; test++) {
		    int n = Integer.parseInt(solution.next());
			int[] array = new int[n];
			for (int i1 = 0; i1 < n; i1++) {
			    array[i1] = Integer.parseInt(solution.next());
			}
		    int[] a = array;
		
		    int sum = 0;
		    for (int p : a) {
		        sum += p;
		    }
			int[] a1 = a.clone();
			List<int[]> plan1 = new ArrayList<int[]>();
			
			while (true) {
			    int x = 0;
			    for (int i = 1; i < n; i++) {
			        if (a1[i] > a1[x]) {
			            x = i;
			        }
			    }
			
			    if (a1[x] == 0) {
			        break;
			    }
			
			    int y = -1;
			    for (int i = 0; i < n; i++) {
			        if (i == x) {
			            continue;
			        }
			        if (y == -1 || a1[i] > a1[y]) {
			            y = i;
			        }
			    }
			
			    int z = -1;
			    for (int i = 0; i < n; i++) {
			        if (i == x || i == y) {
			            continue;
			        }
			        if (z == -1 || a1[i] > a1[z]) {
			            z = i;
			        }
			    }
			    if (n == 2) {
			        if (a1[x] > a1[y]) {
			            plan1.add(new int[] { x });
			            --a1[x];
			        } else {
			            plan1.add(new int[] { x, y });
			            --a1[x];
			            --a1[y];
			        }
			    } else {
			        if (a1[x] > a1[y] || a1[z] > 0) {
			            plan1.add(new int[] { x });
			            --a1[x];
			        } else {
			            plan1.add(new int[] { x, y });
			            --a1[x];
			            --a1[y];
			        }
			    }
			
			}
		
		    List<int[]> plan = plan1;
		    solution.printf(Locale.ENGLISH, "Case #%d:", test);
		
		    try {
		        for (int[] step : plan) {
		            solution.print(' ');
		            for (int v : step) {
		                solution.print((char) (v + 'A'));
		                --sum;
		                --a[v];
		            }
		
		            for (int p : a) {
		                if (p < 0 || 2 * p > sum) {
		                    throw new IllegalStateException(Arrays.toString(a));
		                }
		            }
		        }
		    } catch (RuntimeException error) {
		        System.err.println(error.getMessage());
		    }
		
		    solution.println();
		
		    // printf(Locale.ENGLISH, "Case #%d: %s%n", test);
		}
        solution.close();
        reader.close();
    }
}