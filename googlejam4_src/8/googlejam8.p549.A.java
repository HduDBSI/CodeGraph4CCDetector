package googlejam8.p549;
import java.io.*;
import java.util.Scanner;

/**
 * Created by juanma on 08/05/16.
 */
public class A {


    private static final boolean TEST = false;
    private static final String DOWNLOADS = "/Users/juanma/Downloads/";
    private static final String FILE = "A-large";

    public static void main(String[] args) {

        Scanner in = null;
        PrintStream out = null;

        if (TEST) {
            in = new Scanner(System.in);
            out = System.out;
        } else {
            try {
                in = new Scanner(new File(DOWNLOADS + FILE + ".in"));
                out = new PrintStream(new BufferedOutputStream(new FileOutputStream(DOWNLOADS + FILE + ".out")), true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

        int t = in.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = in.nextInt();
            int[] p = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                p[i]=in.nextInt();
                sum=sum+p[i];
            }

            StringBuilder sb = new StringBuilder();
            int exit = 0;
            while (sum>0) {
                int max = 0;
				int maxP1 = -1;
				for (int i = 0; i < p.length; i++) {
				    if (p[i]>max) {
				        max = p[i];
				        maxP1=i;
				    }
				}
				int maxP = maxP1;
                p[maxP]--;
                sum--;
                sb.append((char) (maxP+(int)'A'));
                exit++;
                if (exit==2 || sum ==2){
                    exit = 0;
                    sb.append(' ');
                }

            }
            out.println(String.format("Case #%d: %s",tc,sb.toString()));


        }

        in.close();
        out.close();
        System.exit(0);
    }
}
