package googlejam6.p532;


import java.util.Arrays;
import java.util.Scanner;

public class RankAndFile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int N = sc.nextInt();
            int[] count = new int[2501];
            int[] arr = new int[N];
            for (int j = 0; j < 2 * N - 1; j++) {
                for (int k = 0; k < N; k++) {
                    count[sc.nextInt()]++;
                }
            }
            int initial = -1;
            int s = 0;
            for (int j = 0; j < 2501; j++) {
                if (count[j] % 2 == 1) {
                    arr[s++] = j;
                    if (s == N) {
                        break;
                    }
                }
            }
            Arrays.sort(arr);
            System.out.print("Case #"+(i+1)+":");
            for(int j=0;j<N;j++){
                System.out.print(" "+arr[j]);
            }
            System.out.println("");
        }

    }

}
