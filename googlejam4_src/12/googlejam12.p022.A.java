package googlejam12.p022;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class A {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("AL.in"));
		PrintWriter out = new PrintWriter("AL.out");
		int tc = in.nextInt();
		for (int cc = 1; cc <= tc; cc++) {
			String s = in.next();
			int gain = 0;
			while (true) {
				Stack<Character> stack = new Stack<>();
				for (int i = 0; i < s.length(); i++) {
					if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
						stack.pop();
					} else {
						stack.push(s.charAt(i));
					}
				}
				StringBuilder next = new StringBuilder();
				for (Character c : stack) {
					next.append(c);
				}
				String nx = next.toString();
				int value = (s.length() - nx.length()) / 2 * 10;
				s = nx;
				if (value == 0)
					break;
				gain += value;
			}
			gain += s.length() / 2 * 5;
			System.out.printf("Case #%d: %d\n", cc, gain);
			out.printf("Case #%d: %d\n", cc, gain);
		}
		out.close();
	}
}
