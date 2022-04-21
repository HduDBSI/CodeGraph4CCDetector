package googlejam1.p170;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;


public class Mushroom {
	public static void main(String[] args){
		Mushroom t = new Mushroom();
		Scanner scan;
		try {
			scan = new Scanner(new File("input.txt"));
			PrintStream p = new PrintStream("output.txt");
			int num = scan.nextInt();
			for(int i = 1; i <= num; i++){
				scan.nextLine();
				int intervals = scan.nextInt();
				int[] mushrooms = new int[intervals];
				for (int j = 0; j < intervals; j++) {
					mushrooms[j] = scan.nextInt();	
				}
		
				// Now all the mushroom intervals have been calculated
				int current = mushrooms[0];
				
				int total1 = 0; 
				// Method 1:
				// Kaylin only eats when the number drops
				for (int j = 1; j < intervals; j++) {
					if (mushrooms[j] < current) {
						total1 += (current - mushrooms[j]);
					}
					current = mushrooms[j];
				}
				
				int[] drop = new int[intervals-1];
				for (int j = 1; j < intervals; j++) {
					drop[j-1] = mushrooms[j-1] - mushrooms[j];
					if (drop[j-1] < 0) {
						drop[j-1] = 0;
					}
				}
				
				Arrays.sort(drop);
				
				int total2 = 0;
				current = mushrooms[0];
				int eatingRate = drop[drop.length-1];
				for (int j = 1; j < intervals; j++) {
					total2 += Math.min(current, eatingRate);
					//System.out.println(Math.min(current, eatingRate));
					current = mushrooms[j];
				}
				
				p.println("Case #" + i + ": " + total1 + " " + total2);
				//System.out.println("Case #" + i + ": " + total1 + " " + total2);
			}
			p.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

