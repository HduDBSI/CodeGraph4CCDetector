package googlejam1.p536;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

	static StringBuilder out;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("input.in"));
		out = new StringBuilder();
		Long start = System.currentTimeMillis();
		int T = Integer.parseInt(in.readLine());
		
		for(int t=0; t<T; t++)
		{
			int N = Integer.parseInt(in.readLine());
			String[] line = in.readLine().split(" ");
			int[] nums = new int[N];
			for(int n=0; n<N; n++)
			{
				nums[n] = Integer.parseInt(line[n]);
			}
			
			int sumA = 0;
			int sumB = 0;
			int maxGap = 0;
			int[] gaps = new int[N];
			
			for(int n=1; n<N; n++)
			{
				
				gaps[n] = nums[n-1]-nums[n];
				
				if(nums[n]< nums[n-1])
				{
					//handle first case
					sumA+= gaps[n];
				}
				//prep for second case
				 
				if(gaps[n] > maxGap)
				{
					maxGap = gaps[n]; 
				}
			}
			
			for(int n=0; n<N-1; n++)
			{
				sumB += Math.min(maxGap, nums[n]);
			}
			
			out.append("Case #");
			out.append((t+1));
			out.append(": ");
			out.append(sumA);
			out.append(" ");
			out.append(sumB);
			out.append("\r\n");
			
		}
		
		
		
		
		BufferedWriter fOut = new BufferedWriter(new FileWriter("output.txt"));
		fOut.write(out.toString());
		fOut.close();
		Long end = System.currentTimeMillis();
		System.out.println("Time: " + (end-start));

	}

}
