package googlejam1.p803;


import java.util.Scanner;

public class SolutionA {

	public static void main(String[] args) {
		Scanner scanInput = new Scanner(System.in);
		int T = scanInput.nextInt();
		if(T < 1 || T >100)
		{
			return;
		}
		Integer[] method1 = new Integer[T];
		Integer[] method2 = new Integer[T];
		for(int t=1; t<=T; t++) {
			int totalIntervals = scanInput.nextInt();
			Integer[] mushes = new Integer[totalIntervals];
			mushes[0] = scanInput.nextInt();
			method1[t-1] =0;
			method2[t-1] = 0;
			int maxDiff = -1;
			for(int i=1;i<totalIntervals;i++)
			{
				mushes[i] = scanInput.nextInt();
				if(mushes[i-1] > mushes[i])
				{
					int currDiff = mushes[i-1] - mushes[i];
					method1[t-1] += currDiff;
					if(maxDiff < currDiff)
					{
						maxDiff = currDiff;
					}
				}
				
			}
			for(int i=0;i<totalIntervals - 1;i++)
			{
				if(mushes[i]<=maxDiff)
				{
					method2[t-1]+= mushes[i];
				}
				else
				{
					method2[t-1] += maxDiff;
				}
			}
			if(method1[t-1]<0) method1[t-1] = 0;
			if(method2[t-1]<0) method2[t-1] = 0;
		}
		for(int c=1;c<=T;c++)
		{
			String result = "Case #" + c + ": " + method1[c-1] + " " + method2[c-1];
			System.out.println(result);
		}

	}

}
