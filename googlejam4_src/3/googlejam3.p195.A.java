package googlejam3.p195;
import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

public class A {
	public static void main(String[] args) throws IOException {
    String        pb        = "A";
    Scanner       sc        = new Scanner(new FileReader(new File(pb+".in")));
    PrintWriter   out       = new PrintWriter(new File(pb+".out"));
		StringBuilder resultat  = new StringBuilder("");
		long time = System.currentTimeMillis();
		
		//TEST CASES----------------------------------------------------
		int TC = sc.nextInt();
    for (int tc = 1; tc <= TC; tc++) {
      if(tc!=1) resultat.append("\n");
      resultat.append("Case #"+tc+": ");
    
      //READ----------------------------------------------------
      int R = sc.nextInt();
      int C = sc.nextInt();
      int W = sc.nextInt();
      
      
			//SOLVE----------------------------------------------------
			long res = 0;
			
			res += (C/W)*(R-1);
			res += C/W-1;
			
			long d = W+C%W;
			if(d==W)
			  res+=W;
			else
			  res+=W+1;
			
      //PRINT--------------------------------------------------
			System.out.println(res);
			resultat.append(res);
			System.out.println("Finished testcase " + tc + ", time = " + (System.currentTimeMillis() - time));
		}
		
    //CLOSE----------------------------------------------------
		out.print(resultat);
		out.close(); sc.close();
	}

}