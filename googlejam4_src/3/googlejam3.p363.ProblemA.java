package googlejam3.p363;
import java.util.*;
import java.io.*;

public class ProblemA {

	private static final String IN_DIR = "inputs";
	private static final String OUT_DIR = "outputs";

	private static final String IN_FILE = "A-large.in";
	private static final String OUT_FILE = "output_a.txt";
	
	public static void main(String[] args) {
		Scanner sc = null;
		BufferedWriter out = null;

		try {
			sc = new Scanner(new File(IN_DIR + "/" + IN_FILE));
			out = new BufferedWriter(new FileWriter(OUT_DIR + "/" + OUT_FILE));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int numTests = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < numTests; i++) {
			try {
				int caseNum = i+1;
				String inrow = sc.nextLine();
				Scanner sc2 = new Scanner(inrow);
				int R = sc2.nextInt();
				int C = sc2.nextInt();
				int W = sc2.nextInt();
				
				// for all inputs
				if (C % W == 0) {
					out.write("Case #" + caseNum + ": " + ((C/W)*R + (W-1)) + "" + "\n");
				} else {
					out.write("Case #" + caseNum + ": " + ((C/W)*R + W) + "" + "\n");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			sc.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
