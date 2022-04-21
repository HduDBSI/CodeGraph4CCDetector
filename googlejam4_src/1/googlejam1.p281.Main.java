package googlejam1.p281;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @autor: julio
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("in.large")));
        int T = scanner.nextInt();
        for(int t=0;t<T;t++) {
            int N = scanner.nextInt();
            int[] n = new int[N];

            int C = 0;
            int eat = 0;
            int Bdelta = 0;
            for(int i=0;i<N;i++) {
                int C1 = scanner.nextInt();
                n[i] = C1;
                if(C1 < C) {
                    int delta = (C - C1);
                    eat += (C - C1);
                    if(delta > Bdelta) {
                        Bdelta = delta;
                    }

                }
                C = C1;
            }

            int eat2 = 0;
            int plate = 0;
            for(int i=0;i<N-1;i++) {
                plate = n[i];
                if(plate >= Bdelta) {
                    plate -= Bdelta;
                    eat2+=Bdelta;
                } else {
                    eat2 += plate;
                    plate = 0;
                }

            }

            System.out.println("Case #" + (t+1) + ": " + (eat) + " " + eat2);
        }
    }

}
