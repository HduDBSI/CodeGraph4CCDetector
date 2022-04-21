package googlejam8.p648;
import java.util.*;
import java.io.*;
public class A {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
    	int n=in.nextInt(),total=0;
    	
        Vector<Integer> m=new Vector<Integer>();
    	for(int j=0;j<n;j++)
    	{
    		m.add(in.nextInt());
    		total+=m.elementAt(j);
    	}
    	 System.out.print("Case #" + i + ": ");
    	 int mid ;
        while(total!=0)
        {  mid = (int)Collections.max(m);
        int max;
           int ind1=m.indexOf(mid),ind2=m.lastIndexOf(mid);
           if(ind1 !=-1 && ind2!=-1)
           {  if(ind1!=ind2){
        	   
        	   total-=2;
        	   m.set(ind1, m.elementAt(ind1)-1);
        	   m.set(ind2, m.elementAt(ind2)-1);
        	   max = (int)Collections.max(m);
        	   if(max>total/2)
        	   {
        		   m.set(ind2, m.elementAt(ind2)+1);
        		   total+=1;
        		   System.out.print((char)(ind1+'A')+" ");
        	   }
        	   else
        	   {
        	      System.out.print((char)(ind1+'A')+""+(char)(ind2+'A')+" ");
        	   }
           }
           else
           {  if(m.elementAt(ind1)>2)
           {
        	   System.out.print((char)(ind1+'A')+""+(char)(ind2+'A')+" ");
        	   m.set(ind1, m.elementAt(ind1)-1);
        	   m.set(ind2, m.elementAt(ind2)-1);
        	   total-=2;
           }
           else
           {
        	   System.out.print((char)(ind1+'A')+" ");
        	   m.set(ind1, m.elementAt(ind1)-1);
        	  
        	   total-=1;
           }
           }   
           }
        	
        }
         
     System.out.println();
    }
  }
  
}