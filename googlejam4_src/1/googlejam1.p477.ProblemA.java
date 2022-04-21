package googlejam1.p477;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class ProblemA {

    public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(new File("ProblemA.txt.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("ProblemA.txt.out")));
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<T;i++) {
            int n = sc.nextInt();
            int m[] = new int[n];
            int minMethodA = 0;
            int minMethodB = 0;
            int maxDiff =0;
            for(int idx=0;idx<n;idx++) {
                m[idx] = sc.nextInt();
                if(idx !=0) {
                    if (m[idx] < m[idx-1]) {
                        minMethodA += (m[idx-1] - m[idx]);
                    }
                    if((m[idx-1] - m[idx]) > maxDiff) {
                        maxDiff = (m[idx-1] - m[idx]);
                    }
                }
            }
            for(int idx=0;idx<n-1;idx++) {
                if(m[idx] <= maxDiff) {
                    minMethodB += m[idx];
                } else {
                    minMethodB += maxDiff;
                }
            }
            
		    bw.write("Case #" + (i+1) +": " + minMethodA + " " + minMethodB +"\n");
		}
		bw.close();
        sc.close();
	}
}