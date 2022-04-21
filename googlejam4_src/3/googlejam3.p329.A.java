package googlejam3.p329;
import java.io.*;
import java.util.*;

public class A {
    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br=new BufferedReader(new FileReader("A-large.in"));
        PrintWriter pw = new PrintWriter("Aout.txt");
        int n = Integer.parseInt(br.readLine());
        String line;

        for (int q = 1; q <= n; q++) {
            line = br.readLine();
            Scanner sc = new Scanner(line);
            int R = sc.nextInt();
            int C = sc.nextInt();
            int W = sc.nextInt();
            int ans = (C / W) * R + (C % W == 0 ? 0 : 1) + W - 1;
            System.out.println("Case #" + q + ": " + ans);
            pw.println("Case #" + q + ": " + ans);
        }
        pw.close();
    }
}