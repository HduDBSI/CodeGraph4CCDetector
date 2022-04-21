package googlejam2.p347;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

public class A {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("input.txt"));
		PrintStream ps = new PrintStream(new File("output.txt"));
		int T = Integer.parseInt(scanner.nextLine());
		HashSet<Long> set = new HashSet<Long>();
		HashSet<Long> newSet = new HashSet<Long>();
		HashSet<Long> tried = new HashSet<Long>();
		HashSet<Long> temp = null;
		for (int i = 1; i <= T; i++) {
			long N = Long.parseLong(scanner.nextLine());
			int count = 1;
			set.clear();
			newSet.clear();
			tried.clear();
			set.add(1L);
			boolean found = N == 1;
			for (; !found; count++) {
				for (Long num : set) {
					Long reverse = Long.parseLong(new StringBuilder(num
							.toString()).reverse().toString());
					if (reverse == N || num + 1 == N) {
						found = true;
						break;
					} else {
						if (reverse > num && !tried.contains(reverse)) {
							tried.add(reverse);
							newSet.add(reverse);
						}
						if (!tried.contains(num + 1)) {
							tried.add(num + 1);
							newSet.add(num + 1);
						}
					}
				}
				set.clear();
				temp = set;
				set = newSet;
				newSet = temp;
			}
			System.out.println();
			String output = "Case #" + i + ": " + count;
			System.out.println(output);
			ps.println(output);
		}
		ps.flush();
		ps.close();
		scanner.close();
	}
}
