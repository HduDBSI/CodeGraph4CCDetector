package googlejam6.p719;
import java.util.*;
import static java.lang.Math.*;

import java.io.File;
import java.io.PrintStream;


public class B {
	
	public static String FILENAME = "B-small-attempt0";

	public static String INPATH =  "res/" + FILENAME + ".in";
	public static String OUTPATH = "res/" + FILENAME + ".out";
	
	public static void main(String[] args) throws Exception {
		
		String workingDir = System.getProperty("user.dir");
		
		System.setOut(new PrintStream(new File(workingDir,OUTPATH)));
		Scanner in = new Scanner(new File(workingDir,INPATH));
		
		int T = in.nextInt();
		
		for(int zz = 1; zz <= T;zz++){
			
			int size = in.nextInt();

			int[] number = new int[2500];
			
			for(int i = 0; i < 2*size - 1; i++) {
				
				for(int j = 0; j < size; j++) {
					int num = in.nextInt();
					number[num] = number[num] + 1;
				}
			}
			
			System.out.format("Case #%d:", zz);
			
			for(int i = 0; i < 2500; i++) {
				if(number[i] % 2 != 0)
					System.out.format(" %d", i);
			}

			System.out.format("\n");
			
		}
		
		in.close();
	}
}
