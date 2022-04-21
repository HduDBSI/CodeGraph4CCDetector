package googlejam4.p048;


import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Pegman {
    
    public static void main(String[] args) throws Exception {
        File inputFile = new File("A-large.in");
        Scanner in = new Scanner(inputFile);
        File outputFile = new File("output.txt");
        PrintWriter out = new PrintWriter(outputFile);

        int T = in.nextInt();
        for (int t=0; t<T; t++) {
            int R = in.nextInt();
            int C = in.nextInt();
            char[][] A = new char[R][];
            for (int r=0; r<R; r++) {
                A[r] = in.next().toCharArray();
            }
            boolean ok = true;
            int answer = 0;
            for (int r=0; r<R; r++) {
                for (int c=0; c<C; c++) {
                    if (A[r][c] == '.') continue;
                    boolean up = false;
                    for (int rr=r-1; rr>=0; rr--) {
                        if (A[rr][c] != '.') {
                            up = true;
                        }
                    }
                    boolean down = false;
                    for (int rr=r+1; rr<R; rr++) {
                        if (A[rr][c] != '.') {
                            down = true;
                        }
                    }
                    boolean left = false;
                    for (int cc=c-1; cc>=0; cc--) {
                        if (A[r][cc] != '.') {
                            left = true;
                        }
                    }
                    boolean right = false;
                    for (int cc=c+1; cc<C; cc++) {
                        if (A[r][cc] != '.') {
                            right = true;
                        }
                    }
                    boolean exists = up || down || left || right;
                    if (exists) {
                        if ((A[r][c] == '^' && !up) || (A[r][c] == 'v' && !down)
                                || (A[r][c] == '>' && !right) || (A[r][c] == '<' && !left)) {
                            answer++;
                        }
                    } else {
                        ok = false;
                    }
                }
            }
            
            String s = ok ? Integer.toString(answer) : "IMPOSSIBLE";
            out.println("Case #"+(t+1)+": " + s);
        }

        out.close();
    }
    
}
