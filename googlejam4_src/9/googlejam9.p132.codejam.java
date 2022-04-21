package googlejam9.p132;
import java.io.*;

import java.util.*;

public class codejam {

    static String i0 = "dummy.in";
    static String o0 = "dummy.out";

    static String i1 = "small.in";
    static String o1 = "small.out";

    static String i2 = "large.in";
    static String o2 = "large.out";

    public static void main(String[] args) throws Exception {

        Scanner r = null;
        FileWriter w = null;

        r = new Scanner(new FileReader(i0));
        w = new FileWriter(new File(o0));

        int t = r.nextInt();
        //r.nextLine();
        
        for (int i=0;i<t;i++){
            w.write("Case #"+(i+1)+": ");
            int b = r.nextInt();
            long m = r.nextLong();
            if (m > (long)Math.pow(2, b-2)){
                w.write("IMPOSSIBLE\n");
                continue;
            } else {
                w.write("POSSIBLE\n");
                String s = Long.toBinaryString(m-1);
                int len = s.length();
                w.write("0");
                if (s.length() < b-2){
                    for(int j=0;j<b-2-len;j++){
                        s = "0"+s;
                    }
                }
                if (b != 2){
                    w.write(s);
                }
                w.write("1\n");
                for(int j=1;j<b;j++){
                    for (int k=0;k<=j;k++){
                        w.write("0");
                    }
                    for (int k=j+1;k<b;k++){
                        w.write("1");
                    }
                    w.write("\n");
                }
            }
            //w.write("\n");
        }
        w.close();
    }
}
