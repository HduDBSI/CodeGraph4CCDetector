package googlejam6.p699;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by james on 16/04/16.
 */
public class rankandfile {
    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);

        int numCases = in.nextInt();
        for (int test = 1; test <= numCases; test++) {
            System.out.print("Case #" + test + ":");
            int n = in.nextInt();
			int[] numbers = new int[2501];
			Arrays.fill(numbers, 0);
			for(int i = 0; i < n; i++ ){
			    for(int j = 0; j < 2 * n -1; j ++){
			        numbers[in.nextInt()]++;
			    }
			}
			Set<Integer> solution = new TreeSet<>();
			for(int i =0; i < numbers.length; i++){
			    if(numbers[i] % 2 != 0){
			        solution.add(i );
			    }
			}
			for(Integer i : solution){
			    System.out.print(" " + i);
			}
			System.out.println();
        }

        System.exit(0);
    }
}
