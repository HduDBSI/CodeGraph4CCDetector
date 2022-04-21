package googlejam6.p062;


import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 4/8/16.
 */
public class R1B {
    final static String PATH = "/Users/eatstreet/Downloads/";

    public static void main(String[] args) throws IOException {
        R1B r = new R1B();
		//        List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath(PATH + "B.in"));
		        List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath(R1B.PATH + "B-small-attempt0.in"));
		//        List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath(PATH + "B-large.in"));
		        PrintWriter writer = new PrintWriter(R1B.PATH + "B.out", "UTF-8");
		        int idx = 0;
		        int t = Integer.parseInt(lines.get(idx));
		        idx++;
		        for (int ca=1; ca<=t; ca++) {
		            int n = Integer.parseInt(lines.get(idx));
		            idx++;
		            int[] c = new int[2501];
		            for (int i=0; i<n *2 - 1; i++) {
		                String v = lines.get(idx);
		                idx++;
		                final String[] split = v.split(" ");
		                for (String s : split) {
		                    c[Integer.parseInt(s)] ++;
		                }
		            }
		            StringBuilder result = new StringBuilder();
		            for (int i=0; i<c.length; i++) {
		                if (c[i] % 2 == 1) {
		                    result.append(i).append(" ");
		                }
		            }
		            final String s = result.substring(0, result.length() - 1);
		            writer.println(String.format("Case #%d: %s", ca, s));
		        }
		        writer.close();
    }
}
