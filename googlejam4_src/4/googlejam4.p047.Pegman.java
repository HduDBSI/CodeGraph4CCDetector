package googlejam4.p047;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Pegman {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("A-large.in"));
        PrintWriter out = new PrintWriter(new File("Pegman.out"));
//        Scanner in = new Scanner(System.in);
//        PrintWriter out = new PrintWriter(System.out);

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        String lookup = ">v<^";
        int loops = in.nextInt();
        for (int loop = 0; loop < loops; loop++) {
            int r = in.nextInt();
            int c = in.nextInt();
            in.nextLine();

            char[][] arr = new char[r][];
            for (int i = 0; i < r; i++) {
                arr[i] = in.nextLine().toCharArray();
            }
            int ans = 0;
            big: for (int i = 0; i < r; i++) {
                out: for (int j = 0; j < c; j++) {
                    if (arr[i][j] != '.') {
                        int d = lookup.indexOf(arr[i][j]);
                        int a = i + dr[d];
                        int b = j + dc[d];
                        while(a >= 0 && b >= 0 && a < r && b < c) {
                            if(arr[a][b] != '.')
                                continue out;
                            a += dr[d];
                            b += dc[d];
                        }
                        ans++;
                        for (d = 0; d < 4; d++) {
                            a = i + dr[d];
                            b = j + dc[d];
                            while(a >= 0 && b >= 0 && a < r && b < c) {
                                if(arr[a][b] != '.')
                                    continue out;
                                a += dr[d];
                                b += dc[d];
                            }
                        }
                        ans = -1;
                        break big;
                    }
                }
            }


            out.printf("Case #%d: %s%n", loop + 1, ans >= 0 ? ans : "IMPOSSIBLE");
        }


        out.close();
        in.close();
    }
}
