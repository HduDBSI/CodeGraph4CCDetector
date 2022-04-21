package googlejam1.p360;
import java.io.*;
import java.util.Scanner;

public class CodeJamR1A2015A {
    public static Scanner in;
    public static PrintWriter out;

    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner(new File("input.txt"));
        out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(
                new File("output.txt"))));
        int totalCases = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= totalCases; i++) {
			int n = in.nextInt();
			int oldM=0;
			int sum1=0;
			int sum2=0;
			int mostDiff=0;
			int[] a = new int[n];
			a[0] = in.nextInt();
			oldM=a[0];
			for (int i2=1; i2<n-1; i2++){
			    a[i2] = in.nextInt();
			    if (a[i2]<oldM) sum1+=(oldM-a[i2]);
			    if ((oldM-a[i2])>mostDiff) mostDiff=(oldM-a[i2]);
			    oldM=a[i2];
			}
			int m = in.nextInt();
			if (m<oldM) sum1 += (oldM - m);
			if ((oldM-m)>mostDiff) mostDiff=(oldM-m);
			for (int i1=0;i1<n-1;i1++){
			    if (a[i1]<mostDiff) sum2+=a[i1];
			    else sum2+=mostDiff;
			}
			out.println("Case #" + i + ": "+ sum1+" "+sum2);
		}
        out.close();
        System.err.println("Completed");
    }
}