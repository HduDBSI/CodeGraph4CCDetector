package googlejam6.p184;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        
        for (int i = 1; i <= numCases; i++) {
            int N = input.nextInt();
            HashSet<Integer> set = new HashSet<Integer>();
            for (int j = 0; j < 2 * N - 1; j++) {
                for (int k = 0; k < N; k++) {
                    int temp = input.nextInt();
                    if (set.contains(temp)) {
                        set.remove(temp);
                    } else {
                        set.add(temp);
                    }
                }
            }
            int[] remaining = new int[N];
            int index = 0;
            for (int num : set) {
                remaining[index++] = num;
            }
            Arrays.sort(remaining);
            System.out.print("Case #" + i + ": ");
            for (int k = 0; k < remaining.length; k++) {
                System.out.print(remaining[k]);
                if (k != remaining.length - 1) {
                    System.out.print(' ');
                } else {
                    System.out.println();
                }
            }
        }
        
        input.close();
    }
}
