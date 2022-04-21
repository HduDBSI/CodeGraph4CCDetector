package googlejam3.p082;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


public class GcjA {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("A-large.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("output1.txt"));
		int nrT = Integer.parseInt(br.readLine());
		for(int tnr = 1; tnr <= nrT; tnr++) {
			String[] strs = br.readLine().split(" ");
			int r = Integer.parseInt(strs[0]);
			int c = Integer.parseInt(strs[1]);
			int w = Integer.parseInt(strs[2]);
			
			int res = r * (c / w) + w;
			if(c % w == 0) {
				res--;
			}
			pw.println("Case #" + tnr + ": " + res);
		}
		br.close();
		pw.close();
	}
}
