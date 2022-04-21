package googlejam3.p196;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class A {
	static Scanner sc;
	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(args.length > 0 ? new FileInputStream(args[0]) : System.in);
		int numCases = sc.nextInt();
		for (int nCase=1; nCase<=numCases; nCase++) {
			Object[] args1 = { nCase };
			System.out.printf("Case #%d: ", args1);
			int R = sc.nextInt();
			int C = sc.nextInt();
			int W = sc.nextInt();
			
			int perRow = (int)Math.floor((double)C / W);
			int extraHit = C % W > 0 ? W : W-1;
			Object[] args2 = { R * perRow + extraHit };
			System.out.printf("%d\n", args2);
		}
		sc.close();
	}

}