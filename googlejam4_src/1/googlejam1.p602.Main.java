package googlejam1.p602;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class Main {


	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new File("A-large.in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
		
		PrintWriter out = null;
		try {
			out = new PrintWriter("out.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
		
		int nTests = in.nextInt();
		
		for(int testsCount = 0;testsCount<nTests;++testsCount) {			
			int n = in.nextInt();

			int m1=0,m2=0;
			int[] v = new int[1024];
			int maxd = -1;
			for(int i=0;i<n;i++) {
				v[i] = in.nextInt();
				
				if (i>0) {
					int d = v[i-1]-v[i];
					if (v[i-1]>v[i]) {
						m1+=d;
					}
					if (d > maxd) {
						maxd = d;
					}
				}
				
			}
			for(int i=0;i<n-1;i++) {
				if (v[i]<maxd) {
					m2+=v[i];
				}
				else {
					m2+=maxd;
				}
			}
			out.println("Case #" + (testsCount + 1) + ": " + m1 + " " + m2);
		}
		
		out.close();
	}

}
