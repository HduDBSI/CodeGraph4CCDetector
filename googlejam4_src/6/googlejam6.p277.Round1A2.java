package googlejam6.p277;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Round1A2 {
	public static void main(String... strings) {

		Scanner sc = new Scanner(System.in);
		PrintStream ps = System.out;
		try {
			System.setOut(new PrintStream(new FileOutputStream("out2.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ps.close();
		int numCases = Integer.valueOf(sc.nextLine());

		for (int i = 0; i < numCases; i++) {
			HashMap<Integer, Integer> hm = new HashMap<>();	
			int N = sc.nextInt();
			for (int j = 0; j < N*(2 * N - 1); j++) {
				int a = sc.nextInt();
				if (hm.get(a) == null) {
					hm.put(a, 1);
				} else {
					hm.put(a, hm.get(a) + 1);
				}
			}

			ArrayList<Integer> al = new ArrayList<>();
			for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
				if (entry.getValue() % 2 == 1) {
					al.add(entry.getKey());
				}
			}
			Collections.sort(al);
			int len = al.size();
			System.out.printf("Case #%d: %d", i + 1, al.get(0));
			for(int k = 1;k<len;k++){
				System.out.printf(" %d", al.get(k));
			}
			System.out.println();
		}
		sc.close();
	}
}
