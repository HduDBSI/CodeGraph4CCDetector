package googlejam1.p061;
import java.io.*;
import java.util.*;

public class Mushroom {
    public static final PrintStream out = System.out;
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public int numCases;
    
    public static void main(String[] args) throws Exception {
        Mushroom r = new Mushroom();
		r.numCases = Integer.parseInt(Mushroom.in.readLine().trim());
		for (int i = 1; i <= r.numCases; i++) {
		    Mushroom.out.print("Case #" + i + ": ");
		    String line = Mushroom.in.readLine();
			Scanner scan = new Scanner(line);
			int N = scan.nextInt();
			line = Mushroom.in.readLine();
			scan = new Scanner(line);
			int prev = scan.nextInt();
			int max = 0;
			int sum = 0;
			int[] m = new int[N];
			m[0] = prev;
			for (int i2 = 1; i2 < N; i2++) {
			    int next = scan.nextInt();
			    m[i2] = next;
			    int diff = prev - next;
			    if (diff > 0) sum += diff;
			    if (diff > max) max = diff;
			    prev = next;
			}
			int res = 0;
			for (int i1 = 0; i1 < N-1; i1++) {
			    res += Math.min(max, m[i1]);
			}
			System.out.println(sum + " " + res);
		}
    }

}
