package googlejam3.p127;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * User: RK
 */
public class A {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("test_codejam/a.in"));
        PrintWriter out = new PrintWriter(new FileOutputStream("test_codejam/a.out"));
//        Scanner in = new Scanner(System.in);
//        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        int test = 1;
        while (t-->0) {
            int r,c, w, answer = 0;
            r = in.nextInt();
            c = in.nextInt();
            w = in.nextInt();
            int z = 0;
            while (z<c) {
                z+=w;
                answer+=1;
            }

            out.println("Case #" + test + ": " + (answer * r + w - 1));
            test++;
        }
        out.close();
    }

}
