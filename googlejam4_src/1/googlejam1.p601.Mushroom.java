package googlejam1.p601;
import java.util.*;
import java.io.*;
public class Mushroom {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("A-large (1).in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("submission.out")));
		int T = Integer.parseInt(in.readLine());
		for(int i = 0; i < T; i++){
			int ans1 = 0, ans2 = 0, N = Integer.parseInt(in.readLine()); int[] nums = new int[N], diff = new int[N-1];
			StringTokenizer s = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++){nums[j] = Integer.parseInt(s.nextToken());}
			for(int j = 0; j < N-1; j++)
				if(nums[j+1] < nums[j])
					ans1 += nums[j]-nums[j+1];
			for(int j = 0; j < N-1; j++)
				diff[j] = nums[j] - nums[j+1];
			int max = 0;
			for(int j = 0; j < N-1; j++)
				if(diff[j] > max)
					max = diff[j];
			for(int j = 0; j < N-1; j++){
				if(nums[j] < max){ans2 += nums[j];}
				else{ans2 += max;}
			}
			out.println("Case #" + (i + 1) + ": " + ans1 + " " + ans2);
		}
		out.close();
		System.exit(0);
	}
}
