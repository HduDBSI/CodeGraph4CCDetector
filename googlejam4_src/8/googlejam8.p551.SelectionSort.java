package googlejam8.p551;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.Scanner;
 
/* Class SelectionSort */
 class SelectionSort {
       
    /* Main method */
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner( System.in );
 int t=sc.nextInt();
 for(int r=1;r<=t;r++)
 {
        int n, i;
        n = sc.nextInt();
        int ar[] = new int[ n ];
        char br[] = new char[ n ];
        char cha='A';
        int s=0;
        for (i = 0; i < n; i++)
            {ar[i] = sc.nextInt();
            s+=ar[i];
            br[i]=cha++;}
            int N = ar.length;
        int  j, pos, temp;
        for (i = 0; i < N-1; i++)
        {
            pos = i;
            for (j = i+1; j < N; j++)
            {
                if (ar[j] < ar[pos])
                {
                    pos = j;
                }
            }
            char tt=' ';
            /* Swap arr[i] and arr[pos] */
            temp = ar[i];tt=br[i];
            ar[i] = ar[pos];br[i]=br[pos];
            ar[pos]= temp;            br[pos]=tt;
        }        
    System.out.print("Case #");
    System.out.print(r);
       System.out.print(":");
       System.out.print(" ");
            double ss=(double)s;
        while(s>0)
        { i=n-1;
                       if( (double)s-2>=(double)s/2 || (s-2)==0)
            {System.out.print(br[i] );
            System.out.print(br[i-1] );
            System.out.print(" " );
            ar[i]--; ar[i-1]--;s=s-2;}
            else{
            ar[i]--;
            s=s-1;
            System.out.print(br[i]);
                     System.out.print(" " );
            }
                 
                   for (int ii = 0; ii < N-1; ii++)
        {
            pos = ii;
            for (j = ii+1; j < N; j++)
            {
                if (ar[j] < ar[pos])
                {
                    pos = j;
                }
            }
             char tt=' ';
            /* Swap arr[i] and arr[pos] */
            temp = ar[ii];tt=br[ii];
            ar[ii] = ar[pos];br[ii]=br[pos];
            ar[pos]= temp;            br[pos]=tt;
        }        
        
    }
    System.out.println();
 }
}}