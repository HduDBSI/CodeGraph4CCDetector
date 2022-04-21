package googlejam8.p669;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("in.txt"));
		int numCases = Integer.parseInt(s.nextLine());
		long time = System.currentTimeMillis();
		for (int i = 0; i < numCases; i++) {
			int numParties = Integer.parseInt(s.nextLine());
			String[] members = s.nextLine().split(" ");
			Evacuation e = new Evacuation();
			for (int j = 0; j < numParties; j++) {
				char c = (char) ('A' + j);
				e.senate.add(new Party(new StringBuilder().append(c).toString(), Integer.parseInt(members[j])));
			}
			System.out.print("Case #" + (i + 1) + ": " + e.evacuate());
			System.out.println();
		}
		System.out.println("Time: " + (System.currentTimeMillis() - time));
		s.close();
	}
	
}
