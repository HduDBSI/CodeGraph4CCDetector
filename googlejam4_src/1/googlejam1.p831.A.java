package googlejam1.p831;
//Problem A - Code Jam Round 1A
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class A {

  static final String FILENAME = "input";
  static final String IN = FILENAME + ".in";
  static final String OUT = "output.out";
  Scanner sc;
  BufferedWriter out;

public int absVal =0;
  public static void main(String args[]) throws Exception {
    A r = new A();
	r.sc = new Scanner(new File(A.IN));
	r.out = new BufferedWriter(new FileWriter(A.OUT));
	int t = Integer.parseInt(r.sc.nextLine());
	for (int i = 1; i <= t; i++) {
	  r.out.write("Case #" + i + ": ");
	  int a=0;
	int b=0;
	r.absVal=0;
	int d = Integer.parseInt(r.sc.nextLine());
	String[] tmp = r.sc.nextLine().split(" ");
	int[] tmpInt = new int[tmp.length];
	for (int i1 = 0; i1 < d; i1++) {
	
	    tmpInt[i1] = Integer.parseInt(tmp[i1]);
	}
	int x = tmpInt[0];
	  int a1=0;
	  for(int i1=1;i1<tmpInt.length;i1++)
	  {
		  if (tmpInt[i1]<x)
		  {
			  a1 = a1 + x - tmpInt[i1];
			  r.absVal = Math.max(r.absVal, Math.abs(x-tmpInt[i1]));
		  }
		  x = tmpInt[i1]; 
	  }
	a = a1;
	int ans=0;
	  for(int i1=0;i1<tmpInt.length -1;i1++)
	  {
		  if (tmpInt[i1]<=r.absVal)
		  {
			  ans = ans + tmpInt[i1];
		  }
		  else if(tmpInt[i1]>r.absVal)
		  {
			  ans = ans + r.absVal;
		  }
	  }
	b = ans;
	r.out.write(Integer.toString(a) + " " +Integer.toString(b));
	r.out.newLine();
	r.out.flush();
	}
	r.sc.close();
	r.out.close();
  }
}
