package googlejam6.p261;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class Round1B {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("D:\\Downloads\\B-small-attempt0.in"));
		// Scanner sc = new Scanner(new File("small2.in"));
		
		int T = sc.nextInt();
		
		for (int x = 1; x <= T; ++x) {
			int N = sc.nextInt();
			
			int[][] arr = new int[2*N-1][N];
			
			// 2 * N - 1 line with N numbers
			for (int i = 0; i < 2 * N - 1; ++i) {
				for (int j = 0; j < N; ++j) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			
			
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < 2 * N - 1; ++i) {
				for (int j = 0; j < N; ++j) {
					if (map.get(arr[i][j]) == null) {
						map.put(arr[i][j], 1);
					}
					else {
						int k = map.get(arr[i][j]);
						map.put(arr[i][j], k + 1);
					}
				}
			}
			
			ArrayList<Integer> r = new ArrayList<Integer>();
			
			for (int i : map.keySet()) {
				if (map.get(i) % 2 != 0) {
					r.add(i);
				}
			}
			
			Collections.sort(r);
			
			System.out.print("Case #" + x + ":");
			for (int i = 0; i < r.size(); ++i) {
				System.out.print(" " + r.get(i));
			}
			System.out.println();
		}

		sc.close();
	}
}
