package googlejam6.p301;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Round1B {
	public static void main(String[] args){
		Round1B t = new Round1B();
		Scanner scan;
		try {
			scan = new Scanner(new File("input.txt"));
			PrintStream p = new PrintStream("output.txt");
			long num = scan.nextLong();
			for(long i = 1; i <= num; i++){
				scan.nextLine();
				
				int sizeN = scan.nextInt();
				int[] array = new int[2501];
				
				for (int j = 0; j < 2 * sizeN - 1; j++) {;
					for (int k = 0; k < sizeN; k++) {
						int current = scan.nextInt();
						array[current]++;
					}
				} 
				
				String answer = "";
				for (int r = 1; r <= 2500; r++) {
					if (array[r] % 2 != 0) {
						answer += r + " ";
					}
				}
		
				p.println("Case #" + i + ": " + answer);
				System.out.println("Case #" + i + ": " + answer);
		
			}
			p.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}

