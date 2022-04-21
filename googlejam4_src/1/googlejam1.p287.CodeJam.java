package googlejam1.p287;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: gangien
 * Date: 4/10/15
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class CodeJam {
    public static void main(String [] args) throws Exception {
        long start = System.currentTimeMillis();
        String questionName = "A-large";
		BufferedReader r = new BufferedReader(new FileReader(questionName + ".in"));
		PrintStream out = System.out;
		String file = questionName + ".out";
		if(new File(file).exists()) {
		    throw new RuntimeException(new File(file).getAbsolutePath() + " Already exists");
		}
		
		FileOutputStream fos = new FileOutputStream(new File(file), true);
		PrintStream printStream = new PrintStream(fos);
		out = printStream;
		int count = Integer.parseInt(r.readLine());
		
		for(int x = 0; x < count; x++) {
		    String answer = "";
		    int N = Integer.parseInt(r.readLine());
			String [] nums = r.readLine().split(" ");
			int [] ret = new int[nums.length];
			for(int x1 = 0; x1 < nums.length; x1++) {
			    ret[x1] = Integer.parseInt(nums[x1]);
			}
		    int [] m = ret;
		    int maxRate = 0;
		    int m2 = 0;
		    int m1 = 0;
		    for(int y = 0; y < m.length; y++) {
		        if(y != 0) {
		            maxRate = Math.max(maxRate, m[y-1] - m[y]);
		        }
		    }
		
		    for(int y = 0; y < m.length; y++) {
		        if(y != 0) {
		            int diff = m[y-1] - m[y];
		            if(m[y-1] > 0) {
		                if(m[y-1] >= maxRate) {
		                    m2 += maxRate;
		                } else if(m[y-1] < maxRate) {
		                    m2 += m[y-1];
		                }
		            }
		
		            if(diff >= 0) {
		                m1 += diff;
		            }
		        }
		    }
		
		    answer = "" + m1 + " " + m2;
		
		    out.printf("Case #%d: ", x + 1);
		    out.print(answer);
		    out.println();
		}
//        b();
//        c();
//        d();

        long end = System.currentTimeMillis();

        System.out.printf("Took: %d(ms)\n", (end - start));
    }
}
