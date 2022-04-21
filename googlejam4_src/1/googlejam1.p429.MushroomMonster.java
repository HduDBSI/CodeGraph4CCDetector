package googlejam1.p429;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MushroomMonster {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        for (int i = 0; i < cases; i++) {
            in.readLine();
            String[] nums = in.readLine().split(" ");
            int[] ints = new int[nums.length];
            
            int sum1 = 0;
            int sum2 = 0;
            int maxdiff = 0;
            for (int j = 0; j < nums.length; j++) {
                ints[j] = Integer.parseInt(nums[j]);
                
                if (j > 0) {
                    if (ints[j - 1] > ints[j]) {
                        sum1 += ints[j - 1] - ints[j];
                    }
                    
                    maxdiff = Math.max(maxdiff, ints[j - 1] - ints[j]);
                }
            }
            for (int j = 0; j < nums.length - 1; j++) {
                if (ints[j] > maxdiff) {
                    sum2 += maxdiff;
                } else {
                    sum2 += ints[j];
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + sum1 + " " + sum2);
        }
        
    }
}
