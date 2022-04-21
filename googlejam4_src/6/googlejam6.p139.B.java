package googlejam6.p139;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class B {

    Scanner scanner;


    public static void main(String[] args) throws FileNotFoundException {
        B r = new B();
		File input = new File("data/gcj/2016/r1a/B-large.in");
		r.scanner = new Scanner(input);
		
		File test = new File("data/gcj/2016/r1a/B.out");
		PrintStream out = new PrintStream(new FileOutputStream(test));
		System.setOut(out);
		
		int testCase = r.scanner.nextInt();
		r.scanner.nextLine();
		
		for (int i = 1; i <= testCase; i++) {
		    System.out.printf("Case #%d:", i);
		    int[] count = new int[3000];
			int n = r.scanner.nextInt();
			for (int i2 = 0; i2 < n * (n + n - 1); i2++) {
			    int a = r.scanner.nextInt();
			    count[a]++;
			}
			for (int i1 = 0; i1 < count.length; i1++) {
			    if (count[i1] % 2 == 1) {
			        System.out.print(" " + i1);
			    }
			}
			System.out.println();
		}
    }

}
