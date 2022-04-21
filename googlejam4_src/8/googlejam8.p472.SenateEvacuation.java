package googlejam8.p472;


import java.util.*;

/**
 * <Class description...>
 * Harrison Fang, May 08, 2016.
 */
public class SenateEvacuation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            System.out.printf("case #%d:", t);

            int N = in.nextInt();
            int[] arr = new int[N];

            int sum = 0;

            for (int i = 0; i < N; i++) {
                int tmp = in.nextInt();
                arr[i] = tmp;
                sum += tmp;
            }

            StringBuilder sb = new StringBuilder();

            while (true) {
                int max = -1, maxi = -1;
                int sec = -2, seci = -2;
                int left = 0;
                for (int i = 0; i < N; i++) {
                    if (arr[i] > 0) left++;

                    if (arr[i] > max) {
                        sec = max; seci = maxi;
                        max = arr[i]; maxi = i;
                    } else if (arr[i] > sec) {
                        sec = arr[i]; seci = i;
                    }
                }

                char a = 'A'; a += maxi;
                char b = 'A'; b += seci;

                if (left == 2) {
                    while (max - sec > 1) {

                        sb.append(" ").append(a).append(a);
                        max = max - 2;
                    }
                    if (max != sec) {
                        sb.append(" ").append(a);
                        max = max - 1;
                    }
                    while (max != 0) {
                        sb.append(" ").append(a).append(b);
                        max = max - 1; sec = sec - 1;
                    }
                    break;
                } else {
                    sb.append(" ").append(a);
                    arr[maxi]--;
                }
            }

            System.out.println(sb.toString());
        }
    }
}
