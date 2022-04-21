package googlejam6.p757;
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
      int t=sc.nextInt();
      for(int k=1;k<=t;k++)
      {
          int n=sc.nextInt();
          List al=new ArrayList();
          int g=2*n-1;
          while(g-->0)
          {
            for(int m=1;m<=n;m++)
            {
                
                 int c=sc.nextInt();
                //Integer b=new Integer(l);
                al.add(c);
            }
          }
          Set set=new TreeSet();
          Collections.sort(al);
          for(int i=0;i<al.size();i++)
         {
            int f= Collections.frequency(al,al.get(i));
            //System.out.print(f+" ");
            if(f%2!=0)
            {
             set.add(al.get(i));
            }
            
         }
         System.out.print("Case #"+k+": ");
         Iterator itr=set.iterator();
         while(itr.hasNext())
         {
             System.out.print(itr.next()+" ");
         }
         System.out.println();
      }

	}
}