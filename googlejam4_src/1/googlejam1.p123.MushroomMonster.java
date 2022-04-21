package googlejam1.p123;
import java.io.*;
import java.util.*;
import java.math.*;

public class MushroomMonster {
	static int c;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("in.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("out.out"));
		int t = Integer.parseInt(br.readLine());
		for(c = 1; c <= t; c++){
			long len = Integer.parseInt(br.readLine());
			// System.out.println("len" + len);
			String line = br.readLine();
			String[] fields = line.split(" ");
			long prev = Integer.parseInt(fields[0]);
			long meth1 = 0;
			long meth2 = 0;
			long rate = 0;
			for(int i = 1; i < len; i++){
				long curr = Integer.parseInt(fields[i]);
				if(prev > curr){
					meth1 += (prev - curr);
				}
				if(prev - rate > curr){
					rate = prev - curr;
				}
				// System.out.println(rate);
				prev = curr;
			}
			meth2 = rate * (len - 1);
			for(int i = 0; i < len - 1; i++){
				int num = Integer.parseInt(fields[i]);
				if(num - rate < 0){
					meth2 += num - rate;
				}
				// System.out.println(num - rate);
			}
			bw.write("Case #" + c + ": " + meth1 + " " + meth2 + "\n");
		}
		br.close();
		bw.close();
	}


}