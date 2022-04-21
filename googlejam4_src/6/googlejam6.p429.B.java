package googlejam6.p429;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by suleymanuslu on 4/15/16.
 * CJ16 R1A 2
 */
public class B {

    String smallInput = "res/r1A/B/b_small.in";
    String smallOutput = "res/r1A/B/b_small.out";
    String bigInput = "res/r1A/B/b_big.in";
    String bigOutput = "res/r1A/B/b_big.out";

    int n;  // number of cases
    int d;
    int a[] = new int[2501];


    public static void main(String[] args) {

        B b = new B();
        try {
		    Scanner sc = new Scanner(new FileReader(b.smallInput));
		    PrintWriter pw = new PrintWriter(b.smallOutput);
		    b.n = sc.nextInt();
		
		    for(int c=1; c<=b.n; c++) {
		        b.d = sc.nextInt();
		        for(int i1=0; i1<2501; i1++) {
				    b.a[i1] = 0;
				}
		        for (int i = 0; i < 2 * b.d * b.d - b.d; i++) {
		            int r = sc.nextInt();
		            b.a[r]++;
		        }
		        pw.print("Case #"+c+":");
		        for(int j=0; j<2501; j++) {
		            if(b.a[j]%2==1)
		                pw.print(" "+j);
		        }
		        pw.println();
		    }
		    sc.close();
		    pw.close();
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		}
        //b.solve();
        //b.writeOutput();
    }
}
