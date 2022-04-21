package googlejam1.p449;


import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author greg
 */
public class GCJQualA {

    public static void main(String[] args) {
        GCJQualA g = new GCJQualA();
        Scanner br = null;
		        BufferedWriter bw;
		
		        try {
		            br = new Scanner(new File("src/gcj20151a/A-small-practice.in"));
		            bw = new BufferedWriter(new FileWriter("src/gcj20151a/A-small-output.txt"));
		//            bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		            int numTests = br.nextInt();
		            for (int i = 0; i < numTests; i++) {
		                int N = br.nextInt();
		
		                int[] m = new int[N];
		                
		                for (int j = 0; j < N; j++) {
		                    m[j] = br.nextInt();
		                }
						int total = 0;
						int prev = 0;
						for (int i1 = 0; i1 < N; i1++) {
						    int n = m[i1];
						    
						    if ( n < prev ) {
						        // Then she ate some
						        total += (prev-n);
						    }
						        
						    prev = n;
						}
						int a = total;
						int total1 = 0;
						int rate = 0;
						int prev1 = 0;
						for (int i1 = 0; i1 < N; i1++) {
						    int n = m[i1];
						    int periodRate = prev1 - n;
						    if ( periodRate < 0 ) {
						        periodRate = 0;
						    }
						    if ( periodRate > rate ) {
						        rate = periodRate;
						    }
						    prev1 = n;
						}
						// prev is now the remaining on the plate that she didn't eat.
						// total what was available per interval ( can't eat more than what's there)
						for (int i2 = 0; i2 < N-1; i2++) {
						    int n = m[i2];
						    total1 += (n > rate)?rate:n;
						}
						int b = total1;
		                
		                String answer = a + " " + b;
		
		                bw.write("Case #" + (i + 1) + ": ");
		                System.out.println("Case #" + (i + 1) + ": ");
		                bw.write(answer);
		                System.out.println(answer);
		                bw.newLine();
		            }
		            bw.close();
		        } catch (IOException ex) {
		            Logger.getLogger(g.getClass().getName()).log(Level.SEVERE, null, ex);
		        } finally {
		            try {
		                if (br != null) {
		                    br.close();
		                }
		            } catch (Exception ex) {
		                Logger.getLogger(g.getClass().getName()).log(Level.SEVERE, null, ex);
		            }
		        }
    }
}
