package googlejam3.p551;
// Template by fikr
// Google Code Jam Round 1A 2015
// Problem ...........

import java.util.*;
import java.io.*;

public class Bratteship{
    //static String filename = "file";
    static String filename = "A-small-attempt2";	// io filnename here
    static String inname = filename + ".in";    
    static String outname = filename + ".out";  
    static int n;
    public static void main(String[] args){
        try{
            Scanner in = new Scanner(new BufferedReader(new FileReader(inname)));
            //Scanner in = new Scanner(System.in);
            BufferedWriter out = new BufferedWriter(new FileWriter(outname));
            int t = in.nextInt();
            in.nextLine();
            for (int cas = 1; cas <= t; cas++){
            	//String ans = "";
                //String g = in.nextLine();
                
                int r = in.nextInt();
                int c = in.nextInt();
                int saize = in.nextInt();
                
                
                int ans = 0;
                
                ans += c/saize;
                ans *= r;
                if ((c%saize!=0)&&(saize!=r)) ans += 1;
                ans += saize - 1;
                
                //System.out.print("Case #" + cas + ": " + ans + "\n");
                out.write("Case #" + cas + ": " + ans + "\n");
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}