package googlejam3.p221;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Q11 {

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("A-large.in"));
			PrintWriter out = new PrintWriter("A-large.out");
			int numberOfCases = Integer.parseInt(in.nextLine());
			for (int caseNum = 1; caseNum <= numberOfCases; caseNum++) {
                int rows = in.nextInt();
                int columns = in.nextInt();
                int shipWidth = in.nextInt();
                int trials = 0;
                trials += (columns / shipWidth) * rows + shipWidth;
                if(columns % shipWidth == 0) {
                	trials--;
                }       
                out.println("Case #" + caseNum + ": " + trials);
			}
			in.close();
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
