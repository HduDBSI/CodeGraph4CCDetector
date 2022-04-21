package googlejam6.p151;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Solve2016R1A_B {
	private static String filePath = "B-large.in";

	public static void main(String[] args) {
		StringBuffer answer = new StringBuffer();
		final int MAXH = 2501;

		try (Scanner sc = new Scanner(new File(filePath))) {
			int T = sc.nextInt();
			for (int i = 1; i <= T; i++) {
				answer.append("Case #" + i + ":");
				int N = sc.nextInt();
				
				int lineCnt = 2 * N - 1;
				int[] heights = new int[MAXH];
				for (int j = 0; j < lineCnt; j++) {
					for (int k = 0; k < N; k++) {
						int h = sc.nextInt();
						heights[h]++;
					}
				}
				for (int h = 0; h < MAXH; h++) {
					if (heights[h] % 2 != 0) {
						answer.append(" ").append(h);
					}
				}
				answer.append("\n");
			}
			String outPath = "answer.out";
			if (filePath != null && !filePath.equals("")) {
				outPath = filePath.substring(0, filePath.length() - 2) + "out";
			}
			try (FileOutputStream fos = new FileOutputStream(outPath, false)) {
				fos.write(answer.toString().getBytes());
			}
			System.out.println(answer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
