package googlejam6.p121;
import static java.lang.Math.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class B {
	Scanner scan;

	public B(Scanner s) {
		scan = s;
	}
	
	public static void main(String[] args) throws Exception{
		Locale.setDefault(Locale.US);
		String cn = "src/"+B.class.getName();
		String sampleName = cn+"-sample.in";
		String smallName = cn+"-small-attempt0.in";
		String largeName = cn+"-large.in";
		String name = largeName;
		String outName = name.substring(0, name.indexOf('.'))+".out";
		InputStream in = new BufferedInputStream(new FileInputStream(name));
		PrintStream out = new PrintStream(new File(outName));
		//PrintStream out = System.out;
		Scanner scan = new Scanner(in);
		
		int N = Integer.parseInt(scan.nextLine());
		for(int c=1;c<=N;c++) {
			B r = new B(scan);
			int n = r.scan.nextInt();
			int[]C = new int[3000];
			for(int i=0;i<n*(2*n-1);i++){
				int x = r.scan.nextInt();
				C[x]++;
			}
			String res1="";
			for(int i=0;i<C.length;i++){
				if(C[i]%2==1)res1+= i+ " ";
			}
			String res = res1;
			out.printf("Case #%d: %s\n",c, res);
			if(out!=System.out)System.err.println(c + " done");
		}
		if(out!=System.out)System.err.println("All done");
		
	}
}
