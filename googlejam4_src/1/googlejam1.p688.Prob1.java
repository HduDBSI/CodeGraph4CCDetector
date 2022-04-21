package googlejam1.p688;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Prob1 {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		String line = in.nextLine();

		for (int t = 0; t < T; t++) 
		{
			line = in.nextLine();
			String[] sN = line.split(" ");
			int N = Integer.parseInt(sN[0]);
			
			line = in.nextLine();
			String[] ss = line.split(" ");
			
			int[] Num = new int[N]; 
			for(int i = 0; i<N; i++)
			{
				Num[i] = Integer.parseInt(ss[i]);
			}
			
			int min1 = 0;
			for(int i = 0; i<N-1; i++)
			{
				if(Num[i+1]<Num[i])
					min1 +=Num[i]-Num[i+1];
					
			}
			
			int min2 = 0;
			ArrayList<Double> diff = new ArrayList<Double>();
			for(int i = 0; i<N-1; i++)
			{
				double temp = Num[i]-Num[i+1];
				diff.add(temp);
			}
			
			double max_diff = Collections.max(diff);
			
			for(int i = 0; i<N-1; i++)
			{
				if(Num[i+1]>Num[i])
				{
					if(Num[i]<=max_diff)
						min2 += Num[i];
					else
						min2 += max_diff;
				}
				else 
				{
					if(Num[i]<max_diff )
						min2+= Num[i];
					else 
						min2+= max_diff;
				}
			}
			

		    System.out.printf("Case #%d: ", t + 1);
			System.out.println(min1 + " "+ min2);
			
			
		}
	}
}
