package googlejam8.p455;
import java.util.Scanner;

public class SenateEvac {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		String[] svar = new String[T];
		for (int t = 0; t < T; t++) {
			svar[t] = "";
			int N = scan.nextInt();
			int[] memb = new int[N];
			for (int n = 0; n < N; n++) {
				memb[n] = scan.nextInt();
			}
			int max1 = 0;
			int max2;
			for (int i = 0; i < N; i++) {
				if (memb[i] >= memb[max1]) {
					max1 = i;
				}
			}
			if(max1 != 0){
				max2 = 0;
			} else {
				max2 = 1;
			}
			for (int i = 0; i < N; i++) {
				if (memb[i] >= memb[max2] && i != max1) {
					max2 = i;
				}
			}

			while (memb[max1] > memb[max2]) {
				svar[t] += (char)('A' + max1);
				svar[t] += " ";
				memb[max1]--;
			}
			for (int i = 0; i < N; i++) {
				if (i != max1 && i != max2) {
					for (int j = 0; j < memb[i]; j++) {
						svar[t] += (char)('A' + i);
						svar[t] += " ";
					}
				}
			}
			for (int i = 0; i < memb[max1]; i++) {
				svar[t] += (char)('A' + max1);
				svar[t] += (char)('A' + max2);
				svar[t] += " ";
			}

		}
		for(int t = 0; t<T; t++){
			System.out.println("Case #" + (t+1) + ": " + svar[t]);
		}
	}

}
