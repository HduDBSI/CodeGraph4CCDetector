package googlejam3.p396;
import java.util.*;
import java.io.*;

public class CodeJamBrattleship{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int k = 1; k <= t; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = r*c/w;
            n += w;
            if(c % w == 0) n--;
            out.append("Case #" + k + ": " + n + "\n");
        }
        System.out.print(out);
    }
}