package googlejam7.p313;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by russinko on 4/30/16.
 */
public class CloseMatch {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("B-small-attempt0.in"));
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        int caseCount = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < caseCount; i++) {
            String line = sc.nextLine();
            String[] pars = line.split(" ");
			String C = pars[0];
			int bestDelta = Integer.MAX_VALUE;
			String bestCoders = null;
			String bestJammers = null;
			for(int jam = 0; jam < 1000; jam++) {
			    for(int coders = 0; coders < 1000; coders++) {
			        String s = Integer.toString(coders);
					while (s.length() < C.length()) {
					    s = "0" + s;
					}
					String CODERS = s;
					String s1 = Integer.toString(jam);
					while (s1.length() < C.length()) {
					    s1 = "0" + s1;
					}
			        String JAMMERS = s1;
			        if(CODERS.matches(C.replace("?",".")) && JAMMERS.matches(pars[1].replace("?", "."))) {
			            int delta = Math.abs(jam - coders);
			            if(delta < bestDelta) {
			                bestDelta = delta;
			                bestCoders = CODERS;
			                bestJammers = JAMMERS;
			            }
			        }
			
			    }
			}
			List<String> list = new ArrayList<>();
			list.add(bestCoders);
			list.add(bestJammers);
            List<String> solution = list;
            System.out.println(pars[0] + ":" + pars[1]);
            pw.printf("Case #%d: %s %s\n", i + 1, solution.get(0), solution.get(1));
        }
        pw.close();
    }
}
