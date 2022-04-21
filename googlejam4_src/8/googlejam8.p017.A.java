package googlejam8.p017;


import java.util.Scanner;

public class A {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            A r = new A();
			r.N = scanner.nextInt();
			r.P = new int[r.N];
			for (int i = 0; i < r.N; i++) r.P[i] = scanner.nextInt();
			
			int maxP = 0;
			int maxI = -1;
			
			int secondMaxP = 0;
			int secondMaxI = -1;
			
			for (int i = 0; i < r.N; i++) {
			    if (r.P[i] > maxP) {
			        maxP = r.P[i];
			        maxI = i;
			    }
			}
			
			for (int i = 0; i < r.N; i++) {
			    if (i == maxI) continue;
			    if (r.P[i] > secondMaxP) {
			        secondMaxP = r.P[i];
			        secondMaxI = i;
			    }
			}
			
			String plan = "";
			while(maxP > secondMaxP) {
			    plan += (char) ('A' + maxI);
			    plan += " ";
			    maxP--;
			}
			
			for (int i = 0; i < r.N; i++) {
			    if (i == maxI || i == secondMaxI) continue;
			
			    while(r.P[i] > 0) {
			        plan += (char) ('A' + i);
			        plan += " ";
			        r.P[i]--;
			    }
			}
			
			while(maxP > 0) {
			    plan += (char) ('A' + maxI);
			    plan += (char) ('A' + secondMaxI);
			    plan += " ";
			    maxP--;
			}
			String solution = plan;
            System.out.println("Case #" + t + ": " + solution);
        }
    }

    int N;
    int[] P;

}
