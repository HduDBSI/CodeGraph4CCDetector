package googlejam3.p305;


import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class A {

	Scanner sc = new Scanner(getClass().getResourceAsStream(IN));
	static final String FILENAME = "A-large";
	// static final String FILENAME = "A-small-attempt0";
	static final String IN = FILENAME + ".in";
	static final String OUT = FILENAME + ".out";
	PrintStream out;

	public static void main(String args[]) throws Exception {
		A r = new A();
		r.sc.useLocale(Locale.US);
		
		r.out = new PrintStream(new FileOutputStream(A.OUT));
		
		int t = r.sc.nextInt();
		for (int i = 1; i <= t; i++) {
			r.sc.nextLine();
			r.out.print("Case #" + i + ": ");
			int R = r.sc.nextInt();
			int C = r.sc.nextInt();
			int W = r.sc.nextInt();
			int m = C / W;
			m=m*R;
			if (C % W!=0)
				m++;
			m=m+(W-1);
			r.out.print(m);
			r.out.println();
		}
		r.sc.close();
		r.out.close();
	}

}