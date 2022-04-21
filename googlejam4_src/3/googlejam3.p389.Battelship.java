package googlejam3.p389;
import java.io.*;
import java.util.*;

public class Battelship {

	public static void main(String[] args) throws Exception {
		String name = "A-large";
		String path = "";

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(new File(path + name + ".in"));
		PrintWriter pw = new PrintWriter(path + name + "ans.out");
//		Scanner sc = new Scanner(System.in);
//		PrintWriter pw = new PrintWriter(System.out);

		int testCases = sc.nextInt();
		for (int testCase = 1; testCase <= testCases; testCase++) {
			int res=0;
			int fres=0;
			int r = sc.nextInt();
			int c = sc.nextInt();
			int w = sc.nextInt();
			
			if(c/w<2 && c%w!=0)
				res=w+1;
			else
			{	if(c/w==1)
					res=w;
				else
			{
				int fix=(c/w)-1;
				int rem=c-(w*fix);
				if(rem/w<2 && c%w!=0)
					res=fix+w+1;
				else
					res=fix+w;

			}
			}
			fres=(c/w)*(r-1)+res;
					

			

			
			System.out.println("testcase:"+testCase+" "+fres);
			pw.printf("Case #" + testCase + ": "+ fres+"\n");
			pw.flush();
		}

		pw.close();
		sc.close();
	}
}