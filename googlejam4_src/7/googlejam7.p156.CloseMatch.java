package googlejam7.p156;


import java.io.*;
import java.util.*;

public class CloseMatch {
	
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(new File(args[0]));
		PrintWriter output = new PrintWriter(new File(args[1]));
		
		int t = input.nextInt();
		input.nextLine();
		
		for (int i = 0; i < t; ++i) {
			String[] scores = input.nextLine().trim().split("\\s+");
			String closestMatch = closestMatch(scores[0].toCharArray(), scores[1].toCharArray());
			output.printf("Case #%d: %s%n", (i + 1), closestMatch);;
		}
		
		input.close();
		output.close();
	}
	
	private static Character[] objectify(char[] a) {
		Character[] o = new Character[a.length];
		for (int i = 0; i < a.length; ++i) o[i] = a[i];
		return o;
	}
	
	private static final String closestMatch(char[] cs, char[] js) {
		String cPat = new String(cs).replace("?", "%c");
		String jPat = new String(js).replace("?", "%c");
		
		String cc = new String(cs);
		String jj = new String(js);
		int b = 0;
		for (int i1 = 0; i1 < cs.length; ++i1) if (cs[i1] == '?') ++b;
		
		
		int lbc = b;
		int b = 0;
		for (int i2 = 0; i2 < js.length; ++i2) if (js[i2] == '?') ++b;
		int lbj = b;
		
		int ppc = lbc == 0 ? Integer.parseInt(cc) : 0;
		int ppj = lbj == 0 ? Integer.parseInt(jj) : 0;
		
		int cBound = (int) Math.pow(10, lbc);
		int jBound = (int) Math.pow(10, lbj);
		
		int minDiff = Integer.MAX_VALUE;
		int cRep = -1;
		int jRep = -1;
		
		for (int i = 0; i < cBound; ++i) {
			for (int j = 0; j < jBound; ++j) {
				int pc = lbc == 0 ? ppc : Integer.parseInt(String.format(cPat, objectify(String.format("%0" + lbc + "d", i).toCharArray())));
				int pj = lbj == 0 ? ppj : Integer.parseInt(String.format(jPat, objectify(String.format("%0" + lbj + "d", j).toCharArray())));
				if (Math.abs(pc - pj) < minDiff) {
					minDiff = Math.abs(pc - pj);
					cRep = pc;
					jRep = pj;
				}
			}
		}
		return String.format("%0" + cs.length + "d %0" + cs.length + "d", cRep, jRep);
	}

}
