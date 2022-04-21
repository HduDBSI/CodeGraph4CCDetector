package googlejam1.p468;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Mushroom {

    public static void main(String[] args) throws Exception {
        Mushroom m = new Mushroom();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(input.readLine());
            int[] p = new int[a];
            String[] ss = input.readLine().split("\\s");
            for (int j = 0; j < ss.length; j++) {
                p[j] = Integer.parseInt(ss[j]);
            }
			int[] r = new int[2];
			int a1 = 0;
			int b = 0;
			for (int i1 = 1; i1 < p.length; ++i1) {
			    if (p[i1 - 1] > p[i1]) {
			        a1 += p[i1 - 1] - p[i1];
			        b = Math.max(p[i1 - 1] - p[i1], b);
			    }
			}
			r[0] = a1;
			a1 = 0;
			for (int i2 = 1; i2 < p.length; ++i2) {
			    if (b < p[i2 - 1]) {
			        a1 += b;
			    } else {
			        a1 += p[i2 - 1];
			    }
			}
			r[1] = a1;
            int[] answer = r;
            System.out.println("Case #" + (i + 1) + ": " + answer[0] + " " + answer[1]);
        }
    }
}
