package googlejam8.p482;


import r1A.A;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by suleymanuslu on 5/8/16.
 * CJ 16 R1C A
 */
public class C1 {

    private String smallInput = "res/r1C/A/a_small.in";
    private String smallOutput = "res/r1C/A/a_small.out";
    private String bigInput = "res/r1C/A/a_big.in";
    private String bigOutput = "res/r1C/A/a_big.out";

    private int n;  // number of cases

    public static void main(String[] args) {

        C1 c = new C1();
        try {
		    Scanner sc = new Scanner(new FileReader(c.bigInput));
		    PrintWriter pw = new PrintWriter(c.bigOutput);
		    c.n = sc.nextInt();
		    for(int i=0; i<c.n; i++) {    //case
		        int s = sc.nextInt();
		        int[] a = new int[s];
		        int t = 0;
		        for(int j=0; j<s; j++) {
		            a[j] = sc.nextInt();
		            t += a[j];
		        }
		        int x = i+1;
		        pw.print("Case #"+x+":");
		
		        for(int j=t; j>2; j--) {    // t adet removal
		
		            int lar = 0;
		            int slar = 0;
		            int in = 0;
		            int in2 = 0;
		
		            for(int k=0; k<s; k++) {    // one iter
		                if(a[k] > lar) {
		                    if(lar != 0) {
		                        slar = lar;
		                        in2 = in;
		                    }
		                    lar = a[k];
		                    in = k;
		                }
		                else if(a[k] > slar) {
		                    slar = a[k];
		                    in2 = k;
		                }
		            }
		            if(lar == slar & s==2){
		                char c1 = 'A';
		                char c2 = 'A';
		                c1 += in;
		                c2 += in2;
		                pw.print(" "+c1+c2);
		                a[in]--;
		                a[in2]--;
		                j--;
		            }
		            else {
		                char c1 = 'A';
		                c1 += in;
		                pw.print(" " + c1);
		                a[in]--;
		            }
		        }
		        int on = 0;
		        int tw = 0;
		        for(int f=0; f<s; f++) {
		            if(a[f] > 0) {
		                on = f;
		                a[f]--;
		                break;
		            }
		        }
		        for(int f=0; f<s; f++) {
		            if(a[f] > 0) {
		                tw = f;
		                break;
		            }
		        }
		        char ch1 = 'A';
		        char ch2 = 'A';
		        ch1 += on;
		        ch2 += tw;
		        pw.print(" "+ch1+ch2);
		        pw.println();
		    }
		    sc.close();
		    pw.close();
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
        //a.solve();
        //a.writeOutput();
    }
}
