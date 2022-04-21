package googlejam3.p035;
import java.io.*;
import java.util.*;


public class CJ2015Round1CA {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("A-large.in"));
		//BufferedReader in = new BufferedReader(new FileReader("temp.txt"));
		PrintWriter out  = new PrintWriter(new File("2015Round1CAout.txt"));
		int T = Integer.parseInt(in.readLine());
		for(int a = 1; a < T+1; a++){
			String[] nums = in.readLine().split(" ");
			int R = Integer.parseInt(nums[0]);
			int C = Integer.parseInt(nums[1]);
			int W = Integer.parseInt(nums[2]);
			int rowguess = (C-W)/W;
			int ret = rowguess*R+R-1;
			ret +=W;
			if (C%W!=0){
				ret++;
			}
			System.out.println("Case #"+a+": "+ret);
			out.println("Case #"+a+": "+ret);
		}
		in.close();
		out.close();
	}
}
