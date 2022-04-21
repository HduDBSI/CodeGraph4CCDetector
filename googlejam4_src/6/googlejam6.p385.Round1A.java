package googlejam6.p385;
import java.util.*;
import java.io.*;
public class Round1A {
public static void main(String[] args) throws Exception{
	Scanner input = new Scanner(System.in);
	PrintWriter out = new PrintWriter("A.txt");
	int numCases = input.nextInt();
	for (int i = 0 ; i < numCases; i++) {
		int N = input.nextInt();

		HashSet<Integer> st = new HashSet<Integer>();
		for (int j = 0; j < (2*N -1) * N; j++) {
			int n = input.nextInt();
			
				
					if (st.contains(n)) {
						st.remove(n);
					}else {
						st.add(n);
					}
				
			

		}
		ArrayList<Integer> subres = new ArrayList<>();
		for (Integer num : st) {
			subres.add(num);
		}
		Collections.sort(subres);
		String res1 = "";
		for (Integer num: subres) {
			res1 = res1 + num + " ";
			
		}
		res1.trim();
		String res = res1;
		int index = i+1;
		out.print("Case #" + index + ": "+res+"\n");
	}
	input.close();
	out.close();
}

}