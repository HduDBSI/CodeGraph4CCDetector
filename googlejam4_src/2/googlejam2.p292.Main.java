package googlejam2.p292;
/*
ID: your_id_here
LANG: JAVA
TASK: test
*/
import java.io.*;
import java.util.*;

class Main {


		public static int[] nums = new int[1000000 + 1];

	public static String reverse(String str) {

		String reversed = new StringBuilder(str).reverse().toString();

		return reversed;

	}

	public static void main (String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("test.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
		int t = Integer.parseInt(f.readLine());
		for (int i = 0; i < nums.length; i++) {
			nums[i] = 0;
		}

		System.out.println(reverse("432100"));
		for (int i = 0; i < t; i++) {
			String numstr = f.readLine();
			int num = Integer.parseInt(numstr);
			System.out.println("---" + num);
			
			
			for (int i1 = 1; i1 <= num; i1++) {
				if ((nums[i1] == 0)) {
					int lowest = nums[i1 - 1] + 1;
					numstr = Integer.toString(i1);
					int reversedInt = Integer.parseInt(reverse(numstr));
					String reversed = Integer.toString(reversedInt);
					if (numstr.length() == reversed.length() && reversedInt < i1)
						lowest = Math.min(lowest, (nums[reversedInt] + 1));
					System.out.println(i1 + ", " + lowest);
					nums[i1] = lowest;
				}
			}
			
			
			
			
			out.println("Case #" + (i+1) + ": " + nums[num]);
		}

		out.close();
		System.exit(0);
	}
}
