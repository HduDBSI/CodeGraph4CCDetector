package googlejam8.p458;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class A {
	public static void main(String[] args) throws IOException {
		String name = "A-large";

		Scanner in = new Scanner(new File("/Users/YunJoonSoh/" + name + ".in"));
		FileWriter fstream = new FileWriter("/Users/YunJoonSoh/" + name + ".out");
		BufferedWriter out = new BufferedWriter(fstream);

		int T = Integer.parseInt(in.nextLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(in.nextLine());

			int[] S = new int[N];

			for (int i = 0; i < N; i++) {
				S[i] = in.nextInt();
			}
			in.nextLine(); // for end of line

			String ret = "";

			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += S[i];
			}

			int MAX_PARTY = 0;

			while (sum > 0) {
				// find max party and evacuate
				for (int j = 0; j < N; j++) {
					if (S[MAX_PARTY] < S[j]) {
						MAX_PARTY = j;
					}
					
					if (S[j] * 2 > sum)
						System.out.println("MAJORITY");
				}

				S[MAX_PARTY]--;
				sum--;

				// if (sum != 0) {
//				if (S[MAX_PARTY] == 0) {
//					break;
//				}
				// }
				// find second max party
				// if the new max party gets the majority
				int MAX_PARTY_2 = 0;
				for (int j = 0; j < N; j++) {
					if (S[MAX_PARTY_2] < S[j]) {
						MAX_PARTY_2 = j;
					}
				}

				// evacuate 2 people
				if ((S[MAX_PARTY_2]) * 2 > sum) { // if runner up now is majority
					ret += (char) (MAX_PARTY + 'A') + "" + (char) (MAX_PARTY_2 + 'A') + " ";
					S[MAX_PARTY_2]--;
					sum--;
				} else {
					ret += (char) (MAX_PARTY + 'A') + " ";
				}
				// }
			}

			for (int i = 0; i < N; i++) {
				if (S[i] != 0)
					System.out.println("NOT EVACUATED");
			}

			// System.out.println("/////////////////////////////////////////");
			StringBuilder s = new StringBuilder();
			s.append("Case #");
			s.append(t);
			s.append(": ");
			// answer
			s.append(ret);
			s.append("\n");
			out.write(s.toString());
			// System.out.print( + ": ");
			System.out.println(s.toString());
		}

		out.close();
		in.close();
	}
}
