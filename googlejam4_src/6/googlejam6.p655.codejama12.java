package googlejam6.p655;
import java.util.Arrays;
import java.util.Scanner;

public class codejama12 {
	
	public static void main(String ... nopushupsformesarge) throws Exception
	{
		Scanner input = new Scanner(System.in);
		float T = input.nextFloat();
		for (int n = 0; n < T; n++)
		{
			int N=input.nextInt();
			int[] inarr=new int[(2*N-1)*N];
			for(int i=0;i<(2*N-1)*N;i++)
			{ //first val is for findin if all list been traverse
					inarr[i]=input.nextInt();
			}//input of 2*n-1 list
			
			for(int j=1;j<(2*N-1)*N;j++)
			{
				int key = inarr[j];
	            int i = j-1;
	            while ( (i > -1) && ( inarr [i] > key ) ) 
	            {
	                inarr [i+1] = inarr [i];
	                i--;
	            }
	           inarr[i+1] = key;
			}
			
			String str="";
			for(int j=0;j<(2*N-1)*N;)
			{
				int key=inarr[j];
				int count=0;
				while(j<(2*N-1)*N)
				{
					if(inarr[j]!=key)
					{
						break;
					}
					j=j+1;
					count++;
					
				}
				if(count%2!=0)
				{
					str=str+" "+key;
				}
			}
			System.out.println("Case #"+(n+1)+":"+str);
		}
	}
}
