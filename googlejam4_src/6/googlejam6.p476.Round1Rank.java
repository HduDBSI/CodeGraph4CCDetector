package googlejam6.p476;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Round1Rank {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	static ArrayList<String> list = new ArrayList<String>();

	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		int n = Integer.parseInt(bf.readLine());

		for (int i = 0; i < n; i++) {

			int m = Integer.parseInt(bf.readLine());
			int Len = (2 * m) - 1;
			int[] ans = new int[m];
			int ansC = 0;
			for (int j = 0; j < Len; j++) {
				for (String s : bf.readLine().split(" ")) {
					int c = Integer.parseInt(s);
					if (map.containsKey(c)) {
						int val = map.get(c);
						map.put(c, val + 1);
					} else {
						map.put(c, 1);
					}
				}
			}

			for (Entry<Integer, Integer> item : map.entrySet()) {
				if (item.getValue() % 2 != 0)
					ans[ansC++] = item.getKey();
			}
			Arrays.sort(ans);
			String fans = "";
			for (int j = 0; j < ans.length; j++) {
				fans += " " + ans[j];
			}
			map.clear();
			list.add(fans);
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Case #" + (i + 1) + ":" + list.get(i));
		}
	}

}
