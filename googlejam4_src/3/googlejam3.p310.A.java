package googlejam3.p310;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class A {
	
	public static void main(String[] args) throws Exception {
		String filename = "A-large";
        Scanner scan = new Scanner(new FileReader(filename + ".in"));
        PrintWriter out = new PrintWriter(filename + ".out");
        int problems = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            System.out.print("Case #" + (count+1) + ": ");
            out.print("Case #" + (count+1) + ": ");
			A r = new A();
            int r1 = scan.nextInt();
			int c = scan.nextInt();
			int w = scan.nextInt();
			int result = r1*(c/w);
			if (c%w == 0) {
				result += w-1;
			} else {
				result += w;
			}
			System.out.println(result);
			out.println(result);
        }
        out.flush();
        out.close();
        scan.close();
    }
	
}