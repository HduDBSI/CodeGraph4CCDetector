package googlejam8.p652;
import java.util.*;
import java.io.*;

public class SenateEvacuation 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc=new Scanner(new File("cur/SenateEvacuationLarge.in"));
        PrintWriter pout=new PrintWriter("cur/SenateEvacuationLarge.out");
        
        int i,j,t,z,n;
        
        t=sc.nextInt();
        
        for(z=1;z<=t;z++)
        {
            pout.print("Case #"+z+": ");
            n=sc.nextInt();
            int a[]=new int[n];
            for(i=0;i<n;i++)
                a[i]=sc.nextInt();
            int len=n;
            while(len>0)
            {
                int max1=0,max2=1;
                for(i=1;i<n;i++)
                {
                    if(a[max1]<a[i])
                    {
                        max2=max1;
                        max1=i;
                    }
                    else if(a[max2]<a[i])
                        max2=i;
                }
                if(len==3&&a[max1]==1)
                {
                    pout.print((char)(max1+65)+" ");
                    a[max1]--;
                }
                else{
                    if(a[max1]==a[max2])
                    {
                        pout.print((char)(max1+65)+""+(char)(max2+65)+" ");
                        a[max1]--;a[max2]--;
                    }
                    else 
                    {
                        pout.print((char)(max1+65)+""+(char)(max1+65)+" ");
                        a[max1]-=2;
                    }
                }
                if(a[max1]==0)
                    len--;
                if(a[max2]==0)
                    len--;
            }
            
            pout.println("");
        }   
        pout.close();
    }
}