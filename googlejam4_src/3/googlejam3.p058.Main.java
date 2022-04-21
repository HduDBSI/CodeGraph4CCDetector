package googlejam3.p058;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        Main r = new Main();
		int nt = Integer.parseInt(r.br.readLine().trim());
		for(int t = 0; t < nt; t++) {
		    String[] nums = r.br.readLine().split(" ");
		    int r1 = Integer.parseInt(nums[0]);
		    int c = Integer.parseInt(nums[1]);
		    int w = Integer.parseInt(nums[2]);
		
		    int max = (c / w) * (r1 - 1);
		    max += ((c - 1) / w) + w;
		    System.out.println("Case #" + (t+1) + ": " + Integer.toString(max));
		}
    }
}




