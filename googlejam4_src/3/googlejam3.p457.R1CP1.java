package googlejam3.p457;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;


public class R1CP1 {

	public static void main(String[] args) throws Exception {
		String file = "A-small-attempt1";
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader(file + ".in"));
		PrintStream ps = new PrintStream(new FileOutputStream(file + ".out"));
		int testcases = Integer.parseInt(br.readLine());
		for(int t = 0; t < testcases; t++){
			String[] ln = br.readLine().split(" ");
			int r = Integer.parseInt(ln[0]);
			int c = Integer.parseInt(ln[1]);
			int w = Integer.parseInt(ln[2]);
			
			int precal = (int)(Math.ceil((double)(c - w) / w) + w);
			ps.println("Case #" + (t + 1) + ": " + precal);
		}
	}

}
