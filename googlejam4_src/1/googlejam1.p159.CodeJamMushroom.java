package googlejam1.p159;
import java.util.*;
import java.io.*;

public class CodeJamMushroom{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] m = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = 0;
            int r = 0;
            for(int j = 0; j < n; j++){
                m[j] = Integer.parseInt(st.nextToken());
                if(j != 0 && m[j] < m[j-1]){
                    f += m[j-1] - m[j];
                    r = Math.max(r,m[j-1]-m[j]);
                }
            }
            int s = 0;
            for(int j = 0; j < n-1; j++){
                s += Math.min(r,m[j]);
            }
            out.append(String.format("Case #%d: %d %d\n",i,f,s));
        }
        System.out.print(out);
    }
}