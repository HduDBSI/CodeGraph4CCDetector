package googlejam2.p315;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class A {
	public static void main(String [] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int ct = input.nextInt();
		int cs = 1;
		
		int[] values = new int[1_000_001];
		Arrays.fill(values, Integer.MAX_VALUE);
		values[1] = 1;
		for(int i = 1; i < values.length-1; i++) {
			values[i+1] = Math.min(values[i+1], values[i]+1);
			int j = (int)reverse(i);
			values[j] = Math.min(values[j], values[i]+1);
		}
		
		while(ct-- > 0) {
			System.out.printf("Case #%d: %d%n", cs++, values[input.nextInt()]);
		}
	}
	
	public static long reverse(long a) {
		StringBuilder sb = new StringBuilder(Long.toString(a));
		sb.reverse();
		return Long.parseLong(sb.toString());
	}
}