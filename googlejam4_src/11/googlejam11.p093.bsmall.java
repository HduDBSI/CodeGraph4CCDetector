package googlejam11.p093;

import java.util.*;

public class bsmall {
    
    public static void main(String[] args) {
        
        Scanner stdin = new Scanner(System.in);
        int numCases = stdin.nextInt();
        
        for (int loop=1; loop<=numCases; loop++) {
            
            int n = stdin.nextInt();
            int k = stdin.nextInt();
            double[] p = new double[n];
            for (int i=0; i<n; i++)
                p[i] = stdin.nextDouble();
            
            double res = 0;
            for (int i=1; i<(1<<n); i++) {        
                if (Integer.bitCount(i) != k) continue;

                double tmp = 0;
                for (int mask=i; mask>0; mask = ((mask-1)&i) ) {
                    
                    if (Integer.bitCount(mask) != k/2) continue;
                    
                    double thisP = 1;
                    for (int j=0; j<n; j++) {
                        if ((mask&(1<<j)) > 0)
                            thisP = thisP*p[j];
                        else if ((i&(1<<j)) > 0)
                            thisP = thisP*(1-p[j]);
                 
                    }
                    tmp += thisP;
                }
                res = Math.max(res, tmp);
            }
            
            System.out.printf("Case #%d: %.9f\n", loop, res);
        }
    }
}