package googlejam8.p292;
import java.util.*;

public class A {
public static void main(String [] args) {
	Scanner scanner = new Scanner(System.in);
	int nCase = scanner.nextInt();
	
	for (int nc = 1; nc <= nCase; nc++) {
		int N = scanner.nextInt();
		int total = 0;
		int[] P = new int[N];
		for (int i = 0; i < N; i++) {
			total += P[i] = scanner.nextInt();
		}
		
		StringBuilder output = new StringBuilder("Case #" + nc + ":");
		
		while (total > 0) {
			output.append(' ');
			if (total == 2) {
				for (int i = 0; i < N; i++) {
					if (P[i] > 0)
						output.append((char) ('A' + i));
				}
				total -= 2;
			} else {
				int first = -1;
				int tempFirst = 0;
				for (int i = 0; i < N; i++) {
					if (P[i] > tempFirst) {
						first = i;
						tempFirst = P[i];
					}
				}
				P[first]--;
				total--;
				output.append((char) ('A' + first));
				int maxAllowed = total/2;
				for (int i = 0; i < N; i++) {
					if (P[i] > maxAllowed) {
						P[i]--;
						total--;
						output.append((char) ('A' + i));
						break;
					}
				}
				
				
				
			}			
		}
		output.append('\n');		
		
		System.out.println(output.toString());
	}
}
}

