package googlejam3.p409;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Z1_1 {

    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("C:\\output.txt");
        BufferedWriter out = new BufferedWriter(fw);
        //String pathname = "C:\\Users\\YC14rp1\\Downloads\\z1.txt";
        String pathname = "C:\\Users\\YC14rp1\\Downloads\\A-small-attempt0.in";
        //String pathname = "C:\\Users\\YC14rp1\\Downloads\\D-large.in";
        Scanner scanner = new Scanner(new File(pathname));
        int tn = scanner.nextInt();
        scanner.nextLine();
        for (int ti = 1; ti <= tn; ti++) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int w = scanner.nextInt();
            int start  = w;
            int cnt = 1;
            while (start<c-w) {
                cnt++;
                start += w;
            }
            cnt += w;
            if (w==c) {
                cnt = w;
            }
            String s;
            if (cnt==Integer.MAX_VALUE) {
                s = "Case #" + ti + ": NOT POSSIBLE";
            } else {
                s = "Case #" + ti + ": "+cnt;
            }
            System.out.println(s);
            out.write(s);
            out.write("\n");
        }
        out.close();
    }

}
