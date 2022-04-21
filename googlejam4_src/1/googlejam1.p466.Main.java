package googlejam1.p466;
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
            int t = (int) Main.in.nval;
			for (int k = 0; k < t; k++) {
			    Main.in.nextToken();
				int n = (int) Main.in.nval;
			    int y = 0;
			    int z = 0;
			    int speed = 0;
			    int[] a = new int[n];
			    for (int i = 0; i < n; i++) {
			        Main.in.nextToken();
					a[i] = (int) Main.in.nval;
			        if(i > 0) {
			            y += Math.max(a[i - 1] - a[i], 0);
			            speed = Math.max(speed, a[i - 1] - a[i]);
			        }
			    }
			
			    for (int i = 0; i < n - 1; i++) {
			        z += Math.min(a[i], speed);
			    }
			
			    Main.out.printf("Case #%d: %d %d\n", k + 1, y, z);
			}
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
