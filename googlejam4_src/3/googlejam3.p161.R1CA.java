package googlejam3.p161;
import java.io.IOException;

/**
 * Copyright - Arghya Sur
 * Created by sur on 5/10/15.
 */
public class R1CA {
    public static void main(String[] args) throws IOException {

        java.io.BufferedReader r = new java.io.BufferedReader
                (new java.io.InputStreamReader (System.in));

        String line;
        int c = 0;
        int t = Integer.parseInt(r.readLine());

        while(t > 0) {
            line = r.readLine();
            String[] components = line.split(" ");
            int R = Integer.parseInt(components[0]);
            int C = Integer.parseInt(components[1]);
            int W = Integer.parseInt(components[2]);

            int confirmedFirstHit = R * (C / W );
            int a = (C % W == 0) ? 0: 1;

            System.out.println("Case #" + (c + 1) + ": " + (confirmedFirstHit + W - 1 + a));
            t--;
            c++;
        }
    }
}
