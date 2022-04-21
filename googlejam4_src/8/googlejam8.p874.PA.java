package googlejam8.p874;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PA {

	static int nbParty, sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] s = new int[N];
			for (int i = 0; i < N; i++) 
				s[i] = sc.nextInt();

			nbParty = N; // nbParty
			sum = 0;
			for (int i = 0; i < N; i++) 
				sum += s[i];

			StringBuilder sb = new StringBuilder();
			while (sum > 0) {
				nbParty = 0;
				sum = 0;
				for (int i = 0; i < N; i++) {
					if (s[i] > 0) {
						nbParty++;
						sum += s[i];
					}
				}

				if (nbParty > 3) {
					int max1 = s[0] > s[1]? s[0]: s[1];
					int idx1 = s[0] > s[1]? 0: 1;
					int max2 = s[0] > s[1]? s[1]: s[0];
					int idx2 = s[0] > s[1]? 1: 0;
					for (int i = 2; i < N; i++) {
						if (max1 < s[i]) {
							max2 = max1; idx2 = idx1;
							max1 = s[i]; idx1 = i;
						} else {
							if (max2 < s[i]) {
								max2 = s[i]; idx2 = i;
							}
						}
					}
					sb.append((char)(idx1+'A')+""+ (char)(idx2+'A') + " ");
					s[idx1]--; s[idx2]--;
				} else if (nbParty == 3) {
					int[] party = new int[nbParty];
					nbParty = 0;
					for (int i = 0; i < N; i++) 
						if (s[i] > 0) {
							party[nbParty++] = i;
						}

					if (sum == 3) {
						sb.append((char)(party[0] + 'A') + " ");
						s[party[0]]--;
					} else {
						int max1 = s[0] > s[1]? s[0]: s[1];
						int idx1 = s[0] > s[1]? 0: 1;
						int max2 = s[0] > s[1]? s[1]: s[0];
						int idx2 = s[0] > s[1]? 1: 0;
						for (int i = 2; i < N; i++) {
							if (max1 < s[i]) {
								max2 = max1; idx2 = idx1;
								max1 = s[i]; idx1 = i;
							} else {
								if (max2 < s[i]) {
									max2 = s[i]; idx2 = i;
								}
							}
						}
						sb.append((char)(idx1+'A')+""+ (char)(idx2+'A') + " ");
						s[idx1]--; s[idx2]--;
					}

				} else if (nbParty == 2) {
					int idx1 = -1;
					int idx2 = -1;
					for (int i1 = 0; i1 < N; i1++) {
						if (s[i1] > 0) {
							if (idx1 == -1) idx1 = i1;
							else idx2 = i1;
						}
					}
					if (s[idx1] > s[idx2]) {
						sb.append((char)(idx1+'A')+" ");
						s[idx1]--;
					} else if (s[idx2] > s[idx1]) {
						sb.append((char)(idx2+'A')+" ");
						s[idx2]--;
					}
					for (int i1 = 0; i1 < s[idx1]; i1++) {
						sb.append((char)(idx1+'A')+""+ (char)(idx2+'A'));
						if ( i1 != s[idx1] -1) sb.append(" ");
					}
					sum = 0;
				}
			}

			System.out.printf("Case #%d: %s\n", t, sb.toString());
		}

		sc.close();
	}
}
