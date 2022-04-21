package googlejam6.p601;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class A2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int z = 1; z <= t; ++z) {
            int N = in.nextInt();
            int[][] arr = new int[N][N];
            List<int[]> separate = new ArrayList<>();
            List<int[]> rows = new ArrayList<>();
            List<int[]> cols = new ArrayList<>();

            HashMap<Integer, Integer> all = new HashMap<>();
            for (int i = 0; i < 2*N - 1; i++) {
                for (int j = 0; j < N; j++) {
                    int n = in.nextInt();
                    if (all.containsKey(n)) {
                        all.put(n, all.get(n) + 1);
                    } else {
                        all.put(n, 1);
                    }
                }
            }
            List<Integer> missing = new ArrayList<>();


            for (int n : all.keySet()) {
                if (all.get(n) % 2 != 0) {
                    missing.add(n);
                }
            }
            Collections.sort(missing);
//            List<Integer> fsts = new ArrayList<>();
//            for (int i = 0; i < 2*N - 1; i++) {
//                int[] temp = new int[N];
//                for (int j = 0; j < N; j++) {
//                    temp[j] = in.nextInt();
//                }
//                separate.add(temp);
//                fsts.add(temp[0]);
//            }
//
//            int fst = fsts.indexOf(Collections.min(fsts));
//            int[] fstrow = separate.get(fst);
//            rows.add(fstrow);
//
//            separate.remove(fst);
//            fsts.remove(fst);
//            List<Integer> missing = new ArrayList<>();
//            int ind = -1;
//            boolean valid = false;
//            boolean rm = false;
//
//            for (int i = 0; i < fstrow.length; i++) {
//                if (fsts.contains(fstrow[i])) {
//                    int j = fsts.indexOf(fstrow[i]);
//                    cols.add(separate.get(j));
//                    separate.remove(j);
//                    fsts.remove(j);
//                } else {
//                    missing.add(fstrow[i]);
//                    ind = i;
//                }
//            }
//            if (ind != -1) {
//                for (int[] row : separate) {
//                    missing.add(row[ind]);
//                }
//            }
//
//            if (ind == -1) {
//                for (int[] row: separate) {
//                    rows.add(row);
//                }
//                int[] col = cols.get(0);
//                for (int i = 1; i < col.length; i++) {
//                    if (! fsts.contains(col[i])) {
//                        ind = i;
//                        break;
//                    }
//                }
//                System.out.println(cols.size());
//                for (int[] c : cols){
//                    missing.add(c[ind]);
//                }
//            }

            System.out.print("Case #" + z + ":" );
            for (int k : missing) {
                System.out.print(" " + k);
            }
            System.out.println();
        }
    }
}
