package googlejam6.p218;
import java.util.Scanner;

public class RankandFile {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(in.nextLine());
			int[] heights = new int[2501];
			for (int i = 0; i < 2 * N - 1; i++) {
				String[] inp = in.nextLine().split(" ");
				for (int j = 0; j < inp.length; j++) {
					heights[Integer.parseInt(inp[j])]++;
				}
			}
			StringBuilder sb = new StringBuilder("");
			for (int i = 1; i < heights.length; i++) {
				if(heights[i]%2==1)
					sb.append(i+" ");
			}
			sb.deleteCharAt(sb.length()-1);
			System.out.println("Case #" + (t + 1) + ": " + sb);
		}

	}

}
