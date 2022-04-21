package googlejam6.p081;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class Rank {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(new File("B-large.in"));
		int numCases = Integer.parseInt(s.nextLine());
		for(int c = 1;c<=numCases;c++) {
			int n = Integer.parseInt(s.nextLine());
			HashMap<Integer,Integer> counts = new HashMap<>();
			for(int i = 0;i<2*n-1;i++) {
				String line = s.nextLine();
				String[] lineArr = line.split("\\s+");
				for(String xs : lineArr) {
					int x = Integer.parseInt(xs);
					if(!counts.containsKey(x)) {
						counts.put(x, 0);
					}
					counts.put(x,counts.get(x)+1);
				}
				
				
				
			}
			ArrayList<Integer> missing = new ArrayList<Integer>();
			for(int x : counts.keySet()) {
				if(counts.get(x) % 2 == 1) {
					missing.add(x);
				}
			}
			Collections.sort(missing);
			System.out.print("Case #" + c + ":");
			for(int x : missing) {
				System.out.print(" " + x);
			}
			System.out.println();
		}
	}
}
