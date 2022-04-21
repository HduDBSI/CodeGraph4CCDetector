package googlejam3.p380;
import java.io.*;

/**
 * Created by Tridip on 10-05-2015.
 */
public class Problem1C_A {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("A-large.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("A-large-output1.txt"));

        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {

            String input = br.readLine();
            String arr[] = input.split(" ");
            int r = Integer.parseInt(arr[0]);
            int c = Integer.parseInt(arr[1]);
            int w = Integer.parseInt(arr[2]);

            int count = 0;

            if (w == 1)
                count = r*c;
            else if ( w == c )
                count = w + (r-1);
            else if (c%w == 0)
                count = ((r-1)*(c/w))+((c/w) + (w-1));
            else {
                count = ((r-1)*(c/w))+((c/w) + (w-1) + 1);
            }

            bw.write("Case #" + t +": "+count+"\r\n");
        }
        bw.close();
        br.close();
    }
}