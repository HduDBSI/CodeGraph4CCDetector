package googlejam7.p104;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("/Users/ratmir/Downloads/B-small-attempt0 (2).in");
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(fileInputStream);
        FileOutputStream outputStream = new FileOutputStream("/Users/ratmir/Documents/code/hackerrank/algs/src/codejam/y2016/r2/z2/z2.txt");
        PrintWriter printWriter = new PrintWriter(outputStream);
//        for (int i=0;i<100000;i++) {
//            System.out.println(getM(i+1));
//        }
        int tn = sc.nextInt();
        sc.nextLine();
        for (int ti = 1; ti <= tn; ti++) {
            String s = sc.nextLine();
            String[] strings = s.split(" ");
            int mx = (int) Math.pow(10, strings[0].length());
            int v1 = -1;
            int v2 = -1;
            String x1 = "";
            String x2 = "";
            for (int n1=0;n1<mx;n1++) {
                for (int n2=0; n2<mx;n2++) {
                    String s1 = String.valueOf(mx+n1);
                    String s2 = String.valueOf(mx+n2);
                    boolean flag = true;
                    for (int i=0;i<strings[0].length();i++) {
                        if ((strings[0].charAt(i)=='?') || (strings[0].charAt(i)==s1.charAt(i+1))) {

                        } else {
                            flag = false;
                        }
                    }
                    for (int i=0;i<strings[1].length();i++) {
                        if ((strings[1].charAt(i)=='?') || (strings[1].charAt(i)==s2.charAt(i+1))) {

                        } else {
                            flag = false;
                        }
                    }
                    if (flag) {
                        int dv = Math.abs(v1-v2);
                        int dn = Math.abs(n1-n2);
                        boolean doit = v1==-1;
                        if (!doit && (dn<dv)) {
                            doit = true;
                        }
                        if (!doit && (dn==dv) && (n1<v1)) {
                            doit = true;
                        }
                        if (!doit && (dn==dv) && (n1==v1) && (n2<v2)) {
                            doit = true;
                        }
                        if (doit) {
                            v1 = n1;
                            v2 = n2;
                            x1 = s1.substring(1);
                            x2 = s2.substring(1);
                        }
                    }
                }
            }
            String res = "Case #" + ti + ": " + x1+" "+x2;
            printWriter.write(res + "\n");
            System.out.println(res);
        }
        printWriter.close();
    }

}
