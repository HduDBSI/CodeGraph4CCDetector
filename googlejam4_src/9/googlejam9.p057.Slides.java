package googlejam9.p057;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Slides {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
            int b = in.nextInt();
            long m = in.nextLong();
            long p = pow(2,b-2);
            if (p<m){
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
                if (p==m){
                    for (int j1=0; j1<b; ++j1){
                        String s = "";
                        for (int j2 = 0; j2<b; ++j2){
                            if (j2<=j1) s += "0";
                            else s += "1";
                        }
                        System.out.println(s);
                    }
                } else {
                    for (int j1=0; j1<b; ++j1){
                        String s = "";
                        for (int j2 = 0; j2<b-1; ++j2){
                            if (j2<=j1) s += "0";
                            else s += "1";
                        }
                        if (j1 == 0) s += "0";
                        else {
                            if (m%2==1) s += "1";
                            else s += "0";
                            m /= 2;
                        }
                        System.out.println(s);
                    }
                }
            }
        }
        in.close();
    }
    
    public static long pow(long a, long b){
        if (b==0) return 1;
        else if (b%2==0) return pow(a*a,b/2);
        else return a*pow(a*a,b/2);
    }
}