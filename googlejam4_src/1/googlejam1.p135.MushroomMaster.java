package googlejam1.p135;


import java.io.File;
import java.util.Scanner;

public class MushroomMaster {

    private int n;
    private long m[];

    public MushroomMaster(Scanner sr) {
        n = sr.nextInt();
        m = new long[n];
        for (int i = 0; i < n; ++i) {
            m[i] = sr.nextInt();
        }
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("src/p1/input2.txt"));
            long cases = Integer.valueOf(sc.nextLine());
            for (long c = 0; c < cases; c++) {
                System.out.print("Case #" + (c + 1) + ": ");
				MushroomMaster r = new MushroomMaster(sc);
				long ans[] = new long[2];
				long maxDiff = 0;
				ans[0] = 0;
				for (int i = 1; i < r.m.length; ++i) {
				    if (r.m[i] < r.m[i - 1]) {
				        ans[0] += r.m[i - 1] - r.m[i];
				        maxDiff = (maxDiff < r.m[i - 1] - r.m[i]) ? r.m[i - 1] - r.m[i] : maxDiff;
				    }
				}
				ans[1] = 0;
				for (int i = 0; i < r.m.length - 1; ++i) {
				    ans[1] += (maxDiff > r.m[i]) ? r.m[i] : maxDiff;
				}
				System.out.println(ans[0] + " " + ans[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}