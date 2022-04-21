package googlejam1.p619;
import java.util.Scanner;

public class A {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
	
		int T = sc.nextInt();
	
		for(int z=1; z<=T;z++)
		{
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			
			int count1 = 0;
			int count2 = 0;
			
			int i = 0;
			while(i<N-1)
			{
				if(arr[i]<arr[i+1])
					i++;
				else
				{
					count1 += arr[i]-arr[i+1];
					i++;
				}
			}
			
			int max = arr[0]-arr[1];
			for(int j=1;j<N-1;j++)
				if(max < arr[j]-arr[j+1])
					max = arr[j]-arr[j+1];
			for(int k=0;k<N-1;k++)
			{
				if(arr[k]-max <= 0)
				{
					count2 += arr[k];
				}
				else
					count2 += max;
			}
			
			System.out.println("Case #" + z + ": " + count1 + " " + count2);
		}
	}
	
	
}
