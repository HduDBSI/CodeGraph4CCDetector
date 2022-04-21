package googlejam1.p820;
import java.io.*;
import java.util.*;

class DoIt
{
    public static void main(String[] args)throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int test = sc.nextInt();
        for(int t=1; t<=test; t++)
        {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0; i<n; i++)
            {
                a[i]=sc.nextInt(); 
            }
            int check1 = 0;
            int maxDiff = 0;
            for(int i=1; i<n; i++)
            {
                if(a[i]<a[i-1])
                    check1 += a[i-1]-a[i]; 
                if((a[i-1]-a[i])>maxDiff )
                {
                    maxDiff = a[i-1]-a[i];
                }
            }
            int check2 = 0;
            for(int i=0; i<(n-1); i++)
            {
                if(a[i] <= maxDiff)
                {
                    check2 += a[i];
                }
                else
                    check2 += maxDiff;
            }
            System.out.println("case #"+t+": "+check1+" "+check2);
        }
    }
}