package googlejam6.p485;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

/**
 * Created by roide on 4/15/16.
 */
public class RandAndFile {
    public static void main(String args[]) {
        RandAndFile obj = new RandAndFile();
        try {
            System.setOut(new PrintStream(new File("/home/roide/codejam/src/roide/rankfile/output_large.txt")));
			String fileName = "/home/roide/codejam/src/roide/rankfile/B-large.txt";
			File f = new File(fileName);
			Scanner scan = new Scanner(f);
			int nCases = scan.nextInt();
			for(int i=1; i<=nCases; i++) {
			    int N = scan.nextInt();
			    int count = (2*N-1) * N;
			    TreeSet<Integer> set = new TreeSet<>();
			    for(int j=0;j<count;j++) {
			        int next = scan.nextInt();
			        if(set.contains(next)) {
			            set.remove(next);
			        } else {
			            set.add(next);
			        }
			    }
				StringBuilder ans = new StringBuilder();
				for(Integer i1:set) {
				    ans.append(i1).append(" ");
				}
			    String val = ans.toString();
			    System.out.println("Case #" + i + ": " + val);
			}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
