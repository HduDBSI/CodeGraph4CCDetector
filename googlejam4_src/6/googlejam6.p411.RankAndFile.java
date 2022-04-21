package googlejam6.p411;
import java.io.*;
import java.util.*;

/**
 * Created by Hojae Jung on 4/15/2016.
 */
public class RankAndFile {
    public static void main(String... args) throws Exception {
        Scanner scan = new Scanner(new File("B-large.in"));
        PrintWriter pout = new PrintWriter(new FileWriter(new File("output.txt")));
        int cases = Integer.parseInt(scan.nextLine());
        int n;
        short[] check;
        String[][] nums;
        String result;
        for(int bb = 0; bb < cases; bb++){
            result = "";
            check = new short[2500];
            n = Integer.parseInt(scan.nextLine());
            nums = new String[2*n-1][];
            for(int i=0; i<2*n-1; i++){
                nums[i] = scan.nextLine().trim().split(" ");
                for(int j=0; j<n; j++){
                    check[Integer.parseInt(nums[i][j])-1]++;
                }
            }
            for(int i=0; i<2500; i++){
                if(check[i]%2 == 1)
                    result += (i+1) + " ";
            }
            result = result.trim();
            if(result.length() > 2*n){
                System.out.println("error");
            }
            pout.println("Case #" + (bb+1) + ": " + result);
        }



        pout.close();
    }
}
