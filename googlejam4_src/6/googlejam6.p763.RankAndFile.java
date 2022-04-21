package googlejam6.p763;
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class RankAndFile
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int testCase = 1; testCase<=t; testCase++)
		{
			int n = sc.nextInt();
			
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int temp;
			int x = 2*n-1;
			for(int i = 0; i<x; i++)
			{
				for(int j=0; j<n; j++)
				{
					temp = sc.nextInt();
					if(map.containsKey(temp))
					{
						map.put(temp, map.get(temp)+1);
					}
					else
					{
						map.put(temp, 1);
					}	
				}
			}
			TreeSet<Integer> ts = new TreeSet<Integer>();
			for(Map.Entry m: map.entrySet())
			{
				int key = (int)m.getKey();
				int value = (int)m.getValue();
				
				if(value%2 != 0)
					ts.add(key);
			}
			
			System.out.print("\nCase #"+testCase+":");
			for(Integer i: ts)
				System.out.print(" "+i);
		}
		
	}
}