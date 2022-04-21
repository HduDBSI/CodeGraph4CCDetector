package googlejam1.p245;


import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by admin on 4/6/2015.
 */
public class A {

    private Scanner scanner;
    private Writer writer;

    public static void main(String[] args) throws IOException {
        A a = new A();
        a.scanner = new Scanner(new FileInputStream("src/cj/y2015/r1a/A-large.in"));
		a.writer = new FileWriter("src/cj/y2015/r1a/A-large.out", false);
		int t = a.scanner.nextInt();
		for (int i=0; i<t; i++) {
		    int n = a.scanner.nextInt();
		    int[] mn = new int[n];
		    long eat1 = 0;
		    long eat2 = 0;
		    int max_d = 0;
		    for (int j=0; j<n; j++) {
		        mn[j] = a.scanner.nextInt();
		        if (j>0) {
		            if (mn[j]<mn[j-1]) {
		                eat1 += (mn[j-1]-mn[j]);
		                int tmp = mn[j-1]-mn[j];
		                if (tmp>max_d)
		                    max_d = tmp;
		            }
		        }
		    }
		    System.out.println("max_d=" + max_d);
		    double r = ((double)max_d)/10;
		    // simulate
		    for (int j=0; j<n; j++) {
		        if (j>0) {
		            int prev = mn[j-1];
		            int cur = mn[j];
		            if (prev>(r*10)) {
		                eat2 += r*10;
		            } else {
		                eat2 += prev;
		            }
		        }
		    }
		
		
		    a.writer.write("Case #" +(i+1)+": "+eat1+" "+eat2+"\n");
		    System.out.println("Case #" + (i + 1) + ": " + eat1 + " " + eat2);
		}
		a.scanner.close();
		a.writer.close();
    }
}
