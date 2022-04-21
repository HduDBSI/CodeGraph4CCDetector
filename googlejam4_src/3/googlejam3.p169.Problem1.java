package googlejam3.p169;
import java.util.*;

public class Problem1 {

	static int solve1(int r, int c, int w) {
		if(c % w == 0)
			return r*(c/w) + w-1;
		return r*(c/w) + w;
	}

	public static void main(String... args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=1; i <= T; i++) {
			int ans = solve1(in.nextInt(), in.nextInt(), in.nextInt());
			System.out.println("Case #" + i + ": " + ans);
		}
		
		in.close();
	}


}