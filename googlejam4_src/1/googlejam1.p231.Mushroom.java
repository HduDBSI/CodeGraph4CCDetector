package googlejam1.p231;
import java.io.*;
import java.util.*;

class Mushroom {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("A-large.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("A-large.out")));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int num = Integer.parseInt(st.nextToken());
    for(int i=0;i<num;i++){
    	st = new StringTokenizer(f.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(f.readLine());
    	int[] a = new int[n];
    	for(int j=0;j<n;j++)
    		a[j] = Integer.parseInt(st.nextToken());
    	long cnt1=0,cnt2=0,max=0;
    	for(int j=0;j<n-1;j++){
    		max = (max<a[j]-a[j+1])? a[j]-a[j+1]:max;
    		cnt1+=(a[j]-a[j+1]>0)?a[j]-a[j+1]:0;
    	}
    	for(int j=0;j<n-1;j++){
    		cnt2+=(a[j]>=max)?max:a[j];
    	}
    	out.format("Case #%d: %d %d\n",i+1,cnt1,cnt2);
    }
    out.close();                                  // close the output file
    System.exit(0);                               // don't omit this!
  }
}