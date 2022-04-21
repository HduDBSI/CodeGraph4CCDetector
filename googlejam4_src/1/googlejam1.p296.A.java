package googlejam1.p296;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("C:\\Users\\Valentin\\workspace_luna\\CodeJam\\src\\A-large(1).in"));
		System.setOut(new PrintStream(new File("C:\\Users\\Valentin\\workspace_luna\\CodeJam\\src\\test.out")));

		int t = sc.nextInt();
		for (int k = 0; k < t; k++) {
			int n = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(sc.nextInt());
			}
			
			long normal = 0;
			long special = 0;
			//normal
			int pred = list.get(0);
			for (int i = 1; i < list.size(); i++) {
				if (pred > list.get(i)) {
					normal += pred - list.get(i);
				}
				pred = list.get(i);
			}
			
			//special
			int max_diff = -1;
			pred = list.get(0);
			for (int i = 1; i < list.size(); i++) {
				int curr = list.get(i);
				if (pred - curr > max_diff) {
					max_diff = pred - curr;
				}
				pred = curr;
			}
			
			for (int i = 1; i < list.size(); i++) {
				int curr = list.get(i-1);
				special += Math.min(max_diff, curr);
			}
			System.out.println("Case #" + (k+1) + ": " + normal + " " + special);
		}
	}

}
