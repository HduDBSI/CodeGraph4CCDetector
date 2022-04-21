package googlejam2.p314;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class A {
    Scanner input;
    PrintWriter output;
    public static int MAXIMUM = 1000000;

    private static int[] lookup = new int[MAXIMUM + 1];

    public A(Scanner input, PrintWriter output){
        this.input = input;
        this.output = output;
    }

    public static void main(String[] args){
        final long startTime = System.currentTimeMillis();
        File file = new File("A.in");
        Scanner input = null;
        try {
            input = new Scanner(file).useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintWriter output = null;
        lookup[1] = 1;
        for(int i = 1; i < MAXIMUM; i++){
            lookup[i + 1] = lookup[i + 1] == 0 ? lookup[i] + 1 : Math.min(lookup[i + 1], lookup[i] + 1);
			int flipped = Integer.parseInt(new StringBuilder(((Integer) i).toString()).reverse().toString());
			if(flipped > i){
			    if(flipped <= MAXIMUM)
			    lookup[flipped] = lookup[flipped] == 0 ? lookup[i] + 1 : Math.min(lookup[flipped], lookup[i] + 1);
			} else if(lookup[flipped] > lookup[i] + 1) {
			    System.out.println("we have to recalculate the past!");
			}
        }
        try {
            output = new PrintWriter("A.out", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        int problems = input.nextInt();
        for(int i = 1; i <= problems; i++){
            A r = new A(input, output);
			int number = r.input.nextInt();
			r.output.println("Case #" + i + ": " + A.lookup[number]);
        }
        output.close();
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + " ms");
    }
}
