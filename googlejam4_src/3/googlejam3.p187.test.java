package googlejam3.p187;

import com.sun.media.sound.FFT;

import java.io.*;
import java.text.NumberFormat;
import java.util.*;

/**
 * Created by VIET ANH on 27/04/2015.
 */
public class test {

    private static int T;
    private static long oo=Long.MAX_VALUE;
    private static long base=1000000007;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new FileInputStream("test.txt"));
        PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"));
        int T=in.nextInt();
        for (int test = 0; test < T; test++) {
            int res=0;
            int r=in.nextInt();
            int c=in.nextInt();
            int w = in.nextInt();
            int resi;
            if (c%w==0) resi=c/w+w-1;
            else resi=c/w+w;
            int resno=c/w;
            res=resno*(r-1)+resi;
            out.println("Case #"+(test+1)+": "+res);
        }
        out.close();
    }

}
