package googlejam1.p418;
import java.io.*;
import java.util.*;
public class Jam1AA{
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader( new FileReader("g.in"));
		PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("gJamout.txt")));
		//Scanner f = new Scanner(System.in);	
		int t = Integer.parseInt(f.readLine());
		for(int iii = 1; iii <= t; iii++){
			int num = Integer.parseInt(f.readLine());
			String[] cur = f.readLine().split(" ");	
			int[] te = new int[num];
			for(int i = 0; i < num; i++){
				te[i] = Integer.parseInt(cur[i]);
			}
			int res1 = 0;
			for(int i = 1; i < num; i++){
				if(te[i] < te[i - 1]){
					res1 += te[i - 1] - te[i];
				}
			}
			int res2 = 0; int md = 0;
			for(int i = 1; i < num; i++){
				md = Math.max(md, te[i - 1] - te[i]);
			}
			for(int i = 0; i < num - 1; i++){
				res2 += Math.min(md, te[i]);
			}
			out.println("Case #" + iii + ": " + res1 + " " + res2);
		}
		out.close();
		System.exit(0);
	}
}