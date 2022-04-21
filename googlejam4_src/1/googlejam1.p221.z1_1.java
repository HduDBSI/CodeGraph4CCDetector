package googlejam1.p221;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by yc14rp1 on 4/17/2015.
 */
public class z1_1 {

    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("C:\\output.txt");
        BufferedWriter out = new BufferedWriter(fw);
        //String pathname = "C:\\Users\\YC14rp1\\Downloads\\z111.txt";
        //String pathname = "C:\\Users\\YC14rp1\\Downloads\\A-small-attempt0 (1).in";
        //String pathname = "C:\\Users\\YC14rp1\\Downloads\\A-generated.in";
        String pathname = "C:\\Users\\YC14rp1\\Downloads\\A-large (1).in";
        Scanner scanner = new Scanner(new File(pathname));
        int tn = scanner.nextInt();
        scanner.nextLine();
        for (int ti = 1; ti <= tn; ti++) {
            int n = scanner.nextInt();
			int[] l21 = new int[n];
			for (int i1=0;i1<n;i1++) {
			    l21[i1] = scanner.nextInt();
			}
            int[] l2 = l21;
            //String s1 = scanner.next();
            //String s2 = scanner.next();
            int s1 = 0;
            int mx = 0;
            for (int i=1;i<n;i++) {
                if (l2[i]<l2[i-1]) {
                    int delta = l2[i - 1] - l2[i];
                    s1 += delta;
                    if (delta>mx) {
                        mx = delta;
                    }
                }
            }
            int mx2 = 0;
            int cr=0;
            for (int i=1;i<n;i++) {
                cr = l2[i-1];
                if (l2[i-1]>mx) {
                    mx2+=mx;
                } else {
                    mx2 +=l2[i-1];
                }
            }
            String s;
            s = "Case #" + ti + ": "+s1+" "+mx2;
            System.out.println(s);
            out.write(s);
            out.write("\n");
        }
        out.close();
    }

}
