package googlejam3.p234;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class c1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileReader("input"));
		PrintWriter out = new PrintWriter(new FileWriter("output"));
		
		int cases = in.nextInt();
		for (int a=0; a<cases; a++) {
			int rows = in.nextInt();
			int cols = in.nextInt();
			int width = in.nextInt();
			
			int tries = cols / width;
			tries = tries * rows;
			tries--;
		
			tries = tries+width;
			if (cols % width != 0) {
				tries++;
			}
			out.print("Case #" + (a+1) + ": " + tries + "\n");
			
		}
		
		// template output:
		// out.print("Case #" + (a+1) + ": " + time + "\n");
		
		out.close();

	}

}
