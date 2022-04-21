package googlejam1.p139;
import java.io.*;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {
    /**
     * author geshpaniec
     * 23.10.2014
     */

    StringTokenizer in;
    BufferedReader inb;
    PrintWriter out;
    static boolean local;
    final String problemname = "success";
    final static String _localArg="geshpaniec1";
    final static byte IO=3;
        /* IO:
         * 1 - standard I/O
         * 2 - input.txt/output.txt
         * 3 - problemname.in/problemname.out
         */




    public static void main(String[] args) throws Exception {
        local = false;
        if (args.length == 1 && args[0].equals(_localArg))
            local = true;
		Main r = new Main();
        if (Main.local) {
		    r.inb = new BufferedReader(new FileReader("input.txt"));
		    r.out = new PrintWriter(new OutputStreamWriter(System.out));
		} else {
		    switch (Main.IO){
		        case 1:
		            r.inb = new BufferedReader(new InputStreamReader(System.in));
		            r.out = new PrintWriter(new OutputStreamWriter(System.out));
		            break;
		        case 2:
		            r.inb = new BufferedReader(new FileReader("input.txt"));
		            r.out = new PrintWriter(new FileWriter("output.txt"));
		            break;
		        case 3:
		            r.inb = new BufferedReader(new FileReader(r.problemname+".in"));
		            r.out = new PrintWriter(new FileWriter(r.problemname+".out"));
		            break;
		    }
		}
		r.in = new StringTokenizer("");
		double Time=System.nanoTime();
		int T = Integer.parseInt(r.next());
		A:for (int q = 1; q <= T; q++) {
		    int n=Integer.parseInt(r.next());
			int[] a1=new int[n];
			for (int i1=0;i1<n;i1++)
			    a1[i1]=Integer.parseInt(r.next());
		    int[] a = a1;
		    long ans1=0,ans2 = 0;
		    int maxP=0;
		    for (int i = 1; i < n; i++) {
		        if (a[i-1]>a[i])
		            ans1+=a[i-1]-a[i];
		            maxP = max(maxP,a[i-1]-a[i]);
		    }
		    for (int i = 0; i < n-1; i++) {
		        if (a[i]>maxP){
		            ans2+=maxP;
		        }
		        else{
		            ans2+=a[i];
		        }
		    }
		    r.out.println("Case #"+q+": "+ans1+" "+ans2);
		}
		if (Main.local){
		    Time=System.nanoTime()-Time;
		    r.out.println();
		    r.out.println(" Time work: "+Time/(1e9)+" seconds");
		}
		r.out.flush();
    }

    String next() throws Exception {
        if (!in.hasMoreTokens())
            in=new StringTokenizer(inb.readLine());
        return in.nextToken();
    }


}