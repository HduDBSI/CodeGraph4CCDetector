package googlejam2.p293;
import java.util.*;
import java.io.*;

public class CodeJamCounter{
    public static int[] count;

    public static void main(String[] args) throws Exception{
        count = new int[1000001];
        count[1] = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());
        for(int i = 1; i < 1000000; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            int rev = Integer.parseInt(sb.reverse().toString());
            if(count[i+1] == 0) count[i+1] = count[i] + 1;
            else if(count[i] + 1 < count[i+1]) count[i+1] = count[i] + 1;
            if(count[rev] == 0) count[rev] = count[i] + 1;
            else if(count[i] + 1 < count[rev]) count[rev] = count[i] + 1;
        }
        for(int k = 1; k <= t; k++){
            int n = Integer.parseInt(br.readLine().trim());
            out.append("Case #" + k + ": " + count[n] + "\n");
        }
        System.out.print(out);
    }
}