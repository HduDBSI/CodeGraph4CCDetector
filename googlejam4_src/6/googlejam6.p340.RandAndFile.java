package googlejam6.p340;


import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by popcorny on 4/16/16.
 */
public class RandAndFile {

    private final int[][] lists;
    private final int n;

    public RandAndFile(int n, int[][] lists) {
        this.lists = lists;
        this.n = n;
    }


    public static void main(String[] args) throws Exception {
        Scanner scanner;
        PrintWriter writer;
        String quizname = "randandfile";
        String testname = "large";
        String input   = String.format("quiz/%s/%s.in", quizname, testname);
        String output  = String.format("quiz/%s/%s.out", quizname, testname);

        if (new File(input).exists()) {
            scanner = new Scanner(new File(input));
            if (testname.equals("sample")) {
                writer = new PrintWriter(System.out);
            } else {
                writer = new PrintWriter(output);
            }
        } else {
            scanner = new Scanner(System.in);
            writer = new PrintWriter(System.out);
        }


        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();

            int[][] lists = new int[2*n-1][n];
            for (int j=0; j<2*n-1; j++) {

                for (int k=0; k<n; k++) {
                    int h = scanner.nextInt();
                    lists[j][k] = h;
                }
            }
			RandAndFile r = new RandAndFile(n, lists);
			HashMap<Integer, Integer> map = new HashMap<>();
			
			for (int i1=0; i1<r.lists.length; i1++) {
			    for (int j=0; j<r.n; j++) {
			        int h = r.lists[i1][j];
			        if (map.containsKey(h)) {
			            map.put(h, map.get(h) + 1);
			        } else {
			            map.put(h, 1);
			        }
			    }
			}
			
			int[] result = new int[r.n];
			int top=0;
			for (int key: map.keySet()) {
			    if (map.get(key) % 2 == 1) {
			        result[top++] = key;
			    }
			}
			
			Arrays.sort(result);

            int[] list = result;
            writer.printf("Case #%d: ", i + 1);
            for(int l=0;l<n;l++) {
                writer.printf("%d ", list[l]);
            }
            writer.println();
        }
        writer.flush();
    }
}
