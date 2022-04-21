package googlejam3.p085;


import java.util.*;
import java.io.*;
import java.math.*;


class Codejam {

    public static void main(String args[]) {
        Scanner in = null;
		try {
			in = new Scanner(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new File("output.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int r = in.nextInt();
			int c = in.nextInt();
			int w = in.nextInt();
			int ans = r * c;
			if ( w > 1) {
				ans = r * ((c - 1) / w) + w;
				if (c % w == 0) {
					ans += r - 1;
				}
			}
			
			System.out.println("Case #" + t + ": " + ans);
		}
    }
 
}