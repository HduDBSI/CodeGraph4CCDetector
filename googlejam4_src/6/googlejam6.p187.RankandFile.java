package googlejam6.p187;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RankandFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader("smallB.in"));
        PrintStream out = new PrintStream(new FileOutputStream("B.out"));
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            HashMap<Integer,Integer> counts = new HashMap<>();
            for (int i = 1; i < 2 * N; i++) {
                for (int i1 = 0; i1 < N; i1++) {
                    int n = scanner.nextInt();
                    int c = counts.getOrDefault(n, 0);
                    counts.put(n, c+1);
                }
            }
            out.println("Case #" + t + ": " + counts.entrySet().stream().filter(e -> e.getValue()%2 == 1).mapToInt(Map.Entry::getKey).sorted().boxed().map(String::valueOf).collect(
                    Collectors.joining(" ")));
        }
    }
}
