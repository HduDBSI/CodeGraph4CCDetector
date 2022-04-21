package googlejam1.p435;
import java.util.*;
import java.io.*;

public class A {
public static void main(String args[]) throws Exception
{
	Scanner in = new Scanner(new File("A.in"));
	int count = 1;
	int numcases = in.nextInt();
	while(numcases-->0)
	{
		int numint = in.nextInt();
		int[] vals = new int[numint];
		for(int i=0;i<numint;i++)
			vals[i]=in.nextInt();
		
		int onesum = 0;
		for(int i=0; i<vals.length-1;i++)
		{
			if(vals[i]>vals[i+1])
				onesum+=vals[i]-vals[i+1];
		}
		
		int maxdiff = 0;
		for(int i=0;i<vals.length-1;i++)
		{
			if(vals[i]>vals[i+1])
				if(maxdiff<vals[i]-vals[i+1])
					maxdiff=vals[i]-vals[i+1];
		}
		
		int twosum = 0;
		for(int i=0;i<vals.length-1;i++)
		{
			if(maxdiff>vals[i])
				twosum+=vals[i];
			else
				twosum+=maxdiff;
		}
		System.out.println("Case #" + count + ": "+onesum+" "+twosum);
		count++;
	}
	
}
}
