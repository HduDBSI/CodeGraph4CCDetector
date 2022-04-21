package googlejam6.p588;
import java.io.*;
import java.util.*;
public class B {
	public static void main(String[]args)throws Exception
	{
		Scanner scan=new Scanner(new File("B-large.in"));
		PrintWriter out=new PrintWriter(new File("B-out.txt"));
		int n=Integer.parseInt(scan.nextLine());
		for(int i=1;i<=n;i++)
		{
			int size=Integer.parseInt(scan.nextLine());
			int[]counts=new int[2500];
			for(int j=0;j<2*size-1;j++)
			{
				String[]heights=scan.nextLine().split(" ");
				for(int k=0;k<heights.length;k++)
				{
					counts[Integer.parseInt(heights[k])-1]++;
				}
			}
			ArrayList<Integer>solution=new ArrayList<Integer>();
			for(int j=0;j<counts.length;j++)
			{
				if(counts[j]%2!=0)
					solution.add(j+1);
			}
			Collections.sort(solution);
			out.print("Case #"+i+": "+solution.get(0));
			for(int j=1;j<solution.size();j++)
			{
				out.print(" "+solution.get(j));
			}
			out.println();
		}
		out.close();
	}
}
