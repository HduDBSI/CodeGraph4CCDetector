package googlejam9.p034;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class B {
	
	private static int d;
	private static int[] n1;
	private static int[] n2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String s = r.readLine();
		int T = Integer.parseInt(s);
		StringBuilder sb = new StringBuilder();	
		for (int i = 0; i < T; i++) {
			sb.append("Case #" + (i+1) + ": ");
			s = r.readLine();
			String[] parts = s.split(" ");
			int B = Integer.parseInt(parts[0]);
			long M = Long.parseLong(parts[1]);
			if (Math.pow(2, B-2) < M) {
				sb.append("IMPOSSIBLE");
			} else {
				sb.append("POSSIBLE\n");
				sb.append("0");
				for (int j = 1; j < B; j++) {
					sb.append("1");
				}
				boolean[] binear = new boolean[B];
				M--;
				for (int j = 0; j < B; j++) {
					if (M >= Math.pow(2, B-j-1)) {
						binear[j] = true;
						M -= Math.pow(2, B-j-1);
					}
				}
				for (int j = 1; j < B; j++) {
					sb.append("\n");
					for (int k = 0; k < B; k++) {
						if (k <= j) {
							sb.append("0");
						} else if (k == B-1){
							if (binear[B-j]) {
								sb.append("1");
							} else {
								sb.append("0");
							}
						} else {
							sb.append("1");
						}
					}
				}
			}			
			sb.append("\n");
		}
		System.out.println(sb.toString());
		PrintWriter writer = new PrintWriter("Qual1C.BBB.txt", "UTF-8");
		writer.println(sb.toString());
		writer.close();

	}

}
