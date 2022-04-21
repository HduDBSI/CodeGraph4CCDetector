package googlejam8.p023;
import java.io.*;
import java.util.*;

public class A
{
	public static void main(String[] args)
	{
		int ind,tmp,n,child;
		
		Scanner in=new Scanner(System.in);
		int numRuns=in.nextInt();
		for (int run=1; run<=numRuns; run++)
		{
			n=in.nextInt();
			int[] count = new int[n];
			int[] heap = new int[n];
			int total=0;
			for (int i=0; i<n; i++)
			{
				count[i]=in.nextInt();
				total+=count[i];
				heap[i]=i;
				ind=i;
				while (count[heap[ind]]>count[heap[(ind-1)/2]])
				{
					heap[ind]=heap[(ind-1)/2];
					ind=(ind-1)/2;
					heap[ind]=i;
				}
			}
			
			String solution="";
			for (int i=0; i<total; i++)
			{
				tmp=heap[0];
				solution+=(char)('A'+heap[0]);
				count[heap[0]]--;
				ind=0;
				while (true)
				{
					child=ind*2+1;
					if (child+1<n && count[heap[child]]<count[heap[child+1]])
						child++;
					if (child<n && count[heap[child]]>count[heap[ind]])
					{
						heap[ind]=heap[child];
						heap[child]=tmp;
						ind=child;
					}
					else
						break;
				}
				if (2*count[heap[0]]<=(total-1-i))
					solution+=" ";
			}
			System.out.println("Case #"+run+": "+solution.trim());
		}
	}
}