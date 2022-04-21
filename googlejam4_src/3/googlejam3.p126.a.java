package googlejam3.p126;
import java.util.Scanner;

public class a {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int caseNum = 1; caseNum <= t; caseNum++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int w = sc.nextInt();
			int g = (r - 1) * (c / w) + w + (c / w);
			if ((c % w) == 0) {
				g--;
			}
			System.out.println("Case #" + caseNum + ": " + g);
		}
	}
}
