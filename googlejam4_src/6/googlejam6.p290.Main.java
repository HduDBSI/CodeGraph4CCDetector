package googlejam6.p290;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		String file = "B-large.in";
		BufferedReader br = new BufferedReader(new FileReader(file));
		BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int len = Integer.parseInt(br.readLine());
			ArrayList<Integer> nums = new ArrayList<>();
			ArrayList<Integer> shows = new ArrayList<>();
			for (int j = 0; j < len * 2 - 1; j++) {
				String s = br.readLine();
				String[] ss = s.split(" ");
				for (int k = 0; k < ss.length; k++) {
					int a = Integer.parseInt(ss[k]);
					if (nums.contains(a)) {
						shows.set(nums.lastIndexOf(a), shows.get(nums.lastIndexOf(a)) + 1);
					} else {
						nums.add(a);
						shows.add(1);
					}
				}
			}
			int[] ints = new int[len];
			for (int j = 0, k = 0; j < nums.size(); j++) {
				if (shows.get(j) % 2 != 0)
					ints[k++] = nums.get(j);
			}
			Arrays.sort(ints);
			StringBuilder sb = new StringBuilder();
			sb.append(ints[0]);
			for (int j = 1; j < ints.length; j++) {
				sb.append(" ").append(ints[j]);
			}
			bw.write("Case #" + (i + 1) + ": " + sb.toString());
			bw.newLine();
		}
		br.close();
		bw.close();
	}
}
