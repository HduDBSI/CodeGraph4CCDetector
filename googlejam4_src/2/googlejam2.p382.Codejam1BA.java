package googlejam2.p382;
/*
 * @author Mr E
 */

import java.io.*;
import java.util.*;

public class Codejam1BA {

    public static void main(String[] args) throws FileNotFoundException {

//        Scanner s = new Scanner(System.in);
        PrintWriter writer = new PrintWriter("as.out");
        Scanner s = new Scanner(new File("as.in"));
        int arr[]=new int[10000001];
        for (int i = 1; i < 11; i++) {
            arr[i]=i;
        }
        String str = "";
        String str2 = "";
        StringBuilder sb;
        for (int i = 11; i < 10000001; i++) {
            str=i+"";
            sb = new StringBuilder(str);
            int ri = Integer.parseInt(sb.reverse().toString());
            str2 = ri + "";
            if(str.length()==str2.length() && ri<i){
                arr[i]=Math.min(arr[i-1], arr[ri])+1;
            }else{
                arr[i]=arr[i-1]+1;
            }
        }
        int testcase = s.nextInt();
        for (int i = 0; i < testcase; i++) {
            int n = s.nextInt();

//            long c = 1;
//            long x = 1;
//            String str = "";
//            String str2 = "";
//            StringBuilder sb;
//            while (1 != n) {
//                str = n + "";
//                sb = new StringBuilder(str);
//                long rn = Long.parseLong(sb.reverse().toString());
//                str2 = rn + "";
//                if (rn < n && rn > 1 && str.length() == str2.length()) {
//                    n = rn;
//                    c++;
//                } else {
//                    n--;
//                    c++;
//                }
//            }
//            System.out.println("Case #" + (i + 1) + ": " + arr[n]);
            writer.println("Case #" + (i + 1) + ": " + arr[n]);
        }
        writer.close();

    }

//    public static long min(long x) {
//        if (x == 1) {
//            return 1;
//        } else {
//            String str = x + "";
//            StringBuilder sb = new StringBuilder(str);
//            long rn = Long.parseLong(sb.reverse().toString());
//            String str2 = rn + "";
//            if (rn < n && rn > 1 && str.length() == str2.length()) 
//        }
//    }
}
