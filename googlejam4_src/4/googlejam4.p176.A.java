package googlejam4.p176;
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
	  int r1 = r.sc.nextInt();
	int c = r.sc.nextInt();
	String[] map = new String[r1];
	for (int i2 = 0; i2 < r1; i2++) {
	  map[i2] = r.sc.next();
	}
	boolean[][][] limit = new boolean[r1][c][4];
	for (int i4 = 0; i4 < r1; i4++) {
	  int j = 0;
	  // left
	  for (j = 0; j < c; j++) {
	    if (map[i4].charAt(j) != '.') {
	      break;
	    }
	  }
	  if (j < c) {
	    limit[i4][j][0] = true;
	  }
	  // right
	  for (j = c - 1; j >= 0; j--) {
	    if (map[i4].charAt(j) != '.') {
	      break;
	    }
	  }
	  if (j >= 0) {
	    limit[i4][j][1] = true;
	  }
	}
	for (int j = 0; j < c; j++) {
	  int i1 = 0;
	  // top
	  for (i1 = 0; i1 < r1; i1++) {
	    if (map[i1].charAt(j) != '.') {
	      break;
	    }
	  }
	  if (i1 < r1) {
	    limit[i1][j][2] = true;
	  }
	  // bottom
	  for (i1 = r1 - 1; i1 >= 0; i1--) {
	    if (map[i1].charAt(j) != '.') {
	      break;
	    }
	  }
	  if (i1 >= 0) {
	    limit[i1][j][3] = true;
	  }
	}
	int res = 0;
	boolean ok = true;
	for (int i3 = 0; i3 < r1; i3++) {
	  for (int j = 0; j < c; j++) {
	    if (limit[i3][j][0] && limit[i3][j][1] && limit[i3][j][2] && limit[i3][j][3]) {
	      ok = false;
	      break;
	    }
	    switch (map[i3].charAt(j)) {
	      case '<':
	        if (limit[i3][j][0]) {
	          res++;
	        }
	        break;
	      case '>':
	        if (limit[i3][j][1]) {
	          res++;
	        }
	        break;
	      case '^':
	        if (limit[i3][j][2]) {
	          res++;
	        }
	        break;
	      case 'v':
	        if (limit[i3][j][3]) {
	          res++;
	        }
	      default:
	        break;
	    }
	  }
	}
	r.out.write(ok ? Integer.toString(res) : "IMPOSSIBLE");
	r.out.newLine();
	r.out.flush();
	}
	r.sc.close();
	r.out.close();
  }
}
