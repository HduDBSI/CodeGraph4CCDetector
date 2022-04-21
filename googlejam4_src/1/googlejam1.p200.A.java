package googlejam1.p200;
import java.util.*;

public class A {

	public static void main(String[] args) {
		A a = new A();
		Scanner in = new Scanner(System.in);
		int cases = Integer.parseInt(in.nextLine());
		for (int a1=0; a1<cases; a1++) {
			int num = Integer.parseInt(in.nextLine());
			String[] split = in.nextLine().split(" ");
			int[] vals = new int[num];
			for (int i=0; i<num; i++) {
				vals[i] = Integer.parseInt(split[i]);
			}
			int first = 0;
			int second = 0;
			int rate = 0;
			for (int i=0; i<num-1; i++) {
				if (vals[i+1] < vals[i]) {
					first += vals[i] - vals[i+1];
					rate = Math.max(rate,vals[i] - vals[i+1]);
				}
			}
			for (int i=0; i<num-1; i++) {
				second += Math.min(vals[i],rate);
			}
			System.out.println("Case #" + (a1+1) + ": " + first + " " + second);
		}
	}
}