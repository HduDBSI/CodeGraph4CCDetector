package googlejam3.p340;


import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class R20151C_A {
	
	private int t;
	
	public static void main(String[] args) {
		R20151C_A r = new R20151C_A();
		File folder = new File(r.getClass().getSimpleName() + "_cases");
		File inFolder = new File(r.getClass().getSimpleName() + "_cases" + "/in");
		File outFolder = new File(r.getClass().getSimpleName() + "_cases" + "/out");
		
		if (!folder.isDirectory()) {
			folder.mkdir();
		}
		if (!outFolder.isDirectory()) {
			outFolder.mkdir();
		}
		if (!inFolder.isDirectory()) {
			inFolder.mkdir();
		}
		
		for (String in : inFolder.list()) {
			String fileNameCore = in.replace(".in", "");
			String outFileName = fileNameCore + ".out";
			
			
			PrintStream ps = null;
			Scanner s = null;
			try {
				File inFile = new File(r.getClass().getSimpleName() + "_cases" + "/in" + "/" + in);
				File outFile = new File(r.getClass().getSimpleName() + "_cases" + "/out" + "/" + outFileName);
				
				ps = new PrintStream(outFile);
				s = new Scanner(inFile);
				
				r.t = s.nextInt();
				for (int i = 0; i < r.t; i++) {
					ps.print("Case #" + (i+1) + ": ");
					r.R = s.nextInt();
					r.C = s.nextInt();
					r.W = s.nextInt();
					r.m = (r.C / r.W) * (r.R - 1);
					r.m += Math.max(((r.C - 1) / r.W) - 1, 0);
					r.m += r.W + (r.W == r.C? 0 : 1);
					ps.println(r.m);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (s != null) {
					s.close();
				}
				
				if (ps != null) {
					ps.close();
				}
			}
				
			
		}
	}
	
	private int R;
	
	private int C;
	
	private int W;
	
	private int m;


}
