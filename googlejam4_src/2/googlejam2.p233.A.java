package googlejam2.p233;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;


public class A {
	public static void main(String[] args) throws Exception {
		int MAX = 1000001;
		int[] mem = new int[MAX];
 		for (int i = 2; i < mem.length; i++) {
			mem[i] = i;
		}
		mem[1] = 1;
		for (int i = 12; i < mem.length; i++) {
			mem[i] = Math.min(mem[i], mem[i - 1] + 1);
			char[] chrs = String.valueOf(i).toCharArray();
			String ns = "";
			for (int j = chrs.length - 1; j >= 0; j--) {
				ns += chrs[j];
			}
			int nv = Integer.parseInt(ns);
			if(nv < mem.length) {
				mem[nv] = Math.min(mem[nv], mem[i] + 1);
			}
		}
		BufferedReader br = new BufferedReader(new FileReader("A-small-attempt0.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("outputA.txt"));
		int nrTests = Integer.parseInt(br.readLine());
		for(int tNr = 1; tNr <= nrTests; tNr++) {
			long n = Long.parseLong(br.readLine());
			pw.println("Case #" + tNr + ": " + mem[(int)n]);
		}
		
		pw.close();
		br.close();
		System.out.println("done!");
	}
}
