package googlejam1.p459;


import java.io.*;
import java.util.*;

/**@author Jun Yoon <junviolin@gmail.com>*/
public class CodeJam2015Round1AA {

    public static void main(String[] args) throws Exception {
        String output = "";
        Scanner input = new Scanner(new FileReader("./A-large.in"));
        
        int numCases = input.nextInt();
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int N = input.nextInt();
            long[] Ms = new long[N];
            long[] diffs = new long[N - 1];
            for (int i = 0; i < N; i++) {
                Ms[i] = input.nextInt();
            }
            for (int i = 0; i < N - 1; i++) {
                diffs[i] = Ms[i] - Ms[i + 1];
            }
            long y = 0, maxZ = 0, z = 0;
            for (long diff : diffs) {
                if (diff > 0) {
                    y += diff;
                }
                if (maxZ < diff) {
                    maxZ = diff;
                }
            }
            for (int i = 0; i < N - 1; i++) {
                if (Ms[i] <= maxZ)
                    z += Ms[i];
                else
                    z += maxZ;
            }
            output += String.format("Case #%d: %d %d\n", caseNum, y, z);
        }
        
        input.close();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./A-large.out"))) {
            bw.write(output);
        }
    }
}
