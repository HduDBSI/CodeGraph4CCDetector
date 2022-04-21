package googlejam3.p454;
import java.io.*;
import java.text.MessageFormat;

public class A {
    public static String cc = "Case #{0}: {1}";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("A.in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("A.out"));
        int n = Integer.parseInt(reader.readLine().trim());
        for (int i = 0; i < n; i++) {
            int ans = 0;
            String[] strs = reader.readLine().trim().split(" +");
            int p1 = Integer.parseInt(strs[0]);
            int p2 = Integer.parseInt(strs[1]);
            int m = Integer.parseInt(strs[2]);

            ans += p1 * (p2 % m == 0 ? p2 /m : p2 /m+1);
            ans += m-1;
            writer.write(MessageFormat.format(cc, i + 1, ans));
            writer.newLine();
        }
        writer.close();
        reader.close();
    }
}

