package googlejam1.p738;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class A1 {

	public static void main(String[] args) {
		
		Scanner sc;
		try {
			sc = new Scanner (new File(
					"D://Java WS//GoogleCodeJam//src//A-large.in"));
			File outputA1Large = new File(
					"D://Java WS//GoogleCodeJam//src//A1Large.txt");
			PrintWriter pw = new PrintWriter(outputA1Large);
					
		int testCases = sc.nextInt();
		for (int cases = 0; cases<testCases; cases++)
		{
			int arrSize = sc.nextInt();
			int arr[] = new int[arrSize];
			for(int i=0; i<arrSize;i++)
			{
				arr[i]= sc.nextInt();
			}
			int sum=0;
			int sum2 =0;
			int maxDiff = 0;
			for(int i=1; i<arrSize;i++)
			{
				if(arr[i-1]>arr[i])
				{
					int diff = arr[i-1] - arr[i];
					sum += diff;
					if(diff>maxDiff)
					{
						maxDiff = diff;
					}
				}
			}
			for(int i=0; i<arrSize-1;i++)
			{
				if(arr[i]<=maxDiff)
					sum2 += arr[i];
				else
					sum2 += maxDiff;
			}
			
			System.out.printf("Case #%d: %d %d\n", cases+1, sum, sum2);
			pw.println("Case #"+(cases+1)+": "+sum+" "+ sum2);

		}
		
		pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
