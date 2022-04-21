package googlejam6.p654;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob1B {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/Harish/Downloads/B-large.in"));
		String line = br.readLine();
		int count = 1;
		int t = Integer.parseInt(line);
		while (t-- > 0) {
			line = br.readLine();
			int n = Integer.parseInt(line);
			int size = 2 * n - 1;
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < size; i++) {
				line = br.readLine();
				String[] arr = line.split(" ");
				for (int j = 0; j < n; j++) {
					list.add(arr[j]);
				}
			}
			int l = list.size();
			ArrayList<Integer> list2 = new ArrayList<Integer>();
			while (!list.isEmpty()) {
				int val = Integer.parseInt(list.get(0));
				int idx1 = list.indexOf(""+val);
				list.remove(idx1);
				int idx2 = list.indexOf(""+val);
				if (idx2 == -1) {
					list2.add(val);
				} else {
					list.remove(""+val);
				}
			}
			List<Integer> sorted = list2.subList(0, list2.size());
			Collections.sort(sorted);
			System.out.print("Case #"+(count++)+": ");
			int s = sorted.size();
			for(int i=0;i<s;i++){
				System.out.print(sorted.get(i)+" ");
			}
			System.out.println();
		}
	}
}
