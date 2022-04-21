package googlejam1.p192;
import java.util.Scanner;

public class a {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		int cn = 0;

		while (cn++ < cases) {
			int times = in.nextInt();

			int[] input = new int[times];
			for (int i = 0; i < input.length; i++) {
				input[i] = in.nextInt();
			}

			int last = input[0];
			int wayOne = 0;
			for (int i = 1; i < times; i++) {
				int next = input[i];

				wayOne += Math.max(0, last - next);
				
				last = next;
			}

			int wayTwo = 0;
			last=input[0];
			int worst = 0;
			for (int i = 1; i < input.length; i++) {
				int next=input[i];
				int minEaten = Math.max(0, last-next);
//				minEaten = (minEaten/10) + (minEaten%10==0 ? 0 : 1);
				worst = Math.max(worst, minEaten);
				last=next;
			}
			
			for (int i = 0; i < input.length-1; i++) {
				wayTwo += Math.min(input[i], worst);
			}
			
			System.out.printf("Case #%d: %d %d\n", cn, wayOne, wayTwo);
		}
	}
}
