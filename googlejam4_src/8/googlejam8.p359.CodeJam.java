package googlejam8.p359;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CodeJam {
    static Scanner scan;
    static PrintWriter out;
    public static void main(String[] arg) {
        try {
            File file = new File("E:\\A-large (2).in");
            scan = new Scanner(file);
            out = new PrintWriter("E:\\data.out");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int c = scan.nextInt();
        for(int i = 0; i < c; i++) {
//            out.println("Case #" + (i+1) + ": " + testcase());
			out.print("Case #" + (i+1) + ": ");
			int n = scan.nextInt();
			int[] A = new int[n];
			for(int i4=0;i4<n;i4++)
			    A[i4] = scan.nextInt();
			if(n == 2) {
				if(A[0] > A[1]) {
					for(int i5=0;i5<A[0]-A[1];i5++)
						out.print("A ");
				} else if(A[0] < A[1]) {
					for(int i3=0;i3<A[1]-A[0];i3++)
						out.print("B ");
				}
				int min = A[0] > A[1] ? A[1] : A[0];
				for(int i2=0;i2<min;i2++)
					out.print("AB ");
			} else {
			while(true) {
			    int max = 0;
			    for (int i1=1;i1<n;i1++) {
			        if(A[max] < A[i1])
			            max = i1;
			    }
			    if(max == n-2 && A[n-2] == 1 && A[n-1] == 1) {
			        out.print((char)(n-2+'A') + "" + (char)(n-1+'A'));
			        break;
			    }
			    out.print((char)(max+'A') + " ");
			    A[max]--;
			}
			}
			out.println();
        }
        scan.close();
        out.close();
    }
}
