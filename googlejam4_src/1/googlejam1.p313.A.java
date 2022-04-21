package googlejam1.p313;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numberOfCase;
		Scanner scanner = null;
		FileWriter fw;
		BufferedWriter bw;

		try {
			File file = new File(args[1]);
			if (!file.exists()) {
				file.createNewFile();
			}
			fw = new FileWriter(file.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			scanner = new Scanner(new File(args[0]));
			numberOfCase = scanner.nextInt();

			for (int i = 0; i < numberOfCase; i++) {
				int n = scanner.nextInt();
				int methodA = 0;
				int previousNumOfPieces = scanner.nextInt();
				int maxDiff = 0;
				int[] pieces = new int[n];
				pieces[0] = previousNumOfPieces;
				for (int j = 1; j < n; j++) {
					int numOfPieces = scanner.nextInt();
					pieces[j] = numOfPieces;
					if (numOfPieces < previousNumOfPieces) {
						int diff = previousNumOfPieces - numOfPieces;
						methodA = methodA + diff;
						if (diff > maxDiff)
							maxDiff = diff;
					}
					previousNumOfPieces = numOfPieces;
				}

				float rate = ((float) maxDiff / 10);
				float methodB = 0;
				for (int k = 0; k < n - 1; k++) {
					if (pieces[k] > (rate * 10)) {
						methodB = methodB + (rate * 10);
					} else {
						methodB = methodB + pieces[k];
					}
				}

				StringBuilder sb = new StringBuilder();
				sb.append("Case #" + (i + 1) + ": " + methodA + " "
						+ Math.round(methodB));
				String msg = sb.toString().trim() + "\n";
				System.out.print(msg);
				bw.write(msg);
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
