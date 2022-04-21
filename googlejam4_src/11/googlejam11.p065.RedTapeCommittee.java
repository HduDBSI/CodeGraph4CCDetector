package googlejam11.p065;


import java.io.File;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class RedTapeCommittee {
    
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ENGLISH);
        File inputFile = new File("B-small-attempt0.in");
        Scanner in = new Scanner(inputFile);
        File outputFile = new File("output.txt");
        PrintWriter out = new PrintWriter(outputFile);

        int T = in.nextInt();
        for (int t=0; t<T; t++) {
            int N = in.nextInt();
            int K = in.nextInt();
            double[] P = new double[N];
            for (int n=0; n<N; n++) {
                P[n] = in.nextDouble();
            }
            double best = 0;
            int limit = 1<<N;
            for (int mask=0; mask<limit; mask++) {
                if (Integer.bitCount(mask) == K) {
                    int bits[] = new int[K];
                    int next = 0;
                    for (int i=0; i<N; i++) {
                        if ((mask & (1<<i)) != 0) {
                            bits[next++] = i;
                        }
                    }

                    double pst = 0;
                    int limit2 = 1<<K;
                    for (int m=0; m<limit2; m++) {
                        if (Integer.bitCount(m) == K/2) {
                            double p = 1;
                            for (int k=0; k<K; k++) {
                                if ((m&(1<<k)) != 0) {
                                    p *= P[bits[k]];
                                } else {
                                    p *= 1-P[bits[k]];
                                }
                            }
                            pst += p;
                        }
                    }
                    best = Math.max(best, pst);
                }
            }
            
            out.println("Case #"+(t+1)+": "+best);
        }

        out.close();
    }
    
}
