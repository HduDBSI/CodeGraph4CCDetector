package googlejam3.p307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author DeViL JiN
 */
public class battleship {

    public static void main(String[] args) throws IOException {
        int ab;
		ab = Integer.parseInt(br.readLine().trim());
		int t = ab;
        int a[] = new int[3], n, r, c;
        for (int i = 1; i <= t; i++) {

            s = br.readLine().trim().split(" ");
			int i1;
			for (i1 = 0; i1 < 3; i1++) {
			    a[i1] = Integer.parseInt(s[i1]);
			}
            r = a[0];
            c = a[1];
            n = a[2];
            int ans=0;
           ans+=(r)*(c/n);
           int m=c%n; 
           ans+=n;
           if(m==0){
           ans-=1;
           }
           
           
            
            System.out.println("Case #" + i + ": " + ans);

        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(
            System.in));
    private static String s[], w, q;
}
