package googlejam8.p405;
import java.lang.Integer;
import java.util.*;
import java.io.*;
import java.util.Collection;
import java.util.HashMap;

public class a {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for(int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      ArrayList<Integer> p = new ArrayList<Integer>();
      int sum = 0;
      for(int j=0;j<N;j++){
        int temp = in.nextInt();
        p.add(temp);
        sum+=temp;
      }

      System.out.print("Case #" + i + ": ");
      while(sum>0){
        int index = 0;
        int max = 0;
        for(int k=0;k<p.size();k++){
          if(p.get(k)>max){
            max = p.get(k);
            index = k;
          }
        }
        System.out.print(str.charAt(index));
        sum--;
        p.set(index, p.get(index) - 1);
        if(sum!=2){
          max = 0;
          for(int k=0;k<p.size();k++){
            if(p.get(k)>max){
              max = p.get(k);
              index = k;
            }
          }
          System.out.print(str.charAt(index));
          sum--;
          p.set(index, p.get(index) - 1);
        }
        System.out.print(" ");
      }
  System.out.print("\n");



    }
  }
}