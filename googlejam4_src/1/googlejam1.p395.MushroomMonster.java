package googlejam1.p395;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MushroomMonster {
	static {

		try {
			String input = "A-large.in";
			String output = input.substring(0, input.lastIndexOf('.')) + ".out";
			System.setIn(new FileInputStream(input));
			System.setOut(new PrintStream(new FileOutputStream(output), true));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

	}

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			int T = input.nextInt();
			for (int t = 1; t <= T; t++) {
				int N = input.nextInt();
				int m[] = new int[N];
				int x1 = 0, x2 = 0;
				int offset = 0;
				m[0] = input.nextInt();
				for (int i = 1; i < N; i++) {
					m[i] = input.nextInt();
					if (m[i] < m[i - 1])
						x1 += m[i - 1] - m[i];
					offset = Math.max(m[i - 1] - m[i], offset);
				}
				if (offset > 0)
					for (int i = 0; i < N - 1; i++) {
						x2 += Math.min(m[i], offset);
					}
				System.out.printf("Case #%d: %d %d", t, x1, x2);
				System.out.println();
			}
		}
	}
}
