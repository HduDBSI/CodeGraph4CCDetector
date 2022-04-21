package googlejam1.p040;


import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class MushroomMonster {
    
    public static void main(String[] args) throws Exception {
        File inputFile = new File("A-large.in");
        Scanner in = new Scanner(inputFile);
        File outputFile = new File("output.txt");
        PrintWriter out = new PrintWriter(outputFile);

        int T = in.nextInt();
        for (int t=0; t<T; t++) {
            int N = in.nextInt();
            int[] A = new int[N];
            for (int n=0; n<N; n++) {
                A[n] = in.nextInt();
            }
            long y = 0;
            long max = 0;
            for (int n=1; n<N; n++) {
                long diff = A[n-1]-A[n];
                if (diff > 0) {
                    y += diff;
                    max = Math.max(max, diff);
                }
            }
            long z = 0;
            for (int n=0; n<N-1; n++) {
                z += Math.min(max, A[n]);
            }
            
            out.println("Case #"+(t+1)+": "+y+" "+z);
        }

        out.close();
    }
    
}
