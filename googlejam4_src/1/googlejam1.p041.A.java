package googlejam1.p041;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class A {

  static final String FILENAME = "A-large";
  static final String IN = FILENAME + ".in";
  static final String OUT = FILENAME + ".out";
  Scanner sc;
  BufferedWriter out;

  public static void main(String args[]) throws Exception {
    A r = new A();
	r.sc = new Scanner(new File(A.IN));
	r.out = new BufferedWriter(new FileWriter(A.OUT));
	int t = Integer.parseInt(r.sc.nextLine());
	for (int i = 1; i <= t; i++) {
	  r.out.write("Case #" + i + ": ");
	  int n = r.sc.nextInt();
	int[] m = new int[n];
	for(int i1 = 0; i1 < n; i1++) {
	  m[i1] = r.sc.nextInt();
	}
	int sum1 = 0;
	int cur = m[0];
	for(int i4 = 1; i4 < n; i4++) {
	  if(m[i4] < cur) {
	    sum1 += cur - m[i4];
	  }
	  cur = m[i4];
	}
	r.out.write(Integer.toString(sum1) + " ");
	
	int max = 0;
	for(int i2 = 1; i2 < n; i2++) {
	  if(max < m[i2 - 1] - m[i2]) {
	    max = m[i2 - 1] - m[i2];
	  }
	}
	int sum2 = 0;
	for(int i3 = 0; i3 < n - 1; i3++) {
	  sum2 += Math.min(max, m[i3]);
	}
	r.out.write(Integer.toString(sum2));
	r.out.newLine();
	r.out.flush();
	}
	r.sc.close();
	r.out.close();
  }
}
