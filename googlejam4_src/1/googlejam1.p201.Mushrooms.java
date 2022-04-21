package googlejam1.p201;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Mushrooms {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int t =  sc.nextInt();
	StringBuilder out = new StringBuilder();
	for ( int c = 1; c <= t; c++) {
		int n = sc.nextInt();
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}
		
		// first
		int eaten1 = 0;
		for (int i = 0; i < list.size() -1; i++) {
			int diff = list.get(i) - list.get(i+1);
			
			if (diff > 0) {
				eaten1 += diff;
			}
		}
		
		// second
		int rate2 = 0;
		for (int i = 0; i < list.size() -1; i++) {
			int diff = list.get(i) - list.get(i+1);
			
			if (diff > rate2) {
				rate2 = diff;
			}
		}
		
		int eaten2 = 0;
		for (int i = 0; i < list.size() -1; i++) {
			if (list.get(i) < rate2) {
				eaten2 += list.get(i);
			} else {
				eaten2 += rate2;
			}
		}
		
		out.append("Case #").append(c).append(": ").append(eaten1).append(" ").append(eaten2).append("\n");
	}
	System.out.print(out);
}
}
