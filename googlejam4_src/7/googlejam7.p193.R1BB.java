package googlejam7.p193;
import java.io.*;
import java.util.*;

public class R1BB {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int nCases = scan.nextInt();
		for (int z = 0; z < nCases; z++) {
			String a = scan.next(), b = scan.next();

			int len = a.length();
			// little-endian: b followed by a
			int[] digits = new int[2*len];
			ArrayList<Integer> questionPos = new ArrayList<Integer>();
			for (int i = 0; i < len; i++) {
				int aPos = len-1 - i + len, bPos = len-1 - i;
				if (a.charAt(i) != '?') {
					digits[aPos] = a.charAt(i) - '0';
				} else {
					questionPos.add(aPos);
				}
				if (b.charAt(i) != '?') {
					digits[bPos] = b.charAt(i) - '0';
				} else {
					questionPos.add(bPos);
				}
			}
			Collections.sort(questionPos);

			int nQuestions = questionPos.size();
			int[] questions = new int[nQuestions];
			int bestDiff = 9999;
			int bestX = -1, bestY = -1;
			outer: while (true) {
				for (int i = 0; i < nQuestions; i++) {
					digits[questionPos.get(i)] = questions[i];
				}
				int x = 0, y = 0, place = 1;
				for (int i = 0; i < len; i++) {
					x += digits[i + len] * place;
					y += digits[i] * place;
					place *= 10;
				}
				if (Math.abs(x - y) < bestDiff) {
					bestDiff = Math.abs(x - y);
					bestX = x;
					bestY = y;
				}
				questions[0]++;
				for (int i = 0; questions[i] == 10; i++) {
					if (i == nQuestions - 1) {
						break outer;
					}
					questions[i] = 0;
					questions[i+1]++;
				}
			}

			String temp = "%0" + len + "d";
			System.out.printf("Case #%d: " + temp + " " + temp + "\n", z + 1, bestX, bestY);
		}
		scan.close();
	}
}
