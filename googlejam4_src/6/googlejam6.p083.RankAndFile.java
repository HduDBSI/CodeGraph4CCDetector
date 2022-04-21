package googlejam6.p083;
import java.io.*;
import java.util.*;

public class RankAndFile {
    public static final PrintStream out = System.out;
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public int numCases;
    
    public static void main(String[] args) throws Exception {
        RankAndFile r = new RankAndFile();
		r.numCases = Integer.parseInt(RankAndFile.in.readLine().trim());
		for (int i = 1; i <= r.numCases; i++) {
		    RankAndFile.out.print("Case #" + i + ":");
		    String line = RankAndFile.in.readLine();
			Scanner scan = new Scanner(line);
			int N = scan.nextInt();
			int[] count = new int[2501];
			for (int i1 = 0; i1 < 2 * N - 1; i1++) {
			    line = RankAndFile.in.readLine();
			    scan = new Scanner(line);
			    for (int j = 0; j < N; j++) {
			        int height = scan.nextInt();
			        count[height]++;
			    }
			}
			for (int i2 = 0; i2 < 2501; i2++) {
			    if (count[i2] % 2 == 1) {
			        System.out.print(" " + i2);
			    }
			}
			System.out.println();
		}
    }

}
