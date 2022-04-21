package googlejam3.p291;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mafulafunk on 13.03.15.
 */
public class Brattleship {
    private static int cases;

    public static void main(String[] args) throws IOException {
        File in = new File("/Users/mafulafunk/Downloads/A-large.in");
//        File in = new File("/Users/mafulafunk/Code/jam/StoreCredit/src/main/resources/Brattleship.in");
        PrintWriter out = new PrintWriter("output.txt");
        BufferedReader br = new BufferedReader(new FileReader(in));
        cases = Integer.valueOf(br.readLine());
        for (int i = 1; i <= cases; i++) {


            String[] strArray = br.readLine().split(" ");
			long[] out1 = new long[strArray.length];
			for (int i1 = 0; i1 < strArray.length; i1++) {
			    out1[i1] = Integer.parseInt(strArray[i1]);
			}
			long[] line = out1;

            long rows = line[0];
            long cols = line[1];
            long sizeOfShip = line[2];

            long perLine = cols / sizeOfShip;

            long sinkTheShip = cols % sizeOfShip == 0 ? sizeOfShip -1 : sizeOfShip;

            out.println("Case #" + i + ": " + (rows * perLine + sinkTheShip));
        }
        out.flush();
        out.close();
    }

}
