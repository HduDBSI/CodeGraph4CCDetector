package googlejam3.p039;
import java.util.*;

public class A {

	public static void main(String[] args) {
		A a = new A();
		Scanner in = new Scanner(System.in);
		int cases = Integer.parseInt(in.nextLine());
		for (int a1=0; a1<cases; a1++) {
			int r = in.nextInt();
			int c = in.nextInt();
			int w = in.nextInt();
			if (a1!=cases-1) {
				in.nextLine();
			}
			int base = c/w;
			base *= r;
			if (c%w==0) {
				base += (w-1);
			}
			else {
				base += w;
			}
			System.out.println("Case #" + (a1+1) + ": " + base);
		}
	}

}