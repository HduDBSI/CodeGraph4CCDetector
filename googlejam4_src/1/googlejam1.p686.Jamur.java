package googlejam1.p686;
// Template by fikr
// Google Code Jam Round 1A 2015
// Problem ...........

import java.util.*;
import java.io.*;

public class Jamur{
    static String filename = "A-large";	// io filnename here
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
                int kurang = 0;
                int temp[] = new int[10000];
                int satu = 0;
                int dua = 0;
                int best = 0;
                int rep = in.nextInt();
                kurang = in.nextInt();
                int first = kurang;
                for (int i = 0; i < rep-1;i++){
                    temp[i] = in.nextInt();
                    int tempor = kurang - temp[i];
                    if (tempor > best) best = tempor;
                    kurang = temp[i];
                    //System.out.println("tempor " + tempor);
                    if (tempor >= 0) satu += tempor;
                }
                if (first < best) dua += first;
                    else dua += best;
                for (int i = 0; i < rep-2;i++){
                    if (temp[i] < best) dua += temp[i];
                    else dua += best;
                }
                //System.out.print("Case #" + cas + ": " + satu + " " + dua + "\n");
                out.write("Case #" + cas + ": " + satu + " " + dua + "\n");
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}