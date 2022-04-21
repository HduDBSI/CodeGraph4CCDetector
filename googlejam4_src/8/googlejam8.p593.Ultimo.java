package googlejam8.p593;
import java.util.*;
import java.io.*;
public class Ultimo {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      String ris = "";
      String v[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
      int n = in.nextInt();
      String p[] = new String[1001];
      
      for(int j = 0; j < 1001; j ++)
    	  p[j] = "";
      
      for(int j = 0; j < n; j ++)
      {
    	  int k = in.nextInt();
    	  p[k] += v[j];
      }
      
      for(int j = 1000; j > 0; j --)
      {
    	  if(!p[j].equals(""))
    	  {
    		  if(p[j].length() % 2 != 0)
    			  ris += p[j].substring(p[j].length() - 1, p[j].length()) + " ";
    		  
              for(int x = 0; x < p[j].length() - 1; x += 2)
              {
            	  ris += p[j].charAt(x) + "" + p[j].charAt(x + 1) + " ";
              }
              
              p[j - 1] += p[j];
    	  }
      }
      
      System.out.println("Case #" + i + ": " + ris);
    }
  }
}