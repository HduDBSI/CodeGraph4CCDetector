package googlejam3.p132;
import java.io.*;
import java.util.Scanner;

public class Main {
    private static StreamTokenizer in;
    private static Scanner ins;
    private static PrintWriter out;

    public static void main(String[] args) {

        try {
            in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            ins = new Scanner(System.in);
            out = new PrintWriter(System.out);
            try {
                if (System.getProperty("xDx") != null) {
                    in = new StreamTokenizer(new BufferedReader(new FileReader("input.txt")));
                    ins = new Scanner(new FileReader("input.txt"));
                    out = new PrintWriter(new FileWriter("output.txt"));
                }
            } catch (Exception e) {
                in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
                ins = new Scanner(System.in);
                out = new PrintWriter(System.out);
            }
			Main r = new Main();
			Main.in.nextToken();
            int T = (int) Main.in.nval;
			for (int i = 0; i < T; i++) {
			    int r1 = r.nextInt(), c = r.nextInt(), w = r.nextInt();
			    int answ = (c / w) * r1;
			    answ += (c % w > 0 ? w : w - 1);
			    Main.out.printf("Case #%d: %d\n", i + 1, answ);
			}
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }


    private int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

}
