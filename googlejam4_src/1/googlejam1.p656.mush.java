package googlejam1.p656;

import java.io.*;
import java.util.*;

public class mush
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new FileReader ("A-large.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter (new FileWriter ("mush.out")));
		
      int t = Integer.parseInt (br.readLine ());
		for(int i=0; i<t; i++) {
         int n = Integer.parseInt (br.readLine ());
         int anum[] = new int[n];
         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
         for(int j=0; j<n; j++)
            anum[j] = Integer.parseInt (st.nextToken());
         int eat1=0;
         for(int j=0; j<n-1; j++) {
            if(anum[j]>anum[j+1])
               eat1+=anum[j]-anum[j+1];
         }
         int max=0;
         for(int j=0; j<n-1; j++) {
            if(anum[j]-anum[j+1] > max)
               max = anum[j]-anum[j+1];
         }
         int eat2=0;
         for(int j=0; j<n-1; j++) {
            if(anum[j] < max)
               eat2 += anum[j];
            else
               eat2+=max;
         }
         pw.println("Case #" + (i+1) + ": " + eat1 + " " + eat2);
      }
      br.close();
      pw.close();
	}
}
