package googlejam3.p172;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Brattleship {

	private static String inFile="A-large.in";
	private static String outFile="A-large.out";
	private static String encoding = "UTF-8";
	
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new FileInputStream(inFile), encoding);
			BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
			int nCases = Integer.parseInt(scanner.nextLine());
			
			for (int i = 0; i < nCases; i++) {
				System.out.println("Case #" + (i + 1) + " start");
				String[] caseValues = scanner.nextLine().split(" ");
				int R=Integer.parseInt(caseValues[0]), C=Integer.parseInt(caseValues[1]), W=Integer.parseInt(caseValues[2]);
				System.out.println(" R=" + R + " C="+C+" W="+W);
				int score = R*(C/W)+W;
				if (C%W==0)
				score -=1;
				String val = String.valueOf(score);
				writer.write("Case #" + (i + 1) + ": " + val + "\n");
				System.out.println("Case #" + (i + 1) + " result: "+val);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

	}
}