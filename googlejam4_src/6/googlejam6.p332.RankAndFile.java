package googlejam6.p332;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class RankAndFile {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int T = Integer.parseInt(in.nextLine());

    for (int i = 1; i <= T; i++) {
      Set<Integer> odd = new HashSet<>();
      int N = Integer.parseInt(in.nextLine());
      for (int j = 0; j < 2 * N - 1; j++) {
        for (int k = 0; k < N; k++) {
          int x = in.nextInt();
          if (odd.contains(x)) {
            odd.remove(x);
          } else {
            odd.add(x);
          }
        }

        in.nextLine();
      }

      StringBuilder sb = new StringBuilder();
      for (int x : odd.stream().sorted().collect(Collectors.toList())) {
        sb.append(x);
        sb.append(" ");
      }

      sb.deleteCharAt(sb.length() - 1);
      System.out.printf("Case #%d: %s%n", i, sb.toString());
    }

    in.close();
  }
}
