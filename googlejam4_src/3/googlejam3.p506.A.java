package googlejam3.p506;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class A {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
			int TC = Integer.parseInt(br.readLine());
			for (int tc = 1; tc <= TC; tc++) {
				String[] line = br.readLine().split(" ");
				int R = Integer.parseInt(line[0]);
				int C = Integer.parseInt(line[1]);
				int W = Integer.parseInt(line[2]);

				int ans = 0;
				if (C == W)
					ans = W;
				else {
					if (C % W == 0)
						ans += C / W - 1;
					else
						ans += C / W;

					ans += W;
				}

				System.out.println("Case #" + tc + ": " + ans);
			}
		}
	}
}
