package googlejam1.p598;
/*
ID: abhi1
LANG: JAVA
TASK: gift1
*/

import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Map;
import java.util.HashMap;


public class mushroommonster {
	public static void main(String[] args)
	{
		
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter("test1.out"));
			BufferedReader br = new BufferedReader(new FileReader("test.in"));
			
			int T = Integer.parseInt(br.readLine());	
			
			for(int i = 1; i <= T; i++)
			{
				br.readLine();
				String[] temp = br.readLine().split(" ");
				int[] nums = new int[temp.length];
				for(int j = 0 ; j < temp.length; j++)
					nums[j] = Integer.parseInt(temp[j]);
				
				int maxDiff = -1;
				for(int j = 0; j < temp.length - 1; j++)
				{
					if(nums[j] - nums[j + 1] > maxDiff)
						maxDiff = nums[j] - nums[j + 1];
				}
				
				//double minRate = ((double) maxDiff)/10;
				int z = 0;
				for(int j = 0; j < nums.length - 1; j++)
				{
					if (nums[j] - maxDiff <= 0)
						z += nums[j];
					else
						z += maxDiff;
				}
				
				
				int y = 0;
				for(int j = 0; j < nums.length - 1; j++)
				{
					if (nums[j + 1] < nums[j])
						y += (nums[j] - nums[j + 1]);
				}
				
				bw.write("Case #" + i + ": " + y + " " + z);
				bw.newLine();
			}
			
			
			
			bw.close();
			br.close();
			
		}
		catch (Exception ex) 
		{
			System.out.println(ex.getMessage());
		}
	}
}
