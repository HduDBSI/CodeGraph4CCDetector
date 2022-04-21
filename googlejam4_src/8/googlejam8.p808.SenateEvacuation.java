package googlejam8.p808;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SenateEvacuation {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input=new Scanner(new File("Input.in"));
		PrintWriter output=new PrintWriter("Output.out");
		int testCase,totalCases;
		totalCases=input.nextInt();
		for(testCase=1;testCase<=totalCases;testCase++)
		{
			int N=input.nextInt();
			int[] P=new int[N];
			for(int i=0;i<N;i++)
			{
				P[i]=input.nextInt();
			}
			String result="";
			int resultIndex=0;
			for(int i1=0;i1<P.length;i1++)
			{
				if(P[i1]>P[resultIndex])
					resultIndex=i1;
			}
			int firstLargestIndex=resultIndex;
			int resultIndex1=0;
			if(firstLargestIndex==0)
				resultIndex1=1;
			for(int i1=0;i1<P.length;i1++)
			{
				if(i1==firstLargestIndex)
					continue;
				if(P[i1]>P[resultIndex1])
					resultIndex1=i1;
			}
			int secondLargestIndex=resultIndex1;
			//System.out.println("Largest "+firstLargestIndex+" "+secondLargestIndex);
			while(P[firstLargestIndex]-P[secondLargestIndex]>0)
			{
				if(P[firstLargestIndex]-P[secondLargestIndex]>1)
				{
					result+=(char)(65+firstLargestIndex)+""+(char)(65+firstLargestIndex)+" ";
					P[firstLargestIndex]-=2;
				}
				else 
				{
					result+=(char)(65+firstLargestIndex)+" ";
					P[firstLargestIndex]-=1;
				}
				
			}
			for(int i=0;i<P.length;i++)
			{
				if(i==firstLargestIndex || i== secondLargestIndex)
					continue;
				while(P[i]>0)
				{
					if(P[i]-2>=0)
					{
						result+=(char)(65+i)+""+(char)(65+i)+" ";
						P[i]-=2;
					}
					else
					{
						result+=(char)(65+i)+" ";
						P[i]-=1;
					}
				}
			}
			while(P[firstLargestIndex]>0)
			{
				result+=(char)(65+firstLargestIndex)+""+(char)(65+secondLargestIndex)+" ";
				P[firstLargestIndex]--;
			}
			String solution=result;
			System.out.println("Case #"+testCase+": "+solution);
			output.println("Case #"+testCase+": "+solution);
		}

		output.flush();
	}

}
