package googlejam7.p271;
import java.util.*;
import java.util.regex.*;

public class B {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		input.nextLine();
		for (int c = 0; c < cases; c++) {
			int bestD = Integer.MAX_VALUE;
			int bestX = 0;
			int bestY = 0;
			String a = input.next().replaceAll("\\?", "\\.");
			String b = input.next().replaceAll("\\?", "\\.");
			int n = a.length();
			String fmt = "%0" + n + "d";
			Pattern pa = Pattern.compile(a);
			Pattern pb = Pattern.compile(b);
			for (int x = 0; x < 1000; x++) {
				for (int y = 0; y < 1000; y++) {
					String sx = Integer.toString(x);
					while (sx.length() < n) sx = "0" + sx;
					String sy = Integer.toString(y);
					while (sy.length() < n) sy = "0" + sy;
					Matcher ma = pa.matcher(sx);
					Matcher mb = pb.matcher(sy);
					if (ma.matches() && mb.matches()) {
						int d = Math.abs(x - y);
						if (d < bestD) {
							bestD = d;
							bestX = x;
							bestY = y;
						}
					}
				}
			}
			System.out.println(String.format("Case #%d: " + fmt + " " + fmt, c+1, bestX, bestY));
		}
	}
}
