package googlejam6.p306;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine());
			for (int i = 1; i <= T; i++) {
				int N = Integer.parseInt(br.readLine());
				int toIter = 2 * N - 1;
				String[] line;
				int[] arr = new int[2501];
				int[] naya = new int[N];
				for (int j = 0; j < toIter; j++) {
					line = br.readLine().split("\\s+");
					for (int k = 0; k < N; k++) {
						arr[Integer.parseInt(line[k])]++;
					}
				}
				int counter = 0;
				for (int z = 0; z < 2501; z++) {
					if (arr[z] % 2 != 0)
						naya[counter++] = z;
				}
				System.out.print("Case #" + i + ":");
				for (int x = 0; x < N; x++) {
					System.out.print(" " + naya[x]);
				}
				System.out.println("");
			}
		} catch (IOException e) {
		}
	}

}
