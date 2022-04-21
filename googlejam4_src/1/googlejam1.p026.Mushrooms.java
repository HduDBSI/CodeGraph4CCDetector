package googlejam1.p026;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Mushrooms{
	static PrintWriter out;
	public static void main(String[] args) throws Exception{
		Scanner reader = new Scanner(System.in);
		out = new PrintWriter(new File("a.out"));
		
		int times = reader.nextInt();
		for(int t = 1; t <= times; t++){
			int n = reader.nextInt();
			int[] v = new int[n];
			int a = 0, b = 0;
			int rate = 0;
			for(int i = 0; i < n; i++){
				v[i] = reader.nextInt();
				if(i > 0) a += Math.max(0, v[i-1] - v[i]);
				if(i > 0) rate = Math.max(rate, v[i-1] - v[i]);
			}
			for(int i = 0; i < n-1; i++)
				b += Math.min(rate, v[i]);
			String msg = "Case #"+t+": "+a+" "+b;
			out.println(msg);
			System.out.println(msg);
		}
		out.close();
	}
}
