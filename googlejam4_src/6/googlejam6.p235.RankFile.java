package googlejam6.p235;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class RankFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File ("B-large.in"));
		PrintWriter out = new PrintWriter(new File("B-large.out"));
		PrintWriter debug = new PrintWriter(new File("debug-bl.txt"));
		
		int a = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < a; i++) {
			int size = sc.nextInt();
			sc.nextLine();
			
			Set<Integer> odds = new TreeSet<>();
			
			for (int j = 0; j < size*2-1; j++) {
				for (int k = 0; k < size; k++) {
					int h = sc.nextInt();
					
					if (odds.contains(h))
						odds.remove(h);
					else
						odds.add(h);
				}
			}
			
			Iterator<Integer> left = odds.iterator();
			String output = "";
			while(left.hasNext()) 
				output += (left.next() + " ");
			
			out.printf("CASE #%d: %s%n", i + 1, output.trim());
		}
		
		
		
		sc.close();
		out.close();
		debug.close();
	}
}
