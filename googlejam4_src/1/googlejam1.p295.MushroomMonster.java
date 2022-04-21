package googlejam1.p295;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MushroomMonster {
    Scanner sc = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "A-large";
    static final String IN = FILENAME + ".in";
    static final String OUT = FILENAME + ".out";
    PrintStream out = System.out;

    public static void main(String args[]) throws Exception {
        MushroomMonster r = new MushroomMonster();
		r.out = new PrintStream(new FileOutputStream(MushroomMonster.OUT));
		int t = r.sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
		    System.out.println("Test Case " + tc + "...");
		    int N = r.sc.nextInt();
		    int[] mi = new int[N];
		    for(int i = 0; i < N; i++) {
		        mi[i] = r.sc.nextInt();
		    }
		    r.out.print("Case #" + tc + ": ");
		    long eat1 = 0, eat2 = 0;
			
			long maxDiff = 0;
			
			for(int i = 1; i < mi.length; i++) {
			    int diff = mi[i - 1] - mi[i];
			    eat1 += Math.max(diff, 0);
			    maxDiff = Math.max(diff, maxDiff);
			}
			
			for(int i = 1; i < mi.length; i++) {
			    eat2 += Math.min(maxDiff, mi[i-1]);
			}
			
			r.out.print(eat1 + " ");
			r.out.println(eat2);
		}
		r.sc.close();
		r.out.close();
    }
}
