package googlejam1.p746;
import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

public class MM {
	public static void main(String[] args) throws IOException {
    String        pb        = "MM";
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
      int N = sc.nextInt();
      
      long[] v = new long[N];
      long R = 0;
      long S1 = 0;
      v[0] = sc.nextLong();
      for (int i = 1; i < N; i++){   
        v[i] = sc.nextLong();
        if(v[i]<v[i-1])
          S1 += v[i-1] - v[i];
        
        if(v[i-1] - v[i]>R)
          R = v[i-1] - v[i];
      }
			
			//SOLVE----------------------------------------------------
			long res = 0;
			long S2 = 0;
			for (int i = 0; i < N-1; i++){   
        S2 += min(v[i],R);
      }
			
      //PRINT--------------------------------------------------
			System.out.println(S1+" "+S2);
			resultat.append(S1+" "+S2);
			System.out.println("Finished testcase " + tc + ", time = " + (System.currentTimeMillis() - time));
		}
		
    //CLOSE----------------------------------------------------
		out.print(resultat);
		out.close(); sc.close();
	}


}