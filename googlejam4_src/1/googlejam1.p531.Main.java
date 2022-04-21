package googlejam1.p531;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream("A-large.in")));
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("A-large.out")));
            int testCount = Integer.parseInt(in.readLine());
            for (int t = 1; t <= testCount; t++) {
                in.readLine();
                String[] v = in.readLine().split(" ");
                long[] mushrooms = new long[v.length];
                for (int i = 0; i < v.length; i++) {
                    mushrooms[i] = Long.parseLong(v[i]);
                }
                long first = 0;
                for (int i = 0; i < mushrooms.length - 1; i++) {
                    if (mushrooms[i] > mushrooms[i + 1]) {
                        first += mushrooms[i] - mushrooms[i + 1];
                    }
                }
                long speed = 0;
                for (int i = 0; i < mushrooms.length - 1; i++) {
                    if (mushrooms[i + 1] < mushrooms[i]) {
                        speed = Math.max(speed, (mushrooms[i] - mushrooms[i + 1]));
                    }
                }
                long second = 0;
                if (speed != 0) {
                    for (int i = 1; i < mushrooms.length; i++) {
                        second += Math.min(mushrooms[i - 1], speed);
                    }
                }
                out.write("Case #" + t + ": " + first + " " + second);
                out.newLine();
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ignored) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ignored) {
                }
            }
        }
    }
}
