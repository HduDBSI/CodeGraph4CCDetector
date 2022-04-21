package googlejam1.p062;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int[] N = new int[sc.nextInt()];
			for (int j = 0; j < N.length; j++) {
				N[j] = sc.nextInt();
			}
			int count = 0, max = 0, sum = 0;
			for (int j = 1; j < N.length; j++) {
				count += Math.max(0, N[j - 1] - N[j]);
				max = Math.max(max, N[j - 1] - N[j]);
			}
			for (int j = 0; j < N.length - 1; j++) {
				sum += Math.min(max, N[j]);
			}
			System.out.println("Case #" + i + ": " + count + " " + sum);
		}
		sc.close();
	}
}