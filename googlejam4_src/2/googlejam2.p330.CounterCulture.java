package googlejam2.p330;
import java.util.*;
import java.io.*;

public class CounterCulture {
	private static List<Integer> res;
	private static int up = 1;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintStream out = System.out;
		res = new ArrayList<Integer>();
		res.add(0, 0);
		res.add(1, 1);
		
		int caseNum = in.nextInt();
		for (int i = 1; i <= caseNum; i++) {
			if (!in.hasNextInt()) {
				return;
			}
			int numN = in.nextInt();
			int result = 0;
			if (numN <= up) {
				result = res.get(numN);
			}
			else {
				while (up < numN) {
					int temp = up;
					if (up > reverseInt(up+1)) {
						if (reverseInt(reverseInt(up+1)) == up+1){
							temp = reverseInt(up+1);
						}
					}
					int tempRes = Math.min(res.get(up)+1, res.get(temp)+1);
					res.add(up+1, tempRes);
					up++;
				}
				result = res.get(numN);
			}
			out.printf("Case #%d: %d\n", i, result);
			
		}
	}
	
	private static int reverseInt(int n) {
		StringBuffer str = new StringBuffer(new Integer(n).toString());
		return new Integer(str.reverse().toString());
	}
}