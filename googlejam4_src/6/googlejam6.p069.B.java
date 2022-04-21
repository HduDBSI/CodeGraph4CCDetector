package googlejam6.p069;


import com.google.common.base.Joiner;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class B {
    private static final String INPUT = "B-large.in";
    private static final String OUTPUT = "B-large.out";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File(INPUT));
        StringBuilder sb = new StringBuilder();
        int cases = sc.nextInt();
        for (int c = 0; c < cases; c++) {
            int n = sc.nextInt();
            int[][] lists = new int[2 * n - 1][n];
            for (int i = 0; i < 2 * n - 1; i++) {
                for (int j = 0; j < n; j++) {
                    lists[i][j] = sc.nextInt();
                }
            }
            String line = "Case #" + (c + 1) + ": " + solve(lists);
            sb.append(line).append('\n');
            System.out.println(line);
        }
        Files.write(Paths.get(OUTPUT), sb.toString().getBytes());
    }

    private static String solve(int[][] lists) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] list : lists) {
            for (int i : list) {
                int count = map.getOrDefault(i, 0);
                map.put(i, count + 1);
            }
        }

        List<Integer> list = map.keySet().stream().filter(k -> map.get(k) % 2 == 1).sorted().collect(toList());

        return Joiner.on(' ').join(list);
    }
}