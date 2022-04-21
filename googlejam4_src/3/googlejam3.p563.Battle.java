package googlejam3.p563;
import java.util.*;
class Battle
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		String output="";
		for(int i=1;i<=t;i++)
		{
			int result=0;
			int count=1;
			int r=input.nextInt();
			int c=input.nextInt();
			int w=input.nextInt();
			// int combi = (r-c+1)*x;
			// if(r==c)
			// 	result=c+x-1;
			// else
			// 	result=c+combi-(r-c);
			while(count<=c)
			{
				result+=1;
				count+=w;
			}
			result+=w-1;
			result*=r;
			output+="Case #"+i+": "+result+"\n";			
		}
		System.out.print(output);
	}
}