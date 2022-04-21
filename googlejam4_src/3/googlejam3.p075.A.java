package googlejam3.p075;
import java.io.*;
import java.util.Scanner;

/**
 * Created by benoi_000 on 4/16/2015.
 */
public class A {

    public static void main(String args[]) throws FileNotFoundException {
        final String defaultFile = A.class.getName()+".in";
        final PrintStream out;
        final InputStream in;
        if (args.length==0) {
            in = new FileInputStream("test/"+defaultFile);
            out =System.out;

        } else {
            in = new FileInputStream("resources/"+args[0]);
            out = new PrintStream(new FileOutputStream("result/"+args[0]));
        }
        Scanner scanner = new Scanner(in);
        int nbTest = scanner.nextInt();
        for (int i=0;i<nbTest;i++) {
            scanner.nextLine();
			Long W = scanner.nextLong();
            Object res = ((long)Math.ceil((double)scanner.nextLong()/(double)W))+(W-1);
            out.println("Case #"+(i+1)+": "+res);
        }

    }


}
