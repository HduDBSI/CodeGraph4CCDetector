package googlejam1.p243;

import java.util.*;
import java.io.*;
public class shroom {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(new File("A-large.in"));
        FileWriter out = new FileWriter(new File("aOut.txt"));
        int numcases = in.nextInt();
        for(int casenum = 1; casenum  <= numcases; casenum++) {
            int numtimes = in.nextInt();
            int[] map =  new int[numtimes];
            for(int i = 0; i < numtimes; i++) {
                map[i] = in.nextInt();
            }
            int smallestRate = 0;
            //method 1
            int method1 = 0;
            for(int i = 1; i < map.length; i++) {
                if(map[i] < map[i - 1]) {
                    method1 += map[i - 1] - map[i];
                    smallestRate = Math.max(smallestRate, map[i-1] - map[i]);
                }
            }
            System.out.println("method1: "+method1);

            //method2
            int method2 = 0;
            double rate = smallestRate;
                for(int i = 0; i < map.length - 1; i++) {
                    method2 += Math.min(map[i], rate);
                }
            System.out.println("method2: "+method2);
            out.write("Case #"+casenum+": "+method1+" "+method2+"\n");
        }
        out.close();
    }
}
