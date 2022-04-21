package googlejam1.p519;
import java.io.PrintStream;
import java.util.Scanner;

public class A {

    Scanner             sc       = new Scanner(getClass().getResourceAsStream(IN));
    static final String FILENAME = "A-large";
    static final String IN       = FILENAME + ".in";
    static final String OUT      = FILENAME + ".out";
    PrintStream         out      = System.out;

    public static void main(String args[]) throws Exception {
        A r = new A();
		int t = r.sc.nextInt();
		for (int i = 1; i <= t; i++) {
		    r.out.print("Case #" + i + ": ");
		    int ans1 = 0, ans2 = 0;
			int n = r.sc.nextInt();
			int[] arr = new int[n];
			int maxDistance = 0;
			for(int i1 = 0; i1 < arr.length; i1++) {
			    arr[i1] = r.sc.nextInt();
			}
			
			for(int i2 = 1; i2 < arr.length; i2++){
			    if (arr[i2-1] > arr[i2])
			    {
			        int distance = arr[i2-1] - arr[i2];
			
			        ans1 += distance;
			        if (distance > maxDistance) maxDistance = distance;
			    }
			}
			
			for (int i3 = 0; i3 < arr.length-1; i3++){
			    ans2 += arr[i3] < maxDistance ? arr[i3] : maxDistance;
			}
			
			//ans2 = maxDistance * (arr.length - 1);
			
			r.out.println(ans1+" "+ans2);
		}
		r.sc.close();
		r.out.close();
    }
}