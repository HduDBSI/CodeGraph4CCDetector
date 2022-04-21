package googlejam3.p314;
import java.util.*;
import java.io.*;

public class A {
 
    public static void main(String[] args) throws FileNotFoundException {
        A r = new A();
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("al.in"));
		PrintWriter out = new PrintWriter("al.out");
		int tt = Integer.parseInt(in.nextLine());
		for (int test = 1; test <= tt; test++) {
		    int r1 = in.nextInt();
		    int c = in.nextInt();
		    int w = in.nextInt();
		    int ans = c / w + (w - 1) + (c % w == 0 ? 0 : 1) + (r1 - 1) * (c / w); 
		    //System.out.println("Case #" + test + ": " + ans);
		    out.println("Case #" + test + ": " + ans);
		}
		
		out.close();
    }
}