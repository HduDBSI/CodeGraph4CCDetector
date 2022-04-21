package googlejam8.p743;
import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
public class A {
  static Scanner sc;
  static StringBuilder resultat = new StringBuilder("");
  
  static String lettres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  
  public static void main(String[] args) throws IOException {
    String pb = "A";
    sc = new Scanner(new FileReader(new File(pb+".in")));
    PrintWriter out = new PrintWriter(new File(pb+".out"));
    
		//TEST CASES----------------------------------------------------
		int TC = sc.nextInt();sc.nextLine();
    for (int tc = 1; tc <= TC; tc++) {
      if(tc!=1) resultat.append("\n");
      resultat.append("Case #"+tc+": ");
      
      //READ----------------------------------------------------
	    int N = sc.nextInt();
	    long[] P = new long[N];
	    long sum = 0;
	    long count = 0;
	    for (int i = 0; i < P.length; i++)
	    {
	      P[i] = sc.nextLong();
	      sum+=P[i];
	      if(P[i]>0)
	        count++;
	    }
	    
	    //SOLVE----------------------------------------------------
	    String res = ""; // long res = 0;
	    
	    
	//    System.out.println("\n\n");
	    while(true){
	      
	      long Max = 0;
	      int i1 = -1;
	      
	//      System.out.println(count + " " + sum+" -- " + res);
	      
	      if(count==2 && sum>2){
	        ArrayList<Integer> ind = new ArrayList<>();
	        for (int i = 0; i < P.length; i++)
	        {
	          if(P[i]!=0)
	            ind.add(i);
	        }
	        
	        res+= lettres.charAt(ind.get(0))+""+lettres.charAt(ind.get(1))+" ";
	        P[ind.get(0)]--;
	        P[ind.get(1)]--;
	        sum-=2;
	        continue;
	      }
	      
	      
	      if(sum==2){
	        ArrayList<Integer> ind = new ArrayList<>();
	        for (int i = 0; i < P.length; i++)
	        {
	          if(P[i]!=0)
	            ind.add(i);
	        }
	        
	        res+= lettres.charAt(ind.get(0))+""+lettres.charAt(ind.get(1));
	        break;
	      }
	      
	      else{
	        for (int i = 0; i < P.length; i++)
	        {
	          if(P[i]>Max){
	            Max = P[i];
	            i1=i;
	          }
	        }
	        
	        if(i1==-1)
	          break;
	        else{
	          res += lettres.charAt(i1)+" ";
	          P[i1]--;
	          sum--;
	        }
	      }
	    }
	    
	    //PRINT----------------------------------------------------
	    resultat.append(res.trim());
		}
		
    //CLOSE----------------------------------------------------
		out.print(resultat);
		System.out.println(resultat);
		out.close(); sc.close();
		}
	}