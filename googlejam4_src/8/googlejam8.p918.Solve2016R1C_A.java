package googlejam8.p918;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Solve2016R1C_A {
	private static String filePath = "A-small-attempt0.in";

	public static void main(String[] args) {
		StringBuffer answer = new StringBuffer();
		char[] parties = new char[26];
		for (int i = 0; i < parties.length; i++) parties[i] = (char)('A' + i);

		try (Scanner sc = new Scanner(new File(filePath))) {
			int T = sc.nextInt();
			for (int i = 1; i <= T; i++) {
				answer.append("Case #" + i + ":");
				int N = sc.nextInt();
				int[] Pi = new int[N];
				int sum = 0;
				for (int j = 0; j < N; j++) {
					Pi[j] = sc.nextInt();
					sum += Pi[j];
					Pi[j] *= 2;
				}
				while (sum > 0) {
					answer.append(" ");
					
					int flag = 0;
					sum--;
					for (int j = 0; j < N; j++) {
						if (Pi[j] > sum) {
							if (flag == 0) {
								answer.append(parties[j]);
								Pi[j] -= 2;
								flag = 1;
							} else {
								answer.append(parties[j]);
								Pi[j] -= 2;
								sum--;
								break;
							}
						}
					}
					if (flag == 0) {
						for (int j = 0; j < N; j++) {
							if (Pi[j] > 0) {
								answer.append(parties[0]);
								Pi[0] -= 2;
								break;
							}
						}
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
