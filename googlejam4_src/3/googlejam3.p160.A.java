package googlejam3.p160;
import java.io.*;

public class A {
	static PrintWriter pw;
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new FileReader("../GoogleCodeJam2015R1C/io/A-large.in"));
		pw = new PrintWriter(new FileWriter("../GoogleCodeJam2015R1C/io/output.txt"));
		
		int T = Integer.parseInt(input.readLine());
		for(int i = 0 ; i < T ; i++){
			String[] s = input.readLine().split(" ");
			int R = Integer.parseInt(s[0]);
			int C = Integer.parseInt(s[1]);
			int W = Integer.parseInt(s[2]);
			
			
			
			if(C % W == 0){
				pw.println("Case #"+(i+1)+": "+(( C / W) * (R - 1) + ((C / W) + (W - 1))));
			}else{
				pw.println("Case #"+(i+1)+": "+(( C / W) * (R - 1) + (C / W) + W));
			}
		}
		pw.flush();
		input.close();
		pw.close();
	}
}
