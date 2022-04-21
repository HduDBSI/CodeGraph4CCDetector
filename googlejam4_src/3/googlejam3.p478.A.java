package googlejam3.p478;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {

		 try {
		 System.setOut(new PrintStream("src/output.out"));
		 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 }
		
		 Scanner in = null;
		 try {
		 in = new Scanner(new File("src/A-small-attempt1 (2).in"));
		 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 }

//		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int res = 0;
			int r = in.nextInt();
			int c = in.nextInt();
			int w = in.nextInt();
			
			if(w == c) {
				res = c;
			} else {
				if(w == 1) {
					res = c;
				} else {
					int cheats = c / w;
					if(cheats <= 1) {
						res = w + 1;
					} else {
						if(c % w == 0) {
							res = w + cheats - 1;
						} else {
							res = w + cheats;
						}
					}
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + res);
		}
	}

}
