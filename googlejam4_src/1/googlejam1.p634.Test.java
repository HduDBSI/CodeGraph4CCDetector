package googlejam1.p634;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader in;
		PrintWriter out;
		try {
			
			in = new BufferedReader(new FileReader("/home/devesh/Downloads/A-large (1).in"));
			out = new PrintWriter(new FileWriter("/home/devesh/Code_jam/output.txt")); 
		 
			
			
		int T = Integer.parseInt(in.readLine()); 
		ArrayList<Integer> list;
		int count=0,cnt=0,s;
		String str;
		String arr[];
		
		
		for(int i=1; i<=T ; i++)
		{
			// Case 1
			int N = Integer.parseInt(in.readLine());
			String S = in.readLine();
			String inpt[] = S.split(" ");
			int[] inp = new int [N];
			int sum1 = 0,sum2=0,maxdiff=0;
			for (int n=0; n < N ; n++)
			{
				inp[n] = Integer.parseInt(inpt[n]);
				if(n>0 && inp[n-1] > inp[n])
				{
					sum1= sum1 + inp[n-1] - inp[n];
				}
			}
			for (int n=1; n < N ; n++)
			{
				if(inp[n-1] > inp[n] && maxdiff < inp[n-1] - inp[n] )
					maxdiff = inp[n-1] - inp[n];
			}
			//System.out.println(maxdiff);
			for (int n=0; n < N-1 ; n++)
			{
				if(maxdiff > inp[n])
					sum2  = sum2 + inp[n];
				else
					sum2 = sum2 + maxdiff;
			}
			
			out.println("Case #"+i+": "+sum1 + " "+ sum2);
			System.out.println(sum1);
			System.out.println(sum2);
			
		}
		 
		out.close();
		
		in.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	
}
