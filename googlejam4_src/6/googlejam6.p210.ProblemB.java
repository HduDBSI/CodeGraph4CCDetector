package googlejam6.p210;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ProblemB {
	static Scanner in=new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException {
		java.io.PrintStream out=new java.io.PrintStream("C:/users/Josh/documents/output.txt");
		int run=in.nextInt();
		for(int p=0;p<run;p++)
		{
			int lists=in.nextInt();
			int slots[][]=new int[lists][2501];
			int slots1[]=new int[2501];
			for(int c=0;c<(2*lists)-1;c++)
			{
				for(int d=0;d<lists;d++)
				{
					int temp=in.nextInt();
					slots[d][temp]++;
					slots1[temp]++;
				}
			}
			
			String outp="";
			int arr[]=new int[lists];
			int count=0;
			for(int b=0;b<2500;b++)
			{
				if(slots1[b]%2!=0)
				{
					arr[count]=b;
					count++;
				}
			}
			for(int x=0;x<lists;x++)
			{
				for(int y=0;y<lists-1;y++)
				{
					if(arr[y]>arr[y+1])
					{
						int temp=arr[y];
						arr[y]=arr[y+1];
						arr[y+1]=temp;
					}
				}
			}
			for(int x=0;x<lists;x++)
			{
				outp+=arr[x];
				outp+=" ";
			}
			out.println("Case #"+(p+1)+": "+outp);
		}
	
	}
}
