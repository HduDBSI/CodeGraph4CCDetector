package googlejam1.p518;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {
	
	public static void main(String[] args) {
		
		String filename = "A-large.in";
		String output = "output.txt";
		Scanner scanner = null;
		PrintWriter printer = null;
		
		try {
			scanner = new Scanner(new FileReader(filename));
			printer = new PrintWriter(new FileWriter(output));
			
			int tests = scanner.nextInt();
			for (int test = 1; test <= tests; test++) {
				
				// Input
				int N = scanner.nextInt();
				int ini = scanner.nextInt();
				int[] obs = new int[N - 1];
				for (int i = 0; i < N - 1; i++) {
					obs[i] = scanner.nextInt();					
				}
				
				int a = 0;
				int b = 0;
				
				int running = ini;
				for(int ob : obs) {
					if(ob < running) 
						a += (running - ob);
					running = ob;
				}
				
				int max = 0;
				int runningb = ini;
				for (int ob : obs) {
					max = Math.max(max, runningb - ob);
					runningb = ob;
				}
				runningb = ini;
				for (int i = 0; i < obs.length; i++) {
					int ob = obs[i];
					b += Math.min(max, runningb);
					runningb = ob;
				}
				
				//System.out.println(String.format("Case #%d: %d %d", test, a, b));
				printer.println(String.format("Case #%d: %d %d", test, a, b));
			}			
			
		} catch (FileNotFoundException e) {
			System.out.println(filename + " not found.");
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (scanner != null) {
				scanner.close();
			}
			if (printer != null) {
				printer.flush();
				printer.close();
			}
		}
	}
}
