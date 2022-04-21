package googlejam3.p349;


import java.io.*;
import java.util.*;

/**
 * @author Jun Yoon <junviolin@gmail.com>
 * @since 10-05-2015
 */
public class CodeJam2015Round1CA {

    public static void main(String[] args) throws Exception {
        String out = "";
        Scanner in = new Scanner(new FileReader("./A-large.in"));
        
        int numCases = in.nextInt();
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            out += "Case #" + caseNum + ": ";
            int r = in.nextInt(); // 1 for small dataset
            int c = in.nextInt();
            int w = in.nextInt();
            
            if (r == 1) {
                if (c == w || w == 1 || c - w == 1)
                    out += c + "\n";
                else {
                    int ans = c;
                    int count = 0;
                    while (ans >= 2 * w) {
                        ans -= w;
                        count++;
                    }
                    if (ans > w)
                        count++;
                    count += w;
                    out += count + "\n";
                }
            }
            else {
                if (c == w) {
                    int ans = c + (r - 1);
                    out += ans + "\n";
                }
                else if (c - w < w) {
                    int ans = w + 1 + (r - 1);
                    out += ans + "\n";
                }
                else if (w == 1) {
                    int ans = c * r;
                    out += ans + "\n";
                }
                else {
                    int ans = c;
                    int count = 0;
                    while (ans >= 2 * w) {
                        ans -= w;
                        count++;
                    }
                    count++;
                    count *= r;
                    if (ans == w)
                        count--;
                    count += w;
                    out += count + "\n";
                }
            }
        }
        
        in.close();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./A-large.out"))) {
            bw.write(out);
        }
    }
}
