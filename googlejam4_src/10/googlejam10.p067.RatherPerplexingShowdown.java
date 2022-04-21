package googlejam10.p067;


import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class RatherPerplexingShowdown {
    
    public static void main(String[] args) throws Exception {
        File inputFile = new File("A-large.in");
        Scanner in = new Scanner(inputFile);
        File outputFile = new File("output.txt");
        PrintWriter out = new PrintWriter(outputFile);

        String[][] answers = new String[13][3];
        answers[0] = new String[] {"P", "R", "S"};
        for (int n=1; n<=12; n++) {
            // P <- P R
            String s1 = answers[n-1][0] + answers[n-1][1];
            String s2 = answers[n-1][1] + answers[n-1][0];
            answers[n][0] = s1.compareTo(s2) < 0 ? s1 : s2;
            // R <- R S
            s1 = answers[n-1][1] + answers[n-1][2];
            s2 = answers[n-1][2] + answers[n-1][1];
            answers[n][1] = s1.compareTo(s2) < 0 ? s1 : s2;
            // S <- S P
            s1 = answers[n-1][2] + answers[n-1][0];
            s2 = answers[n-1][0] + answers[n-1][2];
            answers[n][2] = s1.compareTo(s2) < 0 ? s1 : s2;            
        }

        int T = in.nextInt();
        for (int t=0; t<T; t++) {
            int N = in.nextInt();
            int R = in.nextInt();
            int P = in.nextInt();
            int S = in.nextInt();
            String best = null;
            for (int i=0; i<3; i++) {
                String cand = answers[N][i];
                int[] stats = new int[3];
                for (char c : cand.toCharArray()) {
                    if (c == 'R') {
                        stats[0]++;
                    } else if (c == 'P') {
                        stats[1]++;
                    } else {
                        stats[2]++;
                    }
                }
                if (stats[0] == R && stats[1] == P && stats[2] == S) {
                    if (best == null || cand.compareTo(best) < 0) {
                        best = cand;
                    }
                }
            }
            String answer = (best == null) ? "IMPOSSIBLE" : best;
            out.println("Case #"+(t+1)+": "+answer);
        }

        out.close();
    }
    
}
