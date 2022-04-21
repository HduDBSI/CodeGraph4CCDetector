package googlejam8.p787;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemA {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());

        for (long i = 1; i <= T; i++) {
            int N = Integer.parseInt(in.nextLine());
            int[] p = new int[N];
            for (int j = 0; j < N; j++) {
                p[j] = in.nextInt();
            }

            in.nextLine();
			StringBuilder sb = new StringBuilder();
			while (true) {
			    int[] sortedIndices = IntStream.range(0, p.length)
			            .boxed().sorted((i1, j) -> -Integer.compare(p[i1], p[j]))
			            .mapToInt(ele -> ele).toArray();
			
			    int ssum = IntStream.of(p).sum();
			    int first = p[sortedIndices[0]];
			    int second = p.length >= 2 ? p[sortedIndices[1]] : 0;
			    int third = p.length >= 3 ? p[sortedIndices[2]] : 0;
			
			    if (first == 0) {
			        break;
			    }
			
			    sb.append((char) ('A' + sortedIndices[0]));
			    p[sortedIndices[0]] = p[sortedIndices[0]] - 1;
			    if (first == second && (2 * third <= ssum - 2)) {
			        sb.append((char) ('A' + sortedIndices[1]));
			        p[sortedIndices[1]] = p[sortedIndices[1]] - 1;
			    }
			
			    if (IntStream.of(p).anyMatch(x -> x > 0)) {
			        sb.append(" ");
			    }
			
			    int max = 0, sum = 0;
			    for (int i2 = 0; i2 < p.length; i2++) {
			        sum += p[i2];
			        if (p[i2] > max) {
			            max = p[i2];
			        }
			    }
			
			    if (max * 2 > sum) {
			        throw new RuntimeException("fail");
			    }
			}

            String answer = sb.toString();

            System.out.printf("Case #%d: %s%n", i, answer);
        }

        in.close();
    }
}
