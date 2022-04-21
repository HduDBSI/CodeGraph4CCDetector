package googlejam8.p877;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Round1CProblemA {
	
	public static void main(String[] args) {
	    try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(bf.readLine());
			for (int i=0; i<T; i++) {
				int N = Integer.parseInt(bf.readLine());
				String[] strTemp = bf.readLine().split(" ");
				
				int[] P = new int[N];
				int total = 0;
				
				for (int j=0; j<N; j++) {
					P[j] = Integer.parseInt(strTemp[j]);
					total +=P[j];
				}
				
				System.out.print("Case #" + (i+1) + ":");
				while (total > 0) {
					int maxSenatesAllowed = (total - 2)/2; 
					
					int[] defaultEvac = {-1, -1};
					int[] requiredEvac = {-1, -1};
					
					for (int x=0; x<N; x++) {
						if (defaultEvac[0] == -1) {
							if (P[x] >= 2) defaultEvac[1] = x;
							if (P[x] >= 1) defaultEvac[0] = x;
						} else if (defaultEvac[1] == -1) {
							if (P[x] >= 1) defaultEvac[1] = x;
						}

						if (P[x] > maxSenatesAllowed) {
							if (requiredEvac[0] == -1) requiredEvac[0] = x;
							else if (requiredEvac[1] == -1) requiredEvac[1] = x;
						}
					}

					
					if (requiredEvac[0] == -1) 
						requiredEvac = defaultEvac;
					else if (requiredEvac[1] == -1) {
						if (defaultEvac[0] != -1 && defaultEvac[0] != requiredEvac[0]) {
							requiredEvac[1] = defaultEvac[0];
						} else {
							requiredEvac[1] = defaultEvac[1];
						}
					}
					
					if (total == 3) requiredEvac[1] = -1; 
					
					System.out.print(" ");
					int count = 0;
					if (count<2 && requiredEvac[0] != -1) {
						System.out.print((char) ('A' + (char) requiredEvac[0]) );
						P[requiredEvac[0]]--;
						total--;
						count++;
					}
					
					if (count<2 && requiredEvac[1] != -1) {
						System.out.print((char) ('A' + (char) requiredEvac[1]) );
						P[requiredEvac[1]]--;
						total--;
						count++;
					}
					
				}
				
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
