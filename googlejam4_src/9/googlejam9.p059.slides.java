package googlejam9.p059;
import java.io.*;
import java.util.*;
public class slides{
   private static String fileName = "B-small";
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader(fileName+".in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName+".out")));
      int Num=Integer.parseInt(f.readLine());
      for(int ind=0;ind<Num;ind++){
         String[] inar=f.readLine().split(" ");
         long B = Long.parseLong(inar[0]);
         long M = Long.parseLong(inar[1]);
         
         if(M>Math.pow(2,B-2))
            out.println("Case #"+(ind+1)+": IMPOSSIBLE");
         else{
            long T = (long)Math.pow(2,B-2)-M;
            int[] connected=new int[(int)B];
            for(int x=0;x<B;x++)
               connected[x]=1;
            String bin = Long.toBinaryString(T);
            int i=1;
            for(int x=bin.length()-1;x>=0;x--){
               if(bin.substring(x,x+1).compareTo("1")==0)
                  connected[i]=0;
               i++;
            }
                 
            out.println("Case #"+(ind+1)+": POSSIBLE");
            for(int x=0;x<B-1;x++){
               for(int y=0;y<=x;y++)
                  out.print("0");
               for(int y=x+1;y<B-1;y++)
                  out.print("1");
               out.print(connected[x]);
               out.print("\n");
            }
            for(int x=0;x<B;x++)
               out.print("0");
            out.print("\n");
         }
      }
      out.close();
   }
}
