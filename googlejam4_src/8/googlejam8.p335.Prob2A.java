package googlejam8.p335;
import java.io.*;
import java.util.Scanner;

/**
 * Created by dinus on 4/30/2016.
 */
public class Prob2A {
    public static void main(String[] args) throws FileNotFoundException {
        if(args.length == 1 && args[0].equals("test"))
        {
            String path = "C:\\codejam\\";
//            String filename = "input.txt";
            String filename = "A-small-attempt0.in";
            System.setIn(new FileInputStream(new File(path + filename)));

            String outputName= filename.split("\\.")[0] + ".out";
            System.setOut(new PrintStream(new File(path + outputName)));
        }


        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int test = 1; test <= tests; ++test) {
            StringBuilder result = new StringBuilder();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = in.nextInt();

            int max1 = 0;
            int pos1 = 0;
            int max2 = 0;
            int pos2 = 0;
            for(int i=0; i<n; i++)
            {
                if(arr[i] > max1)
                {
                    max2 = max1;
                    pos2 = pos1;
                    max1 = arr[i];
                    pos1 = i;
                } else if(arr[i] > max2)
                {
                    max2 = arr[i];
                    pos2 = i;
                }
            }

//            System.err.println("max1: " + max1);
//            System.err.println("max2: " + max2);
            while(max1 > max2)
            {
                result.append((char)('A' + pos1) + " ");
                max1--;
            }
            while(max2 > max1)
            {
                result.append((char)('A' + pos2) + " ");
                max2--;
            }
            for(int i=0; i<n; i++)
            {
                if(i == pos1 || i == pos2)
                    continue;
                while(arr[i] > 0)
                {
                    result.append((char)('A' + i) + " ");
                    arr[i]--;
                }
            }
            String finalString = "" + (char)('A'+pos1) + (char)('A'+pos2) + " ";
            for(int i=0; i<max1; i++)
                result.append(finalString);



            System.out.println("Case #" + test + ": " + result);
        }


    }
}
