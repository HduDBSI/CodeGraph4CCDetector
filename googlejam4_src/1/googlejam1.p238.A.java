package googlejam1.p238;
import java.util.*;

public class A {
public static void main(String [] args) {
	Scanner scanner = new Scanner(System.in);
	int nCase = scanner.nextInt();
	
	for (int nc = 1; nc <= nCase; nc++) {
		int N = scanner.nextInt();
		int[] m = new int[N];
		for (int i = 0; i < N; i++)
			m[i] = scanner.nextInt();
		
		int y = 0;
		
		for (int i = 1; i < N; i++) {
			if (m[i] < m[i-1])
				y += m[i-1] - m[i];
		}
		
		int z = 0;
		int max = 0;
		//System.out.print("max:");
		for (int i = 0; i < N-1; i++) {
			max = Math.max(m[i] - m[i+1], max);
			//System.out.print(" "+max);
		}
		//System.out.println();
		for (int i = 0; i < N-1; i++) {
			z += Math.min(m[i], max);
		}
		
		System.out.println("Case #" + nc + ": " + y + " " + z);
	}
}
}