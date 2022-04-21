package googlejam9.p116;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class B {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		String filename = "B-large";
		Scanner sc = new Scanner(new File(filename + ".in"));
		//Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(filename + ".out", "UTF-8");
		while (sc.hasNext()) {
			int T = sc.nextInt();
			for (int i = 1; i <= T; i++) {
				int B = sc.nextInt();
				long M = sc.nextLong();
				long max = 1L << (B - 2);
				if (M > max) {
					System.out.println("Case #" + i + ": IMPOSSIBLE");
					pw.println("Case #" + i + ": IMPOSSIBLE");
				} else {
					String str = "0";
					System.out.println("Case #" + i + ": POSSIBLE");
					pw.println("Case #" + i + ": POSSIBLE");
					for(int j = B-2; j > 0; j--) {
						if(M >= (1L << (j-1))) {
							M -= (1L << (j-1));
							str += "1";
						} else {
							str += "0";
						}
					}
					str += M==1 ? "1" : "0";
					pw.println(str);
					System.out.println(str);
					for(int j = 1; j < B; j++) {
						for(int k = 0; k < B; k++) {
							pw.print(k <= j ? "0" : "1");
							System.out.print(k <= j ? "0" : "1");
						}
						pw.println();
						System.out.println();
					}
				}
				
			}
			pw.close();
		}
	}

}