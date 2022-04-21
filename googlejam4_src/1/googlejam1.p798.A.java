package googlejam1.p798;
import java.util.*;
import java.io.*;
class A{
     final static String filename="a";
     public static void main(String [] args)
     {
          try{
               Scanner sc=new Scanner(new File(filename+".in"));
               PrintWriter pw=new PrintWriter(new FileOutputStream(filename+".out"));
               int gcase=sc.nextInt();
               for(int n=1;n<=gcase;n++)
               {
				   int c=sc.nextInt();
				   int[] m=new int[c];
				   int max=0;
				   int m1=0;
				   int current=0;
				   for(int i=0;i<c;i++)
				   {
					   m[i]=sc.nextInt();
					   
					   if(current>m[i])
					   {
							int di=current-m[i];
							m1+=di;
							if(max<di)
							{
								max=di;
							}
					   }
					   current=m[i];
				   }
				   int m2=0;
				   for(int i=0;i<c-1;i++)
				   {
					   if(m[i]<max)
						   m2+=m[i];
					   else
						   m2+=max;
				   }
				   
                   System.out.println("Case #"+n+": "+m1+" "+m2);
                   pw.println("Case #"+n+": "+m1+" "+m2);
               }
                  pw.close();
          }catch(FileNotFoundException f)
          {
               f.printStackTrace();
          }
     }
}