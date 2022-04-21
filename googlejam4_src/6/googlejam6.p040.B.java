package googlejam6.p040;
import java.io.*;
import java.util.*;

public class B {
	static String infname = "B-large.in";
	static String oufname = "B-large.out";
	

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(infname));
		BufferedWriter bw = new BufferedWriter(new FileWriter(oufname));
		int Tn, T;
		Tn = sc.nextInt();
		sc.nextLine();
		for (T=1;T<=Tn;T++) {
			bw.write(String.format("Case #%d: ", T));
			int n = sc.nextInt();
			HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();
			for (int i=0;i<2*n-1;i++) {
				for (int j=0;j<n;j++) {
					int num = sc.nextInt();
					if (!cnt.containsKey(num)) {
						cnt.put(num, 1);
					} else {
						cnt.put(num, cnt.get(num)+1);
					}
				}
			}
			//ArrayList<Integer> ans = new ArrayList<Integer>();
			for (int i=1;i<=2500;i++) {
				if (cnt.containsKey(i) && cnt.get(i)%2!=0) {
					bw.write(Integer.toString(i) + ' ');
				}
			}
			bw.write('\n');
		}
		bw.close();
	}

}
