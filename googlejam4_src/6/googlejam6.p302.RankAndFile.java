package googlejam6.p302;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;


public class RankAndFile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int runs = Integer.parseInt(sc.nextLine().trim());
		for(int run = 1 ; run <= runs ; run++) {
			System.out.print("Case #" + run + ":");
			
			int N = Integer.parseInt(sc.nextLine().trim());
			TreeSet<Integer> list = new TreeSet<Integer>();
			
			for(int i = 0 ; i < 2*N - 1 ; i++) {
				String[] line = sc.nextLine().split("\\s+");
				for(String sNum : line) {
					int num = Integer.parseInt(sNum);
					if(list.contains(num)) {
						list.remove(num);
					} else {
						list.add(num);
					}
				}
			}
			
			for(int num : list) {
				System.out.print(" " + num);
			}
			System.out.println();
		}
	}
}
