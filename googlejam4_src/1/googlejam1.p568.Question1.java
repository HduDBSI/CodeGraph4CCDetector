package googlejam1.p568;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Question1 {
	static Scanner s;

	public static void main(String args[]) {
		try {
			System.setIn(new FileInputStream("C:\\Users\\Karthik\\Desktop\\"
				+ "file1.in"));
			System.setOut(new PrintStream(
				"C:\\Users\\Karthik\\Desktop\\out1.txt"));
		} catch (Exception e) {
			System.out.println("ERROR READING FILE");
		} // Must be in desktop
		s = new Scanner(System.in);
		int test_cases;
		test_cases = s.nextInt();
		int[] ar;
		for (int looper = 1; looper <= test_cases; looper++) {
			int n;
			n=s.nextInt();
			ar=new int[n];
			for(int j=0;j<n;j++)
				ar[j]=s.nextInt();
			int n1=ar.length;
			int diff=0;
			for(int i1=0;i1<n1-1;i1++)
			{
				if(ar[i1]>ar[i1+1])diff=diff+(ar[i1]-ar[i1+1]);
			}
			int value1=diff;
			int n3=ar.length;
			int max1=ar[0];
			for(int i3=1;i3<n3;i3++)if(ar[i3]>max1)max1=ar[i3];
			int max=max1;
			int n2=ar.length;
			int minval=n2*max;
			int maxdiff=0;
			for(int i2=0;i2<n2-1;i2++)
			{
				if(ar[i2]-ar[i2+1]>maxdiff)maxdiff=ar[i2]-ar[i2+1];
			}
			int curval=0;
			for(int i1=0;i1<n2-1;i1++)
			{
				if(ar[i1]>maxdiff)curval=curval+maxdiff;
				else curval=curval+ar[i1];
			}
			int value2=curval;
			// DO STUFF
			// Output will be in output
			int output = 0;
			// Waste a line if reading string after int/double
			int i=10000*1000;
			System.out.println("Case #" + looper + ": " + value1+" "+value2);
		}
	}
}
