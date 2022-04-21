package googlejam1.p374;
import java.util.Scanner;

public class Mush {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		for (int i = 0; i < T; i++) {
			int N = in.nextInt();
			int[] mush = new int[N];
			for (int i1 = 0; i1 < N; i1++) {
				mush[i1] = in.nextInt();
			}
			int firstOutput = 0;
			for (int i2 = 0; i2 < N - 1; i2++) {
				int diff = mush[i2] - mush[i2+1];
				if (diff > 0) {
					firstOutput += diff;
				}
			}
			
			int secondOutput = 0;
			int maxDiff = 0;
			for (int i3 = 0; i3 < N - 1; i3++) {
				int diff = mush[i3] - mush[i3+1];
				if (diff > maxDiff) {
					maxDiff = diff;
				}
			}
			
			for (int i4 = 0; i4 < N - 1; i4++) {
				if (mush[i4] > maxDiff) {
					secondOutput += maxDiff;
				} else {
					secondOutput += mush[i4];
				}
			}
			
			
			
			System.out.println("Case #" + (i + 1) + ": " + firstOutput + " " + secondOutput);
		}
		in.close();

	}

}