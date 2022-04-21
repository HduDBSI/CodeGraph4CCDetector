package googlejam1.p197;
import java.util.Scanner;


public class ProbA {
public static void main(String[] args)
{
	Scanner sc = new Scanner(System.in);
	int numcases = sc.nextInt();
	for(int cas  = 1;cas <= numcases;cas++ )
	{
		System.out.print("Case #"+cas+": ");
		
		long methone=0;
		int numticks = sc.nextInt();
		long[] values = new long[numticks];
		for(int i=0;i<numticks;i++)
		{
			values[i] = sc.nextInt();
		}
		long maxdec=0;
		for(int i=1;i<numticks;i++)
		{
			if(values[i] <values[i-1])
			{
				methone+= values[i-1]-values[i];
				if(values[i-1] - values[i]>maxdec)
				{
					maxdec = values[i-1] - values[i];
				}
			}
		}
		int methtwo =0;
		for(int i=0;i<numticks-1;i++)
		{
			if(values[i]>maxdec)
			{
				methtwo+= maxdec;
			}else
			{
				methtwo+= values[i];
			}
			
		}
		System.out.println(methone+" "+methtwo);
		
		
		
		
	}
}
}
