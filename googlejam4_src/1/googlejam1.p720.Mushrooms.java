package googlejam1.p720;
import java.io.*;
import java.util.*;

public class Mushrooms {
	private static int[]mushrooms;
	public static void main(String[]args) throws Exception
	{
		PrintWriter o=new PrintWriter(new File("mushroomsout2.txt"));
		Scanner scan=new Scanner(new File("A-large (2).in"));
		int n=Integer.parseInt(scan.nextLine());
		for(int i=1;i<=n;i++)
		{
			int size=Integer.parseInt(scan.nextLine());
			mushrooms=new int[size];
			String[] sa=scan.nextLine().split(" ");
			for(int j=0;j<size;j++)
				mushrooms[j]=Integer.parseInt(sa[j]);
			ArrayList<Integer>diffs=new ArrayList<Integer>();
			for(int j=0;j<size-1;j++)
				diffs.add(mushrooms[j]-mushrooms[j+1]);
			Collections.sort(diffs,Collections.reverseOrder());
			int count=0;
			for(int j:diffs)
				if(j>0)
					count+=j;
			int count2=0;
			for(int j=0;j<size-1;j++)
			{
				if(mushrooms[j]-diffs.get(0)>=0)
					count2+=diffs.get(0);
				else
					count2+=mushrooms[j];
			}
			o.println("Case #"+i+": "+count+" "+count2);
		}
		o.close();
	}
}
